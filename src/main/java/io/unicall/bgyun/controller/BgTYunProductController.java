package io.unicall.bgyun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.unicall.bgyun.service.BgTYunProductService;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;
import io.unicall.utils.annotation.SysLog;
import io.unicall.bgyun.entity.BgTYunProductEntity;
import io.yun.utils.FileUtils;


/**
 * 云材网后台产品管理
 * 
 * @author maxellen
 * @email bq.zhu@unicall.net.cn
 * @date 2017-06-30 14:40:55
 */
@RestController
@RequestMapping("bgyun/product")
public class BgTYunProductController {
	
	@Autowired
	private BgTYunProductService bgTYunProductService;
	
	@Autowired
	private FileUtils fileUtils;
	
	@RequestMapping("/queryCategory")
	@RequiresPermissions("sys:product:query")
	public List<Object> queryCategory(){
		
		List<Object> l=  bgTYunProductService.queryCategory();
		
		return l;
	
	}
	
	@RequestMapping("/queryVariety")
	@RequiresPermissions("sys:product:query")
	public List<Object> queryVariety(){
		
		List<Object> l=  bgTYunProductService.queryVariety();
		
		return l;
		
	}
	
	@RequestMapping("/queryVarietyByCategoryName")
	@RequiresPermissions("sys:product:query")
	public R queryVarietyByCategoryName(@RequestParam String categoryName){
		
		List<Object> l=  bgTYunProductService.queryVarietyByCategoryName(categoryName);
		
		return R.ok("查询成功").put("variety", l);
		
	}
	
	/**
	 * 新增产品
	 */
//	@SysLog("新增产品")
	@RequestMapping("/save")
	@RequiresPermissions("sys:product:save")
	public R save(@RequestBody BgTYunProductEntity tYunProductEntity){

//			@RequestParam(name = "authfile") MultipartFile file) throws Exception{

		//上传文件
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        String date = sdf.format(new Date());
//        String path = "产品管理/"+date+"/";
//		  String url = fileUtils.upload(file,path);
//		  tYunProductImageEntity.setUrl(url);
	    
		bgTYunProductService.save(tYunProductEntity);
		return R.ok("产品新增成功");
	}
	
	/**
	 * 修改产品
	 */
//	@SysLog("修改产品")
	@RequestMapping("/update")
//	@RequiresPermissions("sys:product:update")
	public R update(@RequestBody BgTYunProductEntity tYunProductEntity) {

//			@RequestParam(name = "authfile") MultipartFile file) throws Exception{
		//上传文件
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        String date = sdf.format(new Date());
//        String path = "产品管理/"+date+"/";
//		  String url = fileUtils.upload(file,path);	 
//		  tYunProductImageEntity.setUrl(url);
		bgTYunProductService.update(tYunProductEntity);	
		return R.ok("更新成功");
	}
	/**
	 * 产品列表
	 */
	@RequestMapping("/list")
	//@RequiresPermissions("sys:product:list")
	public R list(@RequestParam Map<String, Object> params){
		
		//查询列表数据
        Query query = new Query(params);

		List<Object> l = bgTYunProductService.queryList(query);
		int total = bgTYunProductService.queryTotal(query);
		 		
		PageUtils pageUtil = new PageUtils(l, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);

	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:product:info")
	public R info(@PathVariable("id") String id){
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("id",id);
        Query query = new Query(params);
        Object tYunProduct =  bgTYunProductService.queryObject(query);
		return R.ok().put("tYunProduct", tYunProduct);
	}
	

	/**
	 * 批量删除
	 */
	@SysLog("删除产品")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:product:delete")
	public R delete(@RequestBody String[] ids){
				
		bgTYunProductService.deleteBatch(ids);
		
		return R.ok("删除成功");
	}
	




}
