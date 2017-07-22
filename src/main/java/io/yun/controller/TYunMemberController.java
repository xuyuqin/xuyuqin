package io.yun.controller;

import io.unicall.entity.SysRegisterEntity;
import io.unicall.service.SysConfigService;
import io.unicall.service.SysRegisterService;
import io.unicall.utils.*;
import io.unicall.utils.oss.CloudStorageConfig;
import io.unicall.utils.oss.OSSFactory;
import io.yun.dto.MyInfoDto;
import io.yun.dto.MyTraderDto;
import io.yun.dto.ProviderDto;
import io.yun.entity.*;
import io.yun.service.*;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 会员表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-20 16:58:14
 */
@RestController
@RequestMapping("yun/member")
public class TYunMemberController {
	@Autowired
	private TYunMemberService tYunMemberService;
    @Autowired
    private SysRegisterService sysRegisterService;
	@Autowired
	private SMSService smsService;
    @Autowired
    private TYunMerchandiseService tYunMerchandiseService;
    @Autowired
    private TYunProviderService tYunProviderService;
    @Autowired
    private TYunMerchandiseCollectionService tYunMerchandiseCollectionService;
    @Autowired
    private TYunProviderCollectionService tYunProviderCollectionService;
    @Autowired
    private TYunMyProviderService tYunMyProviderService;
	/**
	 *会员中心我的订单
	 */
	@RequestMapping("/myorder")
	public R myorder(@RequestParam Map<String, Object> params){
		//判断是否登录
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
		if(member == null) {
			return R.error("请先登录！");
		}

		String memberId = String.valueOf(member.getId());
		params.put("memberId",memberId);
		Query query = new Query(params);
		List<TYunOrderEntity> tYunOrderList = tYunMemberService.orderList(query);
		int total = tYunMemberService.orderTotal(query);
		List<String> statusCount = tYunMemberService.orderStatusTotal(memberId);

		PageUtils pageUtils = new PageUtils(tYunOrderList, total, query.getLimit(), query.getPage());
		Map<String,Object> map = new HashedMap();
		map.put("orderCount",statusCount);
		map.put("page", pageUtils);
		return R.ok(map);
	}

	/**
	 *会员中心我的交易员
	 */
	@RequestMapping("/mytrader")
	public R mytrader(){
		//判断是否登录
		SysRegisterEntity member = ShiroUtils.getRegisterEntity();
		if(member == null) {
			return R.error("请先登录！");
		}
		MyTraderDto trader = new MyTraderDto(tYunMemberService.queryTrader(member.getTrader()));
		return R.ok().put("trader", trader);
	}

	/**
	 *会员中心我的信息
	 */
	@RequestMapping("/myinfo")
	public R myinfo(){
		//判断是否登录
		SysRegisterEntity member = ShiroUtils.getRegisterEntity();
		if(member == null) {
			return R.error("请先登录！");
		}
		member = sysRegisterService.queryObject1(member.getId());
		MyInfoDto info = new MyInfoDto(member);
		return R.ok().put("info", info);
	}

	/**
	 *会员中心我的信息
	 */
	@RequestMapping("/editmyinfo")
	public R editMyinfo(MyInfoDto myInfoDto, @RequestParam(name = "file",required = false) MultipartFile file) throws IOException {
		//判断是否登录
		SysRegisterEntity member = ShiroUtils.getRegisterEntity();
		if(member == null) {
			return R.error("请先登录！");
		}
		member = sysRegisterService.queryObject1(member.getId());
		myInfoDto.setEmailVerified(member.getEmailVerified());
		myInfoDto.setMobileVerified(member.getMobileVerified());
        if (file!=null&&!file.isEmpty()) {
            String url = OSSFactory.build().upload(file.getBytes(),
					((SysConfigService) SpringContextUtils.getBean("sysConfigService"))
							.getConfigObject(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class)
							.getQcloudPrefix()+ "image/" +member.getId()+"/"+file.getOriginalFilename());
            myInfoDto.setAvatar(url);
        }
        String mobile = myInfoDto.getMobile();
        if(mobile!=null&&mobile.trim()!=""&&!mobile.equals(member.getMobile())) {
			if(!smsService.isRegisted(mobile)){
				return R.error("该号码已被注册");
			}else{
				myInfoDto.setMobileVerified(1);
			}
		}
		if(myInfoDto.getEmail()!=null&&!myInfoDto.getEmail().equals(member.getEmail())){
            //TODO 邮箱验证
        	myInfoDto.setEmailVerified(0);
		}
		myInfoDto.setId(member.getId());
		tYunMemberService.update(myInfoDto);
        member = sysRegisterService.queryObject1(member.getId());
        MyInfoDto info = new MyInfoDto(member);
        return R.ok().put("info", info);
	}

