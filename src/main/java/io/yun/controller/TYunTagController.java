package io.yun.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.yun.entity.TYunTagEntity;
import io.yun.service.TYunTagService;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;


/**
 * 产品标签表（百科按标签查找产品功能）
 * 
 * @author unicall
 * @email bq.zhu@unicall.com
 * @date 2017-06-23 11:15:52
 */
@RestController
@RequestMapping("/yun/tyuntag")
public class TYunTagController {
	@Autowired
	private TYunTagService tYunTagService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
//	@RequiresPermissions("tyuntag:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TYunTagEntity> tYunTagList = tYunTagService.queryList(query);
		int total = tYunTagService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunTagList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
//	@RequiresPermissions("tyuntag:info")
	public R info(@PathVariable("id") String id){
		TYunTagEntity tYunTag = tYunTagService.queryObject(id);
		
		return R.ok().put("tYunTag", tYunTag);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
//	@RequiresPermissions("tyuntag:save")
	public R save(@RequestBody TYunTagEntity tYunTag){
		tYunTagService.save(tYunTag);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
//	@RequiresPermissions("tyuntag:update")
	public R update(@RequestBody TYunTagEntity tYunTag){
		tYunTagService.update(tYunTag);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
//	@RequiresPermissions("tyuntag:delete")
	public R delete(@RequestBody String[] ids){
		tYunTagService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
