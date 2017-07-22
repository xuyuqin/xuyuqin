package io.unicall.bgyun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.unicall.bgyun.service.BgTYunDemandService;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;
import io.unicall.utils.ShiroUtils;
import io.yun.entity.TYunDemandEntity;

/**
 * 云材网后台资源单
 * 
 * @author maxellen
 * @email bq.zhu@unicall.net.cn
 * @date 2017-06-30 14:40:55
 */
@RestController
@RequestMapping("bgyun/demand")
public class BgTYnDemandController {
	
	@Autowired
	private BgTYunDemandService bgTYunDemandService;
	
	/**
	 * 全部找货单
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:demand:list")
	public R list(@RequestParam Map<String, Object> params){
		
		//查询列表数据
        Query query = new Query(params);

		List<TYunDemandEntity> tYunResourceList = bgTYunDemandService.queryList(query);
		int total = bgTYunDemandService.queryTotal(query);
		 		
		PageUtils pageUtil = new PageUtils(tYunResourceList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);

	}
	/**
	 * 我的找货单
	 */
	@RequestMapping("/listMy")
	@RequiresPermissions("sys:demand:listMy")
	public R listMy(@RequestParam Map<String, Object> params){
		
		params.put("traderId",ShiroUtils.getUserId());
		//查询列表数据
		Query query = new Query(params);
		System.out.println(ShiroUtils.getUserId());
		List<TYunDemandEntity> tYunResourceList = bgTYunDemandService.queryMyList(query);
		int total = bgTYunDemandService.queryMyTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunResourceList, total, query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
		
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:demand:info")
	public R info(@PathVariable("id") String id, HttpSession session){
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("id",id);
        Query query = new Query(params);
        Object tYunDemand =  bgTYunDemandService.queryObject(query);
		return R.ok().put("tYunDemand", tYunDemand);
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:demand:delete")
	public R delete(@RequestBody String[] ids){	

		bgTYunDemandService.deleteBatch(ids);
		
		return R.ok("删除成功");
	}
	

	/**
	 * 审批
	 */
	@RequestMapping("/permit")
	@RequiresPermissions("sys:resource:permit")
	public R permit(@RequestBody TYunDemandEntity tYunDemandEntity){
		bgTYunDemandService.permit(tYunDemandEntity);
		
		return R.ok("审批成功");
	}

}
