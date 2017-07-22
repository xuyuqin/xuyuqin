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

import io.yun.entity.TYunProviderCollectionEntity;
import io.yun.service.TYunProviderCollectionService;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;


/**
 * 供应商收藏
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-29 14:16:31
 */
@RestController
@RequestMapping("tyunprovidercollection")
public class TYunProviderCollectionController {
	@Autowired
	private TYunProviderCollectionService tYunProviderCollectionService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("tyunprovidercollection:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TYunProviderCollectionEntity> tYunProviderCollectionList = tYunProviderCollectionService.queryList(query);
		int total = tYunProviderCollectionService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunProviderCollectionList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("tyunprovidercollection:info")
	public R info(@PathVariable("id") String id){
		TYunProviderCollectionEntity tYunProviderCollection = tYunProviderCollectionService.queryObject(id);
		
		return R.ok().put("tYunProviderCollection", tYunProviderCollection);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tyunprovidercollection:save")
	public R save(@RequestBody TYunProviderCollectionEntity tYunProviderCollection){
		tYunProviderCollectionService.save(tYunProviderCollection);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tyunprovidercollection:update")
	public R update(@RequestBody TYunProviderCollectionEntity tYunProviderCollection){
		tYunProviderCollectionService.update(tYunProviderCollection);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tyunprovidercollection:delete")
	public R delete(@RequestBody String[] ids){
		tYunProviderCollectionService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
