package io.yun.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.yun.entity.TYunMarketingEntity;
import io.yun.service.TYunMarketingService;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;


/**
 * 营销（活动）表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-07-07 11:07:41
 */
@RestController
@RequestMapping("tyunmarketing")
public class TYunMarketingController {
	@Autowired
	private TYunMarketingService tYunMarketingService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("tyunmarketing:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TYunMarketingEntity> tYunMarketingList = tYunMarketingService.queryList(query);
		int total = tYunMarketingService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunMarketingList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("tyunmarketing:info")
	public R info(@PathVariable("id") String id){
		TYunMarketingEntity tYunMarketing = tYunMarketingService.queryObject(id);
		
		return R.ok().put("tYunMarketing", tYunMarketing);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tyunmarketing:save")
	public R save(@RequestBody TYunMarketingEntity tYunMarketing){
		tYunMarketingService.save(tYunMarketing);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tyunmarketing:update")
	public R update(@RequestBody TYunMarketingEntity tYunMarketing){
		tYunMarketingService.update(tYunMarketing);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tyunmarketing:delete")
	public R delete(@RequestBody String[] ids){
		tYunMarketingService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
