package io.yun.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.unicall.entity.SysRegisterEntity;
import io.unicall.utils.*;
import io.yun.dto.ProviderDto;
import io.yun.utils.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.yun.entity.TYunProviderEntity;
import io.yun.service.TYunProviderService;
import org.springframework.web.multipart.MultipartFile;


/**
 * 供应商信息表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-16 16:45:27
 */
@RestController
@RequestMapping("yun/provider")
public class TYunProviderController {
	@Autowired
	private TYunProviderService tYunProviderService;
    @Autowired
    private FileUtils fileUtils;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
//	@RequiresPermissions("tyunprovider:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		if(ShiroUtils.getRegisterEntity()!=null){
			SysRegisterEntity member = ShiroUtils.getRegisterEntity();
			params.put("member",member.getId().toString());
		}
        Query query = new Query(params);

		List<TYunProviderEntity> tYunProviderList = tYunProviderService.queryList(query);
		List<ProviderDto> providerDto = ProviderDto.changeFrom(tYunProviderList);
		int total = tYunProviderService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(providerDto, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
//	@RequiresPermissions("tyunprovider:info")
	public R info(@PathVariable("id") String id){
		TYunProviderEntity tYunProvider = tYunProviderService.queryObject(id);

		return R.ok().put("tYunProvider", tYunProvider);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tyunprovider:save")
	public R save(@RequestBody TYunProviderEntity tYunProvider){
		tYunProviderService.save(tYunProvider);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tyunprovider:update")
	public R update(@RequestBody TYunProviderEntity tYunProvider){
		tYunProviderService.update(tYunProvider);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tyunprovider:delete")
	public R delete(@RequestBody String[] ids){
		tYunProviderService.deleteBatch(ids);

		return R.ok();
	}

	/**
	 * 供应商认证
	 */
	@RequestMapping(value="/edit")
	public R edit(TYunProviderEntity provider,
				  @RequestParam(name = "authfile") MultipartFile file) throws Exception {

		//判断是否登录
		SysRegisterEntity member = ShiroUtils.getRegisterEntity();
		if(member == null) {
			return R.error("请先登录！");
		}

		//上传文件
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());
        String path = "供应商认证/"+date+"/"+member.getId()+"/";
		String url = fileUtils.upload(file,path);

		provider.setFile(url);
		provider.setMemberId(String.valueOf(member.getId()));
        tYunProviderService.save(provider);
		return R.ok("提交成功，请等待审核");
	}
}