    /**
     *会员中心我收藏——商品收藏
     */
    @RequestMapping("/mymerchandisecollection")
    public R mymerchandisecollection(@RequestParam Map<String, Object> params){
        //判断是否登录
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null) {
            return R.error("请先登录！");
        }
        params.put("memberId",member.getId().toString());
        Query query = new Query(params);
        List<TYunMerchandiseEntity> tYunMerchandiseEntity = tYunMerchandiseService.queryList(query);
        int total = tYunMerchandiseService.queryTotal(query);

        PageUtils pageUtils = new PageUtils(tYunMerchandiseEntity, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtils);
    }

    /**
     *会员中心我收藏——商品收藏取消
     */
    @RequestMapping("/demymerchandisecollection")
    public R demymerchandisecollection(String merchandiseId){
        TYunMerchandiseCollectionEntity tYunMerchandiseCollectionEntity = new TYunMerchandiseCollectionEntity();
        tYunMerchandiseCollectionEntity.setMerchandiseId(merchandiseId);
        if(ShiroUtils.getRegisterEntity()!=null){
            SysRegisterEntity member = ShiroUtils.getRegisterEntity();
            tYunMerchandiseCollectionEntity.setMemberId(String.valueOf(member.getId()));
        }else{
            return R.error("用户未登入");
        }
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("memberId",tYunMerchandiseCollectionEntity.getMemberId());
        params.put("merchandiseId",tYunMerchandiseCollectionEntity.getMerchandiseId());
        Query query = new Query(params);
        TYunMerchandiseCollectionEntity f =  tYunMerchandiseCollectionService.find(query);
        if(f==null){
            return R.error("已取消或未收藏");
        }
        tYunMerchandiseCollectionService.delete(f.getId());

        return R.ok("取消成功");
    }

    /**
     *会员中心我收藏——供应商收藏
     */
    @RequestMapping("/myprovidercollection")
    public R myprovidercollection(@RequestParam Map<String, Object> params){
        //判断是否登录
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null) {
            return R.error("请先登录！");
        }
        params.put("memberId",member.getId().toString());
        params.put("member",member.getId().toString());
        Query query = new Query(params);
        List<TYunProviderEntity> tYunProviderEntity = tYunProviderService.queryList(query);
        List<ProviderDto> providerDto = ProviderDto.changeFrom(tYunProviderEntity);
        int total = tYunProviderService.queryTotal(query);

        PageUtils pageUtils = new PageUtils(providerDto, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtils);
    }

    /**
     *会员中心我收藏——供应商收藏取消
     */
    @RequestMapping("/demyprovidercollection")
    public R demyprovidercollection(String providerId){
        TYunProviderCollectionEntity tYunProviderCollectionEntity = new TYunProviderCollectionEntity();
        tYunProviderCollectionEntity.setProviderId(providerId);
        if(ShiroUtils.getRegisterEntity()!=null){
            SysRegisterEntity member = ShiroUtils.getRegisterEntity();
            tYunProviderCollectionEntity.setMemberId(String.valueOf(member.getId()));
        }else{
            return R.error("用户未登入");
        }
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("memberId",tYunProviderCollectionEntity.getMemberId());
        params.put("providerId",tYunProviderCollectionEntity.getProviderId());
        Query query = new Query(params);
        TYunProviderCollectionEntity f =  tYunProviderCollectionService.find(query);
        if(f==null){
            return R.error("已取消或未收藏");
        }
        tYunProviderCollectionService.delete(f.getId());

        return R.ok("取消成功");
    }
    /*
    * 会员中心——我的供应商
    * */
    @RequestMapping("/myprovider")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据

        //判断是否登录
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null) {
            return R.error("请先登录！");
        }
        String memberId = String.valueOf(member.getId());
        params.put("memberId",memberId);
        Query query = new Query(params);
        List<TYunMyProviderEntry> tYunMyProviders = tYunMyProviderService.queryList(query);
        int total = tYunMyProviderService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(tYunMyProviders, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);

    }
}
