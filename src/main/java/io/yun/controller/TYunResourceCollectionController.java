package io.yun.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.unicall.entity.SysRegisterEntity;
import io.unicall.utils.ShiroUtils;
import io.yun.entity.TYunResourceEntity;
import io.yun.service.TYunResourceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.yun.entity.TYunResourceCollectionEntity;
import io.yun.service.TYunResourceCollectionService;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;

import javax.servlet.http.HttpSession;


/**
 * 资源单-用户关系表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-19 13:52:10
 */
@RestController
@RequestMapping("yun/resourcecollection")
public class TYunResourceCollectionController {
	@Autowired
	private TYunResourceService tYunResourceService;
	@Autowired
	private TYunResourceCollectionService tYunResourceCollectionService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
//	@RequiresPermissions("tyunresourcecollection:list")
	public R list(@RequestParam Map<String, Object> params, HttpSession session){
		if(ShiroUtils.getRegisterEntity()!=null){
			SysRegisterEntity member = ShiroUtils.getRegisterEntity();
			params.put("memberId",member.getId().toString());
			params.put("member",member.getId().toString());
		}else{
			return R.error("用户未登入");
		}
		//查询列表数据
        Query query = new Query(params);

		List<TYunResourceEntity> tYunResourceList = tYunResourceService.queryList(query);
		int total = tYunResourceService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunResourceList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("tyunresourcecollection:info")
	public R info(@PathVariable("id") String id){
		TYunResourceCollectionEntity tYunResourceCollection = tYunResourceCollectionService.queryObject(id);
		
		return R.ok().put("tYunResourceCollection", tYunResourceCollection);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
//	@RequiresPermissions("tyunresourcecollection:save")
	public R save(TYunResourceCollectionEntity tYunResourceCollection, HttpSession session){
		if(ShiroUtils.getRegisterEntity()!=null){
			SysRegisterEntity member = ShiroUtils.getRegisterEntity();
			tYunResourceCollection.setMemberId(String.valueOf(member.getId()));
		}else{
			return R.error("用户未登入");
		}
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("memberid",tYunResourceCollection.getMemberId());
		params.put("resourceid",tYunResourceCollection.getResourceId());
		Query query = new Query(params);
		TYunResourceCollectionEntity f =  tYunResourceCollectionService.find(query);
		if(f!=null){
			return R.error("不能重复收藏");
		}
		tYunResourceCollection.setCreateTime(new Date());
		tYunResourceCollectionService.save(tYunResourceCollection);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tyunresourcecollection:update")
	public R update(@RequestBody TYunResourceCollectionEntity tYunResourceCollection){
		tYunResourceCollectionService.update(tYunResourceCollection);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tyunresourcecollection:delete")
	public R delete(@RequestBody String[] ids){
		tYunResourceCollectionService.deleteBatch(ids);
		
		return R.ok();
	}

	@RequestMapping("/decollection")
//	@RequiresPermissions("tyunresourcecollection:delete")
	public R delete(String resourceId, HttpSession session){
		TYunResourceCollectionEntity tYunResourceCollection = new TYunResourceCollectionEntity();
		tYunResourceCollection.setResourceId(resourceId);
		if(ShiroUtils.getRegisterEntity()!=null){
			SysRegisterEntity member = ShiroUtils.getRegisterEntity();
			tYunResourceCollection.setMemberId(String.valueOf(member.getId()));
		}else{
			return R.error("用户未登入");
		}
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("memberid",tYunResourceCollection.getMemberId());
		params.put("resourceid",tYunResourceCollection.getResourceId());
		Query query = new Query(params);
		TYunResourceCollectionEntity f =  tYunResourceCollectionService.find(query);
		if(f==null){
			return R.error("已取消或未收藏");
		}
		tYunResourceCollectionService.delete(f.getId());

		return R.ok("取消成功");
	}
}
