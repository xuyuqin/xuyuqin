package io.unicall.bgyun.controller;

import java.util.Date;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.unicall.bgyun.service.BgTYunCategoryService;
import io.unicall.utils.R;
import io.unicall.utils.annotation.SysLog;
import io.yun.entity.TYunCategoryEntity;


/**
 * 云材网后台维护管理-产品分类
 * 
 * @author maxellen
 * @email bq.zhu@unicall.net.cn
 * @date 2017-06-30 14:40:55
 */
@RestController
@RequestMapping("bgyun/category")
public class BgTYunCategoryController {
	@Autowired
	private BgTYunCategoryService bgtYunCategoryService;
	
	
	@RequestMapping("/queryCategory")
	@RequiresPermissions("sys:category:query")
	public R queryCategory(){
		
		List<Object> l=  bgtYunCategoryService.queryCategory();
		
		return R.ok("查询成功").put("category", l).put("isfirst", true);
	
	}
	
	@RequestMapping("/queryVariety")
	@RequiresPermissions("sys:category:query")
	public R queryVariety(@RequestParam Integer Id){

		List<Object> l=  bgtYunCategoryService.queryVarietyByCategoryId(Id);
		
		return R.ok("查询成功").put("variety", l).put("isfirst", false);
		
	}
	
	@RequestMapping("/queryObject")
	@RequiresPermissions("sys:category:query")
	public R queryObject(@RequestParam Integer Id){

		Object o=  bgtYunCategoryService.queryObject(Id);	
		return R.ok("查询成功").put("detail", o);
		
	}
	

	/**
	 * 批量删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:category:delete")
	public R delete(@RequestParam String ids){
		String[] id  = ids.split(",");			
		bgtYunCategoryService.deleteBatch(id);
		
		return R.ok("删除成功");
	}
	
	/**
	 * 新增产品分类
	 */
	@SysLog("新增产品分类")
	@RequestMapping("/save")
	@RequiresPermissions("sys:category:save")
	public R save(@ModelAttribute TYunCategoryEntity tYunCategoryEntity){
		tYunCategoryEntity.setUpdateTime(new Date());
		bgtYunCategoryService.save(tYunCategoryEntity);
		return R.ok("产品分类新增成功");
	}
	/**
	 * 修改产品分类
	 */
	@SysLog("修改产品分类")
	@RequestMapping("/update")
	@RequiresPermissions("sys:category:save")
	public R update(@ModelAttribute TYunCategoryEntity tYunCategoryEntity){
		tYunCategoryEntity.setUpdateTime(new Date());
		bgtYunCategoryService.update(tYunCategoryEntity);
		return R.ok("产品分类修改成功");
	}

}
