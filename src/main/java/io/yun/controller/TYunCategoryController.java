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

import io.yun.entity.TYunCategoryEntity;
import io.yun.service.TYunCategoryService;
import io.unicall.utils.Query;
import io.unicall.utils.R;


/**
 * 商品类别表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-19 16:20:37
 */
@RestController
@RequestMapping("yun/category")
public class TYunCategoryController {
	@Autowired
	private TYunCategoryService tYunCategoryService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
//	@RequiresPermissions("tyuncategory:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TYunCategoryEntity> tYunCategoryList = tYunCategoryService.queryList(query);
//		int total = tYunCategoryService.queryTotal(query);
		
//		PageUtils pageUtil = new PageUtils(tYunCategoryList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("list", tYunCategoryList);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("tyuncategory:info")
	public R info(@PathVariable("id") String id){
		TYunCategoryEntity tYunCategory = tYunCategoryService.queryObject(id);
		
		return R.ok().put("tYunCategory", tYunCategory);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tyuncategory:save")
	public R save(@RequestBody TYunCategoryEntity tYunCategory){
		tYunCategoryService.save(tYunCategory);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tyuncategory:update")
	public R update(@RequestBody TYunCategoryEntity tYunCategory){
		tYunCategoryService.update(tYunCategory);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tyuncategory:delete")
	public R delete(@RequestBody String[] ids){
		tYunCategoryService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
