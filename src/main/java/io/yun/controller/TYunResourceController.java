package io.yun.controller;

import io.unicall.entity.SysRegisterEntity;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;
import io.unicall.utils.ShiroUtils;
import io.yun.entity.TYunResourceEntity;
import io.yun.service.TYunResourceService;
import io.yun.utils.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 资源单表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-19 13:52:09
 */
@RestController
@RequestMapping("yun/resource")
public class TYunResourceController {
	@Autowired
	private TYunResourceService tYunResourceService;
	@Autowired
	private FileUtils fileUtils;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
//	@RequiresPermissions("tyunresource:list")
	public R list(@RequestParam Map<String, Object> params, HttpSession session){
		if(ShiroUtils.getRegisterEntity()!=null){
			SysRegisterEntity member = ShiroUtils.getRegisterEntity();
			params.put("memberId",member.getId().toString());
		}else{
			params.put("memberId","");
		}
		//查询列表数据
        Query query = new Query(params);

		List<TYunResourceEntity> tYunResourceList = tYunResourceService.queryList(query);
		int total = tYunResourceService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunResourceList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	@RequestMapping("/listmy")
//	@RequiresPermissions("tyunresource:list")
	public R listmy(@RequestParam Map<String, Object> params, HttpSession session){
		if(ShiroUtils.getRegisterEntity()!=null){
			SysRegisterEntity member = ShiroUtils.getRegisterEntity();
			params.put("providerId",member.getId().toString());
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
//	@RequiresPermissions("tyunresource:info")
	public R info(@PathVariable("id") String id, HttpSession session){
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("id",id);
        if(ShiroUtils.getRegisterEntity()!=null){
			SysRegisterEntity member = ShiroUtils.getRegisterEntity();
            params.put("memberId",member.getId().toString());
        }
        Query query = new Query(params);
        TYunResourceEntity tYunResource =  tYunResourceService.queryObject(query);
		return R.ok().put("tYunResource", tYunResource);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tyunresource:save")
	public R save(@RequestBody TYunResourceEntity tYunResource){
		tYunResourceService.save(tYunResource);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tyunresource:update")
	public R update(@RequestBody TYunResourceEntity tYunResource){
		tYunResourceService.update(tYunResource);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
//	@RequiresPermissions("tyunresource:delete")
	public R delete(String id){
		//判断是否登录
		SysRegisterEntity member = ShiroUtils.getRegisterEntity();
		if(member == null) {
			return R.error("请先登录！");
		}

		if(tYunResourceService.queryObject(id) ==null)
			return R.error("资源单不存在");
		tYunResourceService.delete(id);
		return R.ok("删除成功");
	}

	@RequestMapping("/deresource")
//	@RequiresPermissions("tyunresourcecollection:delete")
	public R delete(String resourceId, HttpSession session){
		TYunResourceEntity tYunResource = new TYunResourceEntity();
		tYunResource.setId(resourceId);
		if(ShiroUtils.getRegisterEntity()!=null){
			SysRegisterEntity member = ShiroUtils.getRegisterEntity();
            tYunResource.setProviderId(String.valueOf(member.getId()));
		}else{
			return R.error("用户未登入");
		}
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id",tYunResource.getId());
		params.put("member",tYunResource.getProviderId());
		Query query = new Query(params);
		TYunResourceEntity f =  tYunResourceService.queryObject(query);
		if(f==null){
			return R.error("资源单不存在或无权限");
		}
		tYunResourceService.delete(f.getId());

		return R.ok("取消成功");
	}

	/**
	 * 发布资源单，包括资源表的上传
	 */
	@RequestMapping(value="/edit")
	public R edit(TYunResourceEntity resource,
				  @RequestParam(name = "file") MultipartFile file) throws Exception {

		//判断是否登录
		SysRegisterEntity member = ShiroUtils.getRegisterEntity();
		if(member == null) {
			return R.error("请先登录！");
		}

		//上传文件
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(new Date());
		String path = "资源单/"+date+"/"+member.getId()+"/";
		String url = fileUtils.upload(file,path);

		resource.setUrl(url);
		resource.setUploadTime(new Date());
		resource.setProviderId(String.valueOf(member.getId()));

		if(StringUtils.isNotBlank(resource.getId())){
			tYunResourceService.update(resource);
			return R.ok("资源单更新成功");
		}else{
			tYunResourceService.save(resource);
			return R.ok("资源单创建成功");
		}
	}
}
