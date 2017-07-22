package io.yun.controller;

import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;
import io.yun.entity.TYunMerchandiseSpecEntity;
import io.yun.service.TYunMerchandiseSpecService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 商品规格表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-07-04 10:32:17
 */
@RestController
@RequestMapping("tyunmerchandisespec")
public class TYunMerchandiseSpecController {
	@Autowired
	private TYunMerchandiseSpecService tYunMerchandiseSpecService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("tyunmerchandisespec:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TYunMerchandiseSpecEntity> tYunMerchandiseSpecList = tYunMerchandiseSpecService.queryList(query);
		int total = tYunMerchandiseSpecService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunMerchandiseSpecList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("tyunmerchandisespec:info")
	public R info(@PathVariable("id") String id){
		TYunMerchandiseSpecEntity tYunMerchandiseSpec = tYunMerchandiseSpecService.queryObject(id);
		
		return R.ok().put("tYunMerchandiseSpec", tYunMerchandiseSpec);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tyunmerchandisespec:save")
	public R save(@RequestBody TYunMerchandiseSpecEntity tYunMerchandiseSpec){
		tYunMerchandiseSpecService.save(tYunMerchandiseSpec);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tyunmerchandisespec:update")
	public R update(@RequestBody TYunMerchandiseSpecEntity tYunMerchandiseSpec){
		tYunMerchandiseSpecService.update(tYunMerchandiseSpec);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tyunmerchandisespec:delete")
	public R delete(@RequestBody String[] ids){
		tYunMerchandiseSpecService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
