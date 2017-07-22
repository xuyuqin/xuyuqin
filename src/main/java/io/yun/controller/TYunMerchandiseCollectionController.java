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

import io.yun.entity.TYunMerchandiseCollectionEntity;
import io.yun.service.TYunMerchandiseCollectionService;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;


/**
 * 商品收藏表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-16 10:38:12
 */
@RestController
@RequestMapping("yun/merchandisecollection")
public class TYunMerchandiseCollectionController {
	@Autowired
	private TYunMerchandiseCollectionService tYunMerchandiseCollectionService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("tyunmerchandisecollection:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TYunMerchandiseCollectionEntity> tYunMerchandiseCollectionList = tYunMerchandiseCollectionService.queryList(query);
		int total = tYunMerchandiseCollectionService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunMerchandiseCollectionList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("tyunmerchandisecollection:info")
	public R info(@PathVariable("id") String id){
		TYunMerchandiseCollectionEntity tYunMerchandiseCollection = tYunMerchandiseCollectionService.queryObject(id);
		
		return R.ok().put("tYunMerchandiseCollection", tYunMerchandiseCollection);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tyunmerchandisecollection:save")
	public R save(@RequestBody TYunMerchandiseCollectionEntity tYunMerchandiseCollection){
		tYunMerchandiseCollectionService.save(tYunMerchandiseCollection);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tyunmerchandisecollection:update")
	public R update(@RequestBody TYunMerchandiseCollectionEntity tYunMerchandiseCollection){
		tYunMerchandiseCollectionService.update(tYunMerchandiseCollection);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tyunmerchandisecollection:delete")
	public R delete(@RequestBody String[] ids){
		tYunMerchandiseCollectionService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
