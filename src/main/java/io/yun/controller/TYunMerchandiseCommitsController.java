package io.yun.controller;

import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;
import io.yun.dto.MerchandiseDto;
import io.yun.entity.TYunMerchandiseCommitsEntity;
import io.yun.service.TYunMerchandiseCommitsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 商品评价表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
@RestController
@RequestMapping("yun/merchandisecommits")
public class TYunMerchandiseCommitsController {
	@Autowired
	private TYunMerchandiseCommitsService tYunMerchandiseCommitsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("tyunmerchandisecommits:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TYunMerchandiseCommitsEntity> tYunMerchandiseCommitsList = tYunMerchandiseCommitsService.queryList(query);
		int total = tYunMerchandiseCommitsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunMerchandiseCommitsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("tyunmerchandisecommits:info")
	public R info(@PathVariable("id") String id){
		TYunMerchandiseCommitsEntity tYunMerchandiseCommits = tYunMerchandiseCommitsService.queryObject(id);
		
		return R.ok().put("tYunMerchandiseCommits", tYunMerchandiseCommits);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tyunmerchandisecommits:save")
	public R save(@RequestBody TYunMerchandiseCommitsEntity tYunMerchandiseCommits){
		tYunMerchandiseCommitsService.save(tYunMerchandiseCommits);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tyunmerchandisecommits:update")
	public R update(@RequestBody TYunMerchandiseCommitsEntity tYunMerchandiseCommits){
		tYunMerchandiseCommitsService.update(tYunMerchandiseCommits);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tyunmerchandisecommits:delete")
	public R delete(@RequestBody String[] ids){
		tYunMerchandiseCommitsService.deleteBatch(ids);
		
		return R.ok();
	}

	/**
	 * 商品详情页商品评价列表
	 */
	@RequestMapping("/getlist")
	public R getCommitList(@RequestParam Map<String, Object> params){
	    //查询列表数据
        Query query = new Query(params);
	    List<MerchandiseDto> commitsList = tYunMerchandiseCommitsService.getByMerchandiseId(query);
	    int total = tYunMerchandiseCommitsService.listTotal(query);

        PageUtils pageUtil = new PageUtils(commitsList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }
}
