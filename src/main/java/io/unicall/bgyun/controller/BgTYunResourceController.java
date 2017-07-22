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

import io.unicall.bgyun.service.BgTYunResourceService;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;
import io.unicall.utils.ShiroUtils;
import io.yun.entity.TYunResourceEntity;


/**
 * 云材网后台资源单
 * 
 * @author maxellen
 * @email bq.zhu@unicall.net.cn
 * @date 2017-06-28 16:15:26
 */
@RestController
@RequestMapping("bgyun/resource")

public class BgTYunResourceController {
	
		@Autowired
		private BgTYunResourceService bgTYunResourceService;
		
		/**
		 * 所有资源单列表
		 */
		@RequestMapping("/list")
		@RequiresPermissions("sys:resource:list")
		public R list(@RequestParam Map<String, Object> params){
			
			//查询列表数据
	        Query query = new Query(params);

			List<TYunResourceEntity> tYunResourceList = bgTYunResourceService.queryList(query);
			int total = bgTYunResourceService.queryTotal(query);
			 		
			PageUtils pageUtil = new PageUtils(tYunResourceList, total, query.getLimit(), query.getPage());
			
			return R.ok().put("page", pageUtil);

		}
		
		/**
		 * 我的资源单列表
		 */
		@RequestMapping("/listMy")
		@RequiresPermissions("sys:resource:listMy")
		public R listMy(@RequestParam Map<String, Object> params){
			
		    params.put("traderId",ShiroUtils.getUserId());
			//查询列表数据
	        Query query = new Query(params);

			List<TYunResourceEntity> tYunResourceList = bgTYunResourceService.queryMyList(query);
			int total = bgTYunResourceService.queryMyTotal(query);
			 		
			PageUtils pageUtil = new PageUtils(tYunResourceList, total, query.getLimit(), query.getPage());
			
			return R.ok().put("page", pageUtil);

		}
			
		/**
		 * 信息
		 */
		@RequestMapping("/info/{id}")
		@RequiresPermissions("sys:resource:info")
		public R info(@PathVariable("id") String id, HttpSession session){
	        Map<String, Object> params = new HashMap<String,Object>();
	        params.put("id",id);
	        Query query = new Query(params);
	        TYunResourceEntity tYunResource =  bgTYunResourceService.queryObject(query);
			return R.ok().put("tYunResource", tYunResource);
		}
		

		/**
		 * 批量删除
		 */
		@RequestMapping("/delete")
		@RequiresPermissions("sys:resource:delete")
		public R delete(@RequestBody String[] ids){
		
			bgTYunResourceService.deleteBatch(ids);
			
			return R.ok("删除成功");
		}
		
		/**
		 * 审批
		 */
		@RequestMapping("/permit")
		@RequiresPermissions("sys:resource:permit")
//		public R permit(@ModelAttribute("tYunResourceEntity") TYunResourceEntity tYunResourceEntity){
		public R permit(@RequestBody TYunResourceEntity tYunResourceEntity){
			System.out.println(tYunResourceEntity.getId());
			bgTYunResourceService.permit(tYunResourceEntity);
			
			return R.ok("审批完成");
		}

}
