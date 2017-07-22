package io.yun.controller;

import io.unicall.entity.SysRegisterEntity;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;
import io.unicall.utils.ShiroUtils;
import io.yun.dto.MerchandiseDto;
import io.yun.entity.*;
import io.yun.service.*;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 商品表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-16 10:38:12
 */
@RestController
@RequestMapping("yun/merchandise")
public class TYunMerchandiseController {
	@Autowired
	private TYunMerchandiseService tYunMerchandiseService;
	@Autowired
    private TYunMerchandiseCollectionService tYunMerchandiseCollectionService;
    @Autowired
    private TYunProviderService tYunProviderService;
    @Autowired
    private TYunMerchandiseImageService tYunMerchandiseImageService;
    @Autowired
	private TYunMerchandiseCommitsService tYunMerchandiseCommitsService;
    @Autowired
    private TYunProviderCollectionService tYunProviderCollectionService;
    @Autowired
    private  TYunProviderVipService tYunProviderVipService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
//	@RequiresPermissions("tyunmerchandise:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("insale",1);//只显示上架商品
        Query query = new Query(params);

		List<TYunMerchandiseEntity> tYunMerchandiseList = tYunMerchandiseService.queryList(query);
		int total = tYunMerchandiseService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunMerchandiseList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	@RequestMapping("/listmy")
//	@RequiresPermissions("tyunresource:list")
	public R listmy(@RequestParam Map<String, Object> params, HttpSession session){
		if(ShiroUtils.getRegisterEntity()!=null){
			SysRegisterEntity member = ShiroUtils.getRegisterEntity();
			params.put("memberId",member.getId().toString());
		}else{
			return R.error("用户未登入");
		}

		//查询列表数据
		Query query = new Query(params);

		List<TYunMerchandiseEntity> tYunResourceList = tYunMerchandiseService.queryList(query);
		int total = tYunMerchandiseService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(tYunResourceList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
//	@RequiresPermissions("tyunmerchandise:info")
	public R info(@PathVariable("id") String id){
		TYunMerchandiseEntity tYunMerchandise = tYunMerchandiseService.queryObject(id);
		
		return R.ok().put("tYunMerchandise", tYunMerchandise);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
//	@RequiresPermissions("tyunmerchandise:save")
	public R save(@RequestBody TYunMerchandiseEntity tYunMerchandise){
		tYunMerchandiseService.save(tYunMerchandise);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tyunmerchandise:update")
	public R update(@RequestBody TYunMerchandiseEntity tYunMerchandise){
		tYunMerchandiseService.update(tYunMerchandise);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
//	@RequiresPermissions("tyunmerchandise:delete")
	public R delete(@RequestBody String[] ids){
		tYunMerchandiseService.deleteBatch(ids);
		
		return R.ok();
	}

	/**
	 * 商品根据关键字查询
	 */
	@RequestMapping("/search")
	public R search(@RequestParam String query){
		Map<String,Object> map=new HashedMap();
		map.put("mname",query);
		//调用函数查找
		return list(map);
	}

	/**
	 * 商品详细
	 */
	@RequestMapping("/detail")
	public ModelMap detail(@RequestParam("merchandiseId") String merchandiseId){
//        ModelAndView mv = new ModelAndView("yun/mall/detail");
        ModelMap mv = new ModelMap();
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        Map<String, Object> params = new HashMap<>();
        //查询merchandise主表信息
        TYunMerchandiseEntity merchandise = tYunMerchandiseService.queryObject(merchandiseId);
        if(member !=null){
            params.put("memberId",member.getId().toString());
            params.put("merchandiseId",merchandiseId);
            params.put("providerId",merchandise.getProviderId());
            //查询是否为供应商vip
            TYunProviderVipEntity vip = tYunProviderVipService.getByProviderAndMember(params);
            if(vip != null){
                mv.addAttribute("vip",vip.getVipRank());
            }
            //查询商品是否收藏
            TYunMerchandiseCollectionEntity merchandiseCollection = tYunMerchandiseCollectionService.find(params);
            if(merchandiseCollection !=null){
                mv.addAttribute("merchandiseCollection","商品已收藏");
            }else{
                mv.addAttribute("merchandiseCollection","商品未收藏");
            }
            //查询供应商是否收藏
            TYunProviderCollectionEntity providerCollection = tYunProviderCollectionService.find(params);
            if(providerCollection !=null){
                mv.addAttribute("providerCollection","供应商已收藏");
            }else{
                mv.addAttribute("providerCollection","供应商未收藏");
            }
        }
        //查询供应商信息
        TYunProviderEntity provider = tYunProviderService.queryObject(merchandise.getProviderId());
        merchandise.setProvider(provider);
        //查询图片
        List<TYunMerchandiseImageEntity> images = tYunMerchandiseImageService.getByMerchandiseId(merchandiseId);
        mv.addAttribute("merchandise", merchandise);
        mv.addAttribute("merchandiseImages",images);
        return mv;
	}

    /**
     * 商品收藏
     */
    @RequestMapping("/collection")
    public R collection(@RequestParam("merchandiseId") String merchandiseId){
        //判断是否登录
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null) {
            return R.error("请先登录！");
        }
        //取消收藏
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("memberid",String.valueOf(member.getId()));
        params.put("merchandiseId",merchandiseId);
        TYunMerchandiseCollectionEntity old = tYunMerchandiseCollectionService.find(params);
        if(old!=null && StringUtils.isNotBlank(old.getId())){
            tYunMerchandiseCollectionService.delete(old.getId());
            return R.ok("取消收藏成功");
        }
        //添加收藏
        TYunMerchandiseCollectionEntity colletion = new TYunMerchandiseCollectionEntity();
        colletion.setMemberId(String.valueOf(member.getId()));
        colletion.setMerchandiseId(merchandiseId);
        colletion.setCreateTime(new Date());
        tYunMerchandiseCollectionService.save(colletion);
        return R.ok("收藏商品成功");
    }

    /**
     * 查询供应商的热销商品
     */
    @RequestMapping("/provider")
    public R provider(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        String providerId = params.get("providerId").toString();
        List<MerchandiseDto> merchandiseList = tYunMerchandiseService.getByProviderId(params);
        int total = tYunMerchandiseService.getByProviderIdTotal(providerId);

        PageUtils pageUtil = new PageUtils(merchandiseList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }
}
