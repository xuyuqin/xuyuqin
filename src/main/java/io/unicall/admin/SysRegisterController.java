package io.unicall.admin;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.unicall.entity.SysRegisterEntity;
import io.unicall.service.SysRegisterService;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;

/**
	 * 云材网注册用户
	 * 
	 * @author maxellen
	 * @email bq.zhu@unicall.net.cn
	 * @date 2017-06-24 22:55:18
	 */
	@RestController
	@RequestMapping("sys/register")
	public class SysRegisterController {
		@Autowired
		private SysRegisterService sysRegisterService;
		
		/**
		 * 列表
		 */
		@RequestMapping("/list")
		@RequiresPermissions("sys:register:list")
		public R list(@RequestParam Map<String, Object> params){
			//查询列表数据
	        Query query = new Query(params);

			List<SysRegisterEntity> sysRegisterList = sysRegisterService.queryList(query);
			int total = sysRegisterService.queryTotal(query);
			
			PageUtils pageUtil = new PageUtils(sysRegisterList, total, query.getLimit(), query.getPage());
			
			return R.ok().put("page", pageUtil);
		}
		
		
		/**
		 * 信息
		 */
		@RequestMapping("/info/{id}")
		@RequiresPermissions("sys:register:info")
		public R info(@PathVariable("id") Long id){
			SysRegisterEntity sysRegister = sysRegisterService.queryObject1(id);
			
			return R.ok().put("sysRegister", sysRegister);
		}
		
		/**
		 * 保存
		 */
		@RequestMapping("/save")
		@RequiresPermissions("sys:register:save")
		public R save(@RequestBody SysRegisterEntity sysRegister){
			sysRegisterService.save(sysRegister);
			
			return R.ok();
		}
		
		/**
		 * 修改
		 */
		@RequestMapping("/update")
		@RequiresPermissions("sys:register:update")
		public R update(@RequestBody SysRegisterEntity sysRegister){
			sysRegisterService.update(sysRegister);
			
			return R.ok();
		}
		
		/**
		 * 删除
		 */
		@RequestMapping("/delete")
		@RequiresPermissions("sys:register:delete")
		public R delete(@RequestBody Long[] ids){
			sysRegisterService.deleteBatch(ids);
			
			return R.ok();
		}
		
	}



