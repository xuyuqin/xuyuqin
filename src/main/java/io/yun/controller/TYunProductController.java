package io.yun.controller;

import java.util.List;
import java.util.Map;

import io.yun.dto.BaikeDetailsDto;
import io.yun.dto.ProviderDto;
import io.yun.entity.TYunOrderMerchandiseEntity;
import io.yun.entity.TYunProviderEntity;
import io.yun.service.TYunOrderMerchandiseService;
import io.yun.service.TYunProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.yun.entity.TYunProductEntity;
import io.yun.service.TYunProductService;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;
import org.springframework.web.servlet.ModelAndView;


/**
 * 商品品种表
 * 
 * @author unicall
 * @email bq.zhu@unicall.com
 * @date 2017-06-23 12:02:43
 */
@RestController
@RequestMapping("/yun/tyunproduct")
public class TYunProductController {
	@Autowired
	private TYunProductService tYunProductService;
	@Autowired
	private TYunProviderService tYunProviderService;
	@Autowired
	private TYunOrderMerchandiseService tYunOrderMerchandiseService;
	/**
	 * 列表
	 */
	@RequestMapping("/list")
//	@RequiresPermissions("tyunproduct:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TYunProductEntity> tYunProductList = tYunProductService.queryList(query);
		int total = tYunProductService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunProductList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	@RequestMapping(value="baikelist", method= RequestMethod.GET)
	public ModelAndView baikelist(@RequestParam("productid") String productid,@RequestParam Map<String, Object> params) {
		ModelAndView mv = new ModelAndView("yun/baike/index1");
        //查询列表数据
		Query query = new Query(params);
		List<TYunProductEntity> tYunProduct = tYunProductService.getProduct(productid);
		List<TYunProviderEntity> tYunProvider = tYunProviderService.getProvider(productid);
		List<TYunOrderMerchandiseEntity> tYunBuyPrice = tYunOrderMerchandiseService.getBuyPrice(productid);
//		Map<String, Object> list = new HashMap<String,Object>();
//		list.put("list",tYunProduct);
//		list.put("list",tYunProvider);
//		list.put("list",tYunBuyPrice);
//		tYunProduct.size();
		mv.addObject("tYunProduct",tYunProduct);
		mv.addObject("tYunProvider",tYunProvider);
		mv.addObject("tYunBuyPrice",tYunBuyPrice);
//		mv.addObject("tYunBuyPrice",list);
		return mv;
	}


	@RequestMapping(value="baikedetails", method= RequestMethod.GET)
	public ModelAndView baikedetails(@RequestParam("productid") String productid,@RequestParam Map<String, Object> params) {
		ModelAndView mv = new ModelAndView("yun/baike/details");
		//查询列表数据

		TYunProductEntity tYunProduct = tYunProductService.queryObject(productid);
		TYunProviderEntity tYunProviderId = tYunProviderService.getProviderId(productid);
		params.put("providerId",tYunProviderId.getId());
		params.put("productid",productid);
		params.put("upname",tYunProduct.getName());
		Query query = new Query(params);
		List<TYunProductEntity> tYunProduct1 = tYunProductService.getProduct(productid);
		List<BaikeDetailsDto> tYunProductImg = tYunProductService.getProductImg(query);
		List<BaikeDetailsDto> tYunProductmodule = tYunProductService.getProductmodule(query);
		List<BaikeDetailsDto> tYunProductDownName = tYunProductService.getDownProduct(query);
		List<ProviderDto> tYunProviderList = tYunProviderService.providerList(query);
		mv.addObject("tYunProduct",tYunProduct1);
		mv.addObject("tYunProductImg",tYunProductImg);
		mv.addObject("tYunProductmodule",tYunProductmodule);
		mv.addObject("tYunProductDownName",tYunProductDownName);
		mv.addObject("tYunProviderList",tYunProviderList);
		return mv;
	}

	@RequestMapping("/namelist")
//	@RequiresPermissions("tyunproduct:list")
	public R namelist(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);

		List<TYunProductEntity> tYunProductList = tYunProductService.nameList(query);
		int total = tYunProductService.nameTotal(query);

		PageUtils pageUtil = new PageUtils(tYunProductList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
//	@RequiresPermissions("tyunproduct:info")
	public R info(@PathVariable("id") String id){
		TYunProductEntity tYunProduct = tYunProductService.queryObject(id);
		
		return R.ok().put("tYunProduct", tYunProduct);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
//	@RequiresPermissions("tyunproduct:save")
	public R save(@RequestBody TYunProductEntity tYunProduct){
		tYunProductService.save(tYunProduct);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
//	@RequiresPermissions("tyunproduct:update")
	public R update(@RequestBody TYunProductEntity tYunProduct){
		tYunProductService.update(tYunProduct);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
//	@RequiresPermissions("tyunproduct:delete")
	public R delete(@RequestBody String[] ids){
		tYunProductService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
