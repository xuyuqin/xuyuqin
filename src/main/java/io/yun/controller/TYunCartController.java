package io.yun.controller;

import io.unicall.entity.SysRegisterEntity;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;
import io.unicall.utils.ShiroUtils;
import io.yun.entity.TYunCartEntity;
import io.yun.entity.TYunMerchandiseSpecEntity;
import io.yun.service.TYunCartService;
import io.yun.service.TYunMerchandiseSpecService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 购物车表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:32
 */
@RestController
@RequestMapping("yun/cart")
public class TYunCartController {
	@Autowired
	private TYunCartService tYunCartService;
	@Autowired
    private TYunMerchandiseSpecService tYunMerchandiseSpecService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("tyuncart:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TYunCartEntity> tYunCartList = tYunCartService.queryList(query);
		int total = tYunCartService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunCartList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("tyuncart:info")
	public R info(@PathVariable("id") String id){
		TYunCartEntity tYunCart = tYunCartService.queryObject(id);
		
		return R.ok().put("tYunCart", tYunCart);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tyuncart:save")
	public R save(@RequestBody TYunCartEntity tYunCart){
		tYunCartService.save(tYunCart);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tyuncart:update")
	public R update(@RequestBody TYunCartEntity tYunCart){
		tYunCartService.update(tYunCart);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tyuncart:delete")
	public R delete(@RequestBody String[] ids){
		tYunCartService.deleteBatch(ids);
		
		return R.ok();
	}

	/**
	 * 加入购物车
	 */
	@RequestMapping("/addCart")
	public R addCart(TYunCartEntity cart){
        //判断是否登录
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null) {
            return R.error("请先登录！");
        }

        String memberId = member.getId().toString();
        String merchandiseId = cart.getMerchandiseId();
        String specId = cart.getSpecificationId();
        //判断是否重复加入购物车
        TYunCartEntity old = tYunCartService.findByMemberAndMerchandise(memberId, merchandiseId);
        if(old != null && StringUtils.isNotBlank(old.getId())){
            return R.error("商品已加入购物车,不能重复添加");
        }
        //判断规格是否正确
        TYunMerchandiseSpecEntity spec = tYunMerchandiseSpecService.queryObject(specId);
        if(spec == null){
            return R.error("商品规格参数错误");
        }
        cart.setMemberId(String.valueOf(member.getId()));
		cart.setAddTime(new Date());
		tYunCartService.save(cart);

		return R.ok("加入购物车成功");
	}
}
