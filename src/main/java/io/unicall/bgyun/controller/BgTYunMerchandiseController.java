package io.unicall.bgyun.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.unicall.bgyun.service.BgTYunMerchandiseService;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;
import io.yun.entity.TYunMerchandiseEntity;



/**
 * 商品表
 * 
 * @author unicall
 * @email bq.zhu@unicall.com
 * @date 2017-07-11 20:16:19
 */
@RestController
@RequestMapping("bgyun/merchandise")
public class BgTYunMerchandiseController {
	@Autowired
	private BgTYunMerchandiseService tYunMerchandiseService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:merchandise:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TYunMerchandiseEntity> tYunMerchandiseList = tYunMerchandiseService.queryList(query);
		int total = tYunMerchandiseService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunMerchandiseList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:merchandise:info")
	public R info(@PathVariable("id") String id){
		TYunMerchandiseEntity tYunMerchandise = tYunMerchandiseService.queryObject(id);
		
		return R.ok().put("tYunMerchandise", tYunMerchandise);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:merchandise:save")
	public R save(@RequestBody TYunMerchandiseEntity tYunMerchandise){
		tYunMerchandiseService.save(tYunMerchandise);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:merchandise:update")
	public R update(@RequestBody TYunMerchandiseEntity tYunMerchandise){
		tYunMerchandiseService.update(tYunMerchandise);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:merchandise:delete")
	public R delete(@RequestBody String[] ids){
		tYunMerchandiseService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
