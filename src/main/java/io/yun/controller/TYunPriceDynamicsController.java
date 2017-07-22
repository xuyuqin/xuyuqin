package io.yun.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.yun.entity.TYunPriceDynamicsEntity;
import io.yun.service.TYunPriceDynamicsService;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;


/**
 * 价格动态表
 * 
 * @author lankai
 * @email bq.zhu@unicall.com
 * @date 2017-06-30 10:56:33
 */
@RestController
@RequestMapping("yun/tyunpricedynamics")
public class TYunPriceDynamicsController {
	@Autowired
	private TYunPriceDynamicsService tYunPriceDynamicsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
//	@RequiresPermissions("tyunpricedynamics:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TYunPriceDynamicsEntity> tYunPriceDynamicsList = tYunPriceDynamicsService.queryList(query);
		int total = tYunPriceDynamicsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunPriceDynamicsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
//	@RequiresPermissions("tyunpricedynamics:info")
	public R info(@PathVariable("id") String id){
		TYunPriceDynamicsEntity tYunPriceDynamics = tYunPriceDynamicsService.queryObject(id);
		
		return R.ok().put("tYunPriceDynamics", tYunPriceDynamics);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
//	@RequiresPermissions("tyunpricedynamics:save")
	public R save(@RequestBody TYunPriceDynamicsEntity tYunPriceDynamics){
		tYunPriceDynamicsService.save(tYunPriceDynamics);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
//	@RequiresPermissions("tyunpricedynamics:update")
	public R update(@RequestBody TYunPriceDynamicsEntity tYunPriceDynamics){
		tYunPriceDynamicsService.update(tYunPriceDynamics);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
//	@RequiresPermissions("tyunpricedynamics:delete")
	public R delete(@RequestBody String[] ids){
		tYunPriceDynamicsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
