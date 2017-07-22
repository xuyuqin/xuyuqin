package io.yun.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.unicall.entity.SysRegisterEntity;
import io.unicall.utils.ShiroUtils;
import io.yun.entity.TYunDemandEntity;
import io.yun.service.TYunDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.yun.entity.TYunDemandReplyEntity;
import io.yun.service.TYunDemandReplyService;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;


/**
 * 求购单报价表
 * 
 * @author unicall
 * @email bq.zhu@unicall.com
 * @date 2017-06-27 14:05:08
 */
@RestController
@RequestMapping("/yun/tyundemandreply")
public class TYunDemandReplyController {
	@Autowired
	private TYunDemandReplyService tYunDemandReplyService;

	@Autowired
	private TYunDemandService tYunDemandService;
	/**
	 * 列表
	 */
	@RequestMapping("/list")
//	@RequiresPermissions("tyundemandreply:list")
	public R list(@RequestParam Map<String, Object> params){
		if(ShiroUtils.getRegisterEntity()!=null){
			SysRegisterEntity member = ShiroUtils.getRegisterEntity();
			params.put("memberId",member.getId());
		}else{
			return R.error("用户未登入");
		}
		//查询列表数据
        Query query = new Query(params);

		List<TYunDemandReplyEntity> tYunDemandReplyList = tYunDemandReplyService.queryList(query);
		int total = tYunDemandReplyService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunDemandReplyList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
//	@RequiresPermissions("tyundemandreply:info")
	public R info(@PathVariable("id") String id){
		TYunDemandReplyEntity tYunDemandReply = tYunDemandReplyService.queryObject(id);
		
		return R.ok().put("tYunDemandReply", tYunDemandReply);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
//	@RequiresPermissions("tyundemandreply:save")
	public R save(@RequestBody TYunDemandReplyEntity tYunDemandReply){
		tYunDemandReplyService.save(tYunDemandReply);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
//	@RequiresPermissions("tyundemandreply:update")
	public R update(@RequestBody TYunDemandReplyEntity tYunDemandReply){
		tYunDemandReplyService.update(tYunDemandReply);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
//	@RequiresPermissions("tyundemandreply:delete")
	public R delete(@RequestBody String[] ids){
		tYunDemandReplyService.deleteBatch(ids);
		
		return R.ok();
	}

	/**
	 * 报价
	 */
	@RequestMapping(value="/offer")
	public R find(TYunDemandReplyEntity tYunDemandReply){

		//判断是否登录
		SysRegisterEntity member = ShiroUtils.getRegisterEntity();
		if(member == null) {
			return R.error("请先登录！");
		}
		tYunDemandReply.setCreateTime(new Date());
		tYunDemandReply.setProviderId(String.valueOf(member.getId()));
		tYunDemandReplyService.save(tYunDemandReply);


		TYunDemandEntity tYunDemandEntity= tYunDemandService.queryObject(tYunDemandReply.getDemandId());
		if(tYunDemandEntity==null)
			return R.ok("发生未知的错误");
		tYunDemandEntity.setReplyCount(tYunDemandEntity.getReplyCount()+1);
		tYunDemandService.delete(tYunDemandReply.getDemandId());
		tYunDemandService.save1(tYunDemandEntity);

		return R.ok("发布成功");
	}

	/**
	 * 修改报价信息
	 */
	@RequestMapping(value="/updateOffer")
	public R updateRelease(TYunDemandReplyEntity tYunDemandReply){
		//判断是否登录
		SysRegisterEntity member = ShiroUtils.getRegisterEntity();
		if(member == null) {
			return R.error("请先登录！");
		}


		TYunDemandEntity tYunDemandEntity= tYunDemandService.queryObject(tYunDemandReply.getDemandId());
		if(tYunDemandEntity==null)
			return R.ok("发生未知的错误");
		tYunDemandEntity.setReplyCount(tYunDemandEntity.getReplyCount()+1);
		tYunDemandService.delete(tYunDemandReply.getDemandId());
		tYunDemandService.save1(tYunDemandEntity);


		tYunDemandReplyService.update(tYunDemandReply);
		return R.ok("修改成功");
	}
}
