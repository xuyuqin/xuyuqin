package io.yun.controller;

import io.unicall.entity.SysRegisterEntity;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;
import io.unicall.utils.ShiroUtils;
import io.yun.entity.*;
import io.yun.service.*;
import io.yun.utils.FileUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 供应商后台管理
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-07-06 16:45:27
 */
@RestController
@RequestMapping("yun/providermanage")
public class TYunProviderManageController {
	@Autowired
	private TYunProviderService tYunProviderService;
    @Autowired
    private FileUtils fileUtils;
    @Autowired
    private TYunMarketingService tYunMarketingService;
    @Autowired
    private TYunDemandService tYunDemandService;
    @Autowired
    private TYunMerchandiseService tYunMerchandiseService;
    @Autowired
    private TYunMerchandiseImageService tYunMerchandiseImageService;

	/**
     * 我的供应信息
     */
    @RequestMapping("/myinfo")
    public R Myinfo() {
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null){
            return R.error("请先登入");
        }
        if(!(member.getIsProvider()==1)){
            return R.error("请先成为供应商");
        }
        TYunProviderEntity tYunProvider = tYunProviderService.findByMemberId(member.getId().toString());
        if(tYunProvider==null){
            return R.error("供应商信息不存在请联系管理员");
        }
        return R.ok().put("tYunProvider", tYunProvider);
    }
    /**
     * 修改供应基本信息
     */
    @RequestMapping("/edit")
    public R edit(TYunProviderEntity provider,String productIds,
                  @RequestParam(name = "logofile",required = false) MultipartFile file) throws IOException {
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null){
            return R.error("请先登入");
        }
        if(!(member.getIsProvider()==1)){
            return R.error("请先成为供应商");
        }
        TYunProviderEntity tYunProvider = tYunProviderService.findByMemberId(member.getId().toString());
        if(tYunProvider==null){
            return R.error("供应商信息不存在请联系管理员");
        }
        provider.setId(tYunProvider.getId());

        //更新logo
        if (file!=null&&!file.isEmpty()) {
            String path = "供应商logo/"+member.getId()+"/";
            String url = fileUtils.upload(file,path);
            provider.setLogo(url);
        }
        try{
            tYunProviderService.update(provider);
        }catch(Exception e){
        }

        //当productIds变动时，更新主营产品
        if(!productIds.trim().equals(tYunProvider.getProductIds())){
            String[] productId = productIds.trim().split(",");
            List list = Arrays.asList(productId);
            Set<String> set = new HashSet<String>(list);

            String[] productId0 = tYunProvider.getProductIds().split(",");
            List list0 = Arrays.asList(productId0);
            Set<String> set0 = new HashSet<String>(list0);

            Set subset = new  HashSet();
            subset.clear();
            subset.addAll(set);
            subset.retainAll(set0);

            set.removeAll(subset);
            set0.removeAll(subset);

            for (String s : set) {
                tYunProviderService.saveProduct(tYunProvider.getId(),s);
            }
            if(!set0.isEmpty()){
                tYunProviderService.deleteProduct(tYunProvider.getId(),set0);
            }
        }
        tYunProvider = tYunProviderService.findByMemberId(member.getId().toString());
        return R.ok("修改成功").put("afterupdate",tYunProvider);
    }
    /**
     * 查看营销管理信息
     */
    @RequestMapping("/mymarket")
    public R myMarket(){
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null){
            return R.error("请先登入");
        }
        if(!(member.getIsProvider()==1)){
            return R.error("请先成为供应商");
        }
        Map<String, Object> params = new HashMap <String, Object>();
        params.put("memberId",member.getId().toString());
        List<TYunMarketingEntity> tYunMarketingList = tYunMarketingService.queryList(params);
        List<Map<String,Integer>> statusnum = tYunMarketingService.queryStatus(params);
        return R.ok().put("statusnum",statusnum).put("list", tYunMarketingList);
    }

    /**
     * 营销管理信息详情
     */
    @RequestMapping("/mymarketinfo")
    public R info(String id){
        TYunMarketingEntity tYunMarketing = tYunMarketingService.queryObject(id);

        return R.ok().put("tYunMarketing", tYunMarketing);
    }

    /**
     * 创建营销管理活动
     */
    @RequestMapping("/mymarketcreate")
    public R mymarketcreate(TYunMarketingEntity tYunMarketing,String merchandiseIds){
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null){
            return R.error("请先登入");
        }
        if(!(member.getIsProvider()==1)){
            return R.error("请先成为供应商");
        }
        TYunProviderEntity tYunProvider = tYunProviderService.findByMemberId(member.getId().toString());
        if(tYunProvider==null){
            return R.error("供应商信息不存在请联系管理员");
        }
        String id = UUID.randomUUID().toString().replace("-","");
        tYunMarketing.setId(id);
        tYunMarketing.setProviderId(tYunProvider.getId());
        tYunMarketing.setCreateTime(new Date());

        String[] merchandiseId = merchandiseIds.split(",");
        for(int i=0;i<merchandiseId.length;i++){
            //TODO 商品验证
            tYunMarketingService.saveMerchandise(id,merchandiseId[i]);
        }
        tYunMarketingService.save(tYunMarketing);

        TYunMarketingEntity r = tYunMarketingService.queryObject(id);
        return R.ok().put("save", r);
    }

    /**
     * 修改营销管理活动
     */
    @RequestMapping("/mymarketedit")
    public R mymarketedit(TYunMarketingEntity tYunMarketing,String merchandiseIds){
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null){
            return R.error("请先登入");
        }
        if(!(member.getIsProvider()==1)){
            return R.error("请先成为供应商");
        }
        TYunProviderEntity tYunProvider = tYunProviderService.findByMemberId(member.getId().toString());
        if(tYunProvider==null){
            return R.error("供应商信息不存在请联系管理员");
        }
        TYunMarketingEntity r = tYunMarketingService.queryObject(tYunMarketing.getId());
        if(!tYunProvider.getId().equals(r.getProviderId())){
            return R.error("只能修改自己创建的活动");
        }
        tYunMarketing.setUpdateTime(new Date());

        String id = tYunMarketing.getId();
        //当merchandiseIds变动时，更新活动商品
        if(!merchandiseIds.trim().equals(r.getMerchandiseIds())){
            String[] merchandiseId = merchandiseIds.split(",");
            List list = Arrays.asList(merchandiseId);
            Set<String> set = new HashSet<String>(list);

            String[] merchandiseId0 = r.getMerchandiseIds().split(",");
            List list0 = Arrays.asList(merchandiseId0);
            Set<String> set0 = new HashSet<String>(list0);

            Set subset = new  HashSet();
            subset.clear();
            subset.addAll(set);
            subset.retainAll(set0);

            set.removeAll(subset);
            set0.removeAll(subset);

            for (String s : set) {
                //TODO 商品验证
                tYunMarketingService.saveMerchandise(id,s);
            }
            if(!set0.isEmpty()){
                tYunMarketingService.deleteMerchandise(id,set0);
            }
        }
        tYunMarketingService.update(tYunMarketing);

        TYunMarketingEntity update = tYunMarketingService.queryObject(id);
        return R.ok().put("update", update);
    }

    /**
     * 修改营销管理活动
     */
    @RequestMapping("/mymarketdel")
    public R mymarketdel(String id) {
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if (member == null) {
            return R.error("请先登入");
        }
        if (!(member.getIsProvider() == 1)) {
            return R.error("请先成为供应商");
        }
        TYunProviderEntity tYunProvider = tYunProviderService.findByMemberId(member.getId().toString());
        if (tYunProvider == null) {
            return R.error("供应商信息不存在请联系管理员");
        }
        TYunMarketingEntity r = tYunMarketingService.queryObject(id);
        if (!tYunProvider.getId().equals(r.getProviderId())) {
            return R.error("只能删除自己创建的活动");
        }
        tYunMarketingService.delete(id);
        tYunMarketingService.deleteAllMerchandise(id);
        return R.ok("删除成功!");
    }

    /**
     * 询盘管理——询盘查询
     */
    @RequestMapping("/myxunpan")
    public R myxunpan() {
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if (member == null) {
            return R.error("请先登入");
        }
        if (!(member.getIsProvider() == 1)) {
            return R.error("请先成为供应商");
        }
        TYunProviderEntity tYunProvider = tYunProviderService.findByMemberId(member.getId().toString());
        if (tYunProvider == null) {
            return R.error("供应商信息不存在请联系管理员");
        }
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("providerId",tYunProvider.getId());
        List<TYunDemandEntity> tYunDemandList = tYunDemandService.queryList(params);
//TODO dto
        return R.ok().put("list",tYunDemandList);
    }

    /**
     * 查看我的商品信息
     */
    @RequestMapping("/myMerchandise")
    public R myMerchandise(@RequestParam Map<String, Object> params){
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null){
            return R.error("请先登入");
        }
        if(!(member.getIsProvider()==1)){
            return R.error("请先成为供应商");
        }
        TYunProviderEntity tYunProvider = tYunProviderService.findByMemberId(member.getId().toString());
        if (tYunProvider == null) {
            return R.error("供应商信息不存在请联系管理员");
        }

        params.put("providerid",tYunProvider.getId());
        params.put("insale",1);
        Query query = new Query(params);
        List<TYunMerchandiseEntity> insalelist0 = tYunMerchandiseService.queryList(query);
        int insale = tYunMerchandiseService.queryTotal(query);
        PageUtils insalelist = new PageUtils(insalelist0, insale, query.getLimit(), query.getPage());

        params.clear();
        params.put("providerid",tYunProvider.getId());
        params.put("insale",0);
        query = new Query(params);
        List<TYunMerchandiseEntity> notinsalelist0 = tYunMerchandiseService.queryList(query);
        int notinsale = tYunMerchandiseService.queryTotal(query);
        PageUtils notinsalelist = new PageUtils(notinsalelist0, notinsale, query.getLimit(), query.getPage());

        return R.ok().put("insalelist",insalelist).put("notinsalelist",notinsalelist);
    }

    /**
     * 查看商品详情
     */
    @RequestMapping("/myMerchandiseDetail")
    public R myMerchandiseDetail(String id){
        TYunMerchandiseEntity tYunMerchandiseEntity = tYunMerchandiseService.queryObject(id);
        List<TYunMerchandiseImageEntity> images = tYunMerchandiseImageService.getByMerchandiseId(id);
        return R.ok().put("Merchandise",tYunMerchandiseEntity).put("images",images);
    }

    /**
     * 商品发布
     */
    @RequestMapping("/myMerchandiseCreate")
    public R myMerchandiseCreate(TYunMerchandiseEntity tYunMerchandise,MultipartFile[] imgfile) throws IOException {
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null){
            return R.error("请先登入");
        }
        if(!(member.getIsProvider()==1)){
            return R.error("请先成为供应商");
        }
        TYunProviderEntity tYunProvider = tYunProviderService.findByMemberId(member.getId().toString());
        if (tYunProvider == null) {
            return R.error("供应商信息不存在请联系管理员");
        }
        String id = UUID.randomUUID().toString().replace("-","");
        tYunMerchandise.setId(id);
        tYunMerchandise.setCreateTime(new Date());
        tYunMerchandise.setProviderId(tYunProvider.getId());
        tYunMerchandiseService.save(tYunMerchandise);

        //保存图片
        int imgnum = imgfile.length;
        for (int i = 0;i<imgnum;i++) {
            String path = "商品图片/"+tYunProvider.getName()+"/"+id+"/"+i+"/";
            String url = fileUtils.upload(imgfile[i],path);
            tYunMerchandiseService.saveImg(id,url);
        }
        return R.ok("发布成功");
    }

    /**
     * 商品发布
     */
    @RequestMapping("/myMerchandiseEdit")
    public R myMerchandiseEdit(TYunMerchandiseEntity tYunMerchandise){
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null){
            return R.error("请先登入");
        }
        TYunProviderEntity tYunProvider = tYunProviderService.findByMemberId(member.getId().toString());
        if (tYunProvider == null) {
            return R.error("供应商信息不存在请联系管理员");
        }
        TYunMerchandiseEntity tYunMerchandiseEntity = tYunMerchandiseService.queryObject(tYunMerchandise.getId());
        if(tYunMerchandiseEntity==null||!tYunMerchandiseEntity.getProviderId().equals(tYunProvider.getId())){
            return R.error("商品不存在或无更新权限");
        }
        tYunMerchandise.setUpdateTime(new Date());
        tYunMerchandiseService.update(tYunMerchandise);

        TYunMerchandiseEntity afterupdate = tYunMerchandiseService.queryObject(tYunMerchandise.getId());
        return R.ok("更新成功").put("afterupdate",afterupdate);
    }

    /**
     * 删除商品图片
     */
    @RequestMapping("/deleteMerchandiseImg")
    public R deleteMerchandiseImg(String ids,String merchandiseId){
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null){
            return R.error("请先登入");
        }
        TYunProviderEntity tYunProvider = tYunProviderService.findByMemberId(member.getId().toString());
        if (tYunProvider == null) {
            return R.error("供应商信息不存在请联系管理员");
        }
        TYunMerchandiseEntity tYunMerchandiseEntity = tYunMerchandiseService.queryObject(merchandiseId);
        if(tYunMerchandiseEntity==null||!tYunMerchandiseEntity.getProviderId().equals(tYunProvider.getId())){
            return R.error("商品不存在或无更新权限");
        }
        //验证图片是否为该商品图片
        String[] id = ids.split(",");
        int total = tYunMerchandiseImageService.queryTotal(id,merchandiseId);
        int n = id.length;
        if(n!=total){
            return R.error("该操作不合法");
        }

        tYunMerchandiseImageService.deleteBatch(id);
        return R.ok();
    }

    /**
     * 商品图片添加
     */
    @RequestMapping("/addMerchandiseImg")
    public R addMerchandiseImg(String merchandiseId,MultipartFile[] imgfile) throws IOException {
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null){
            return R.error("请先登入");
        }
        if(!(member.getIsProvider()==1)){
            return R.error("请先成为供应商");
        }
        TYunProviderEntity tYunProvider = tYunProviderService.findByMemberId(member.getId().toString());
        if (tYunProvider == null) {
            return R.error("供应商信息不存在请联系管理员");
        }
        TYunMerchandiseEntity tYunMerchandiseEntity = tYunMerchandiseService.queryObject(merchandiseId);
        if(tYunMerchandiseEntity==null||!tYunMerchandiseEntity.getProviderId().equals(tYunProvider.getId())){
            return R.error("商品不存在或无更新权限");
        }
        //保存图片
        int imgnum = imgfile.length;
        String uuid = UUID.randomUUID().toString();
        for (int i = 0;i<imgnum;i++) {
            String path = "商品图片/"+tYunProvider.getName()+"/"+merchandiseId+"/"+uuid+"/"+i+"/";
            String url = fileUtils.upload(imgfile[i],path);
            tYunMerchandiseService.saveImg(merchandiseId,url);
        }
        return R.ok("成功");
    }

    /**
     * 商品上下架
     */
    @RequestMapping("/myMerchandiseSale")
    public R myMerchandiseSale(String merchandiseId,Integer sale){
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null){
            return R.error("请先登入");
        }
        TYunProviderEntity tYunProvider = tYunProviderService.findByMemberId(member.getId().toString());
        if (tYunProvider == null) {
            return R.error("供应商信息不存在请联系管理员");
        }
        TYunMerchandiseEntity tYunMerchandiseEntity = tYunMerchandiseService.queryObject(merchandiseId);
        if(tYunMerchandiseEntity==null||!tYunMerchandiseEntity.getProviderId().equals(tYunProvider.getId())){
            return R.error("商品不存在或无更新权限");
        }
        TYunMerchandiseEntity tYunMerchandise = new TYunMerchandiseEntity();
        tYunMerchandise.setId(tYunMerchandise.getId());
        tYunMerchandise.setInSale(sale);
        tYunMerchandiseService.update(tYunMerchandise);

        return R.ok("操作成功");
    }

    /**
     * 删除商品
     */
    @RequestMapping("/deleteMerchandise")
    public R deleteMerchandise(String merchandiseId){
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null){
            return R.error("请先登入");
        }
        TYunProviderEntity tYunProvider = tYunProviderService.findByMemberId(member.getId().toString());
        if (tYunProvider == null) {
            return R.error("供应商信息不存在请联系管理员");
        }
        TYunMerchandiseEntity tYunMerchandiseEntity = tYunMerchandiseService.queryObject(merchandiseId);
        if(tYunMerchandiseEntity==null||!tYunMerchandiseEntity.getProviderId().equals(tYunProvider.getId())){
            return R.error("商品不存在或无权限");
        }
        //TODO 删除与该商品相关的数据
//        tYunMerchandiseImageService.deleteBatch(id);
        tYunMerchandiseService.delete(merchandiseId);
        return R.ok();
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CustomDateEditor editor = new CustomDateEditor(df, false);
        binder.registerCustomEditor(Date.class, editor);
    }
}
