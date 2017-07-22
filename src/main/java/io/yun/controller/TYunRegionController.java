package io.yun.controller;

import java.util.List;
import java.util.Map;

import io.unicall.utils.Query;
import io.unicall.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.yun.entity.TYunRegionEntity;
import io.yun.service.TYunRegionService;



/**
 * 地区表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-22 15:38:04
 */
@RestController
@RequestMapping("yun/region")
public class TYunRegionController {
	@Autowired
	private TYunRegionService tYunRegionService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
//	@RequiresPermissions("tyunregion:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TYunRegionEntity> tYunRegionList = tYunRegionService.queryList(query);
//		int total = tYunRegionService.queryTotal(query);
		
//		PageUtils pageUtil = new PageUtils(tYunRegionList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("list", tYunRegionList);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{code}")
//	@RequiresPermissions("tyunregion:info")
	public R info(@PathVariable("code") String code){
		TYunRegionEntity tYunRegion = tYunRegionService.queryObject(code);
		
		return R.ok().put("tYunRegion", tYunRegion);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tyunregion:save")
	public R save(@RequestBody TYunRegionEntity tYunRegion){
		tYunRegionService.save(tYunRegion);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tyunregion:update")
	public R update(@RequestBody TYunRegionEntity tYunRegion){
		tYunRegionService.update(tYunRegion);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tyunregion:delete")
	public R delete(@RequestBody String[] codes){
		tYunRegionService.deleteBatch(codes);
		
		return R.ok();
	}
	
}
