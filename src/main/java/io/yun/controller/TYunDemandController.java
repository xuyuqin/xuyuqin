package io.yun.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.unicall.entity.SysRegisterEntity;
import io.unicall.utils.ShiroUtils;
import io.yun.entity.TYunDemandEntity;
import io.yun.service.TYunDemandReplyService;
import io.yun.service.TYunDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;


/**
 * 求购单表
 * 
 * @author unicall
 * @email bq.zhu@unicall.com
 * @date 2017-06-27 14:04:56
 */
@RestController
@RequestMapping("/yun/tyundemand")
public class TYunDemandController {
	@Autowired
	private TYunDemandService tYunDemandService;
	@Autowired
	private TYunDemandReplyService tYunDemandReplyService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
//	@RequiresPermissions("tyundemand:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TYunDemandEntity> tYunDemandList = tYunDemandService.queryList(query);
		int total = tYunDemandService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunDemandList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	/**
	 * 列表
	 */
	@RequestMapping("/listbaojia")
//	@RequiresPermissions("tyundemand:list")
	public R listbaojia(@RequestParam Map<String, Object> params){
		if(ShiroUtils.getRegisterEntity()!=null){
			SysRegisterEntity member = ShiroUtils.getRegisterEntity();
			params.put("memberId",member.getId());
		}else{
			return R.error("用户未登入");
		}

		//查询列表数据
		Query query = new Query(params);

		List<TYunDemandEntity> tYunDemandList = tYunDemandService.queryList1(query);
		int total = tYunDemandService.queryTotal1(query);

		PageUtils pageUtil = new PageUtils(tYunDemandList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	@RequestMapping("/listmy")
//	@RequiresPermissions("tyunresource:list")
	public R listmy(@RequestParam Map<String, Object> params){
		if(ShiroUtils.getRegisterEntity()!=null){
			SysRegisterEntity member = ShiroUtils.getRegisterEntity();
			params.put("memberId",member.getId());
		}else{
			return R.error("用户未登入");
		}

		//查询列表数据
		Query query = new Query(params);

		List<TYunDemandEntity> tYunResourceList = tYunDemandService.queryList(query);
		int total = tYunDemandService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(tYunResourceList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
//	@RequiresPermissions("tyundemand:info")
	public R info(@PathVariable("id") String id){
		TYunDemandEntity tYunDemand = tYunDemandService.queryObject(id);
		
		return R.ok().put("tYunDemand", tYunDemand);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
//	@RequiresPermissions("tyundemand:save")
	public R save(@RequestBody TYunDemandEntity tYunDemand){
		tYunDemandService.save(tYunDemand);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
//	@RequiresPermissions("tyundemand:update")
	public R update(@RequestBody TYunDemandEntity tYunDemand){
		tYunDemandService.update(tYunDemand);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
//	@RequiresPermissions("tyundemand:delete")
	public R delete(@RequestBody String[] ids){
		tYunDemandService.deleteBatch(ids);
		
		return R.ok();
	}

	/**
	 * 发布找货信息
	 */
	@RequestMapping(value="/find")
	public R find(TYunDemandEntity tYunDemand){

		//判断是否登录
		SysRegisterEntity member = ShiroUtils.getRegisterEntity();
		if(member == null) {
			return R.error("请先登录！");
		}
		tYunDemand.setMemberId(String.valueOf(member.getId()));
		tYunDemand.setReplyCount(0);
		tYunDemand.setCreateTime(new Date());
			tYunDemandService.save(tYunDemand);
			return R.ok("发布成功");
	}

	/**
	 * 修改找货信息
	 */
	@RequestMapping(value="/updateRelease")
	public R updateRelease(TYunDemandEntity tYunDemand){

		//判断是否登录
		SysRegisterEntity member = ShiroUtils.getRegisterEntity();
		if(member == null) {
			return R.error("请先登录！");
		}
		tYunDemandService.update(tYunDemand);
		return R.ok("修改成功");
	}

	/**
	 * 我的发布删除
	 */
	@RequestMapping("/deleteRelease")
//	@RequiresPermissions("tyundemand:delete")
	public R deleteRelease(String id){

		//判断是否登录
		SysRegisterEntity member = ShiroUtils.getRegisterEntity();
		if(member == null) {
			return R.error("请先登录！");
		}

		TYunDemandEntity tYunDemand=tYunDemandService.queryObject(id);

		if(tYunDemand ==null)
			return R.error("数据不存在或无权限");
		    tYunDemandReplyService.delete(tYunDemand.getId());
		    tYunDemandService.delete(id);

	     	return R.ok("删除成功");
	}

}
