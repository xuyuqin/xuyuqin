package io.yun.controller;

import io.unicall.entity.SysRegisterEntity;
import io.unicall.utils.Query;
import io.unicall.utils.ShiroUtils;
import io.yun.entity.*;
import io.yun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class MainController {
    @Autowired
    private TYunMerchandiseService tYunMerchandiseService;
    @Autowired
    private TYunMerchandiseCollectionService tYunMerchandiseCollectionService;
    @Autowired
    private TYunMerchandiseImageService tYunMerchandiseImageService;
    @Autowired
    private TYunProviderService tYunProviderService;
    @Autowired
    private TYunProviderCollectionService tYunProviderCollectionService;
    @Autowired
    private  TYunProviderVipService tYunProviderVipService;
	@Autowired
	private TYunProductService tYunProductService;
	@Autowired
	private TYunCategoryService tYunCategoryService;

	@RequestMapping("/yuncai/index")
	public String freemarker(Map<String, Object> map) {
		map.put("name", "云材网");
		return "/yun/index";
	}


	@RequestMapping("/yuncai/resource/index")
	public String resourceindex(Map<String, Object> map, HttpSession session) {

		if(ShiroUtils.getRegisterEntity()!=null){
			map.put("log","1");
		}else{
			map.put("log","2");
		}

		return "yun/resource/index";
	}

	@RequestMapping("/yuncai/resource/create")
	public String resourcecreate(Map<String, Object> map, HttpServletRequest request, HttpSession session) {
//		String id = request.getParameter("id")==null?"":request.getParameter("id");
		if(ShiroUtils.getRegisterEntity()!=null){
			map.put("log","1");
//			if(id != ""){
////				TYunResourceController.info(id,session);
////				map.put("id",id);
//			}
			return "yun/resource/create";
		}else{
			return  "yun/login";
		}
	}
//	@RequestMapping("/yuncai/resource/creates")
//	public String resourcecreates(Map<String, Object> map, HttpSession session, HttpServletRequest request) {
//
//		if(ShiroUtils.getRegisterEntity()!=null){
//			String id = request.getParameter("id")==null?"":request.getParameter("id");
//
//			map.put("list",TYunResourceController.info(id,session));
//		}else{
//
//		}
//
//		return "/freemarker";
//	}

	@RequestMapping("/yuncai/demand/index")
	public String demand(Map<String, Object> map, HttpSession session){
		if(ShiroUtils.getRegisterEntity()!=null){
			map.put("log","1");
		}else{
			map.put("log","2");
		}
		return  "yun/demand/index";
	}

	@RequestMapping("/yuncai/demand/edit")
	public String demandedit(Map<String, Object> map, HttpSession session){
		if(ShiroUtils.getRegisterEntity()==null){
			return "yun/login";
		}
		return  "yun/demand/edit";
	}

	@RequestMapping("/yuncai/demand/price")
	public String demandprice(Map<String, Object> map, HttpSession session){
		if(ShiroUtils.getRegisterEntity()==null){
			return "yun/login";
		}
		return  "yun/demand/price";
	}
	@RequestMapping("/yuncai/demand/view")
	public String demandview(){
		return  "yun/demand/view";
	}


	@RequestMapping("/yuncai/register")
	public String register(Map<String,Object> map){

		return "yun/register";
	}
	@RequestMapping("yuncai/login")
	public String login(){

		return "yun/login";
	}
	@RequestMapping("yuncai/backstage/index")
	public ModelAndView backstage(){
		if(ShiroUtils.getRegisterEntity()==null){
			return new ModelAndView("yun/login");
		}
        ModelAndView mv = new ModelAndView("yun/backstage/index");
		mv.addObject("isProvider",ShiroUtils.getRegisterEntity().getIsProvider());
		return mv;
	}
	@RequestMapping("yuncai/backstage/order")
	public String backOrder(){
		if(ShiroUtils.getRegisterEntity()==null){

			return "yun/login";
		}
		return "yun/backstage/myorder";
	}
	@RequestMapping("yuncai/backstage/resources")
	public String resources(){

		return "yun/backstage/myResources";
	}
	@RequestMapping("yuncai/backstage/purchase")
	public String purchase(){
		return "yun/backstage/myPurchase";
	}
	@RequestMapping("yuncai/backstage/cart")
	public String cart(){
		return "yun/backstage/myCart";
	}
	@RequestMapping("yuncai/backstage/bill")
	public String bill(){
		return "yun/backstage/bill";
	}
	@RequestMapping("yuncai/backstage/white")
	public String white(){
		return "yun/backstage/myWhite";
	}
	@RequestMapping("yuncai/backstage/point")
	public String point(){
		return "yun/backstage/myPoint";
	}
	@RequestMapping("yuncai/backstage/coll")
	public String coll(){
		return "yun/backstage/mycoll";
	}
	@RequestMapping("yuncai/backstage/vipauth")
	public String vipauth(){
		return "yun/backstage/vipauth";
	}
	@RequestMapping("yuncai/backstage/userinfo")
	public String userinfo(){
		return "yun/backstage/userinfo";
	}
	@RequestMapping("yuncai/backstage/safe")
	public String safe(){
		return "yun/backstage/safe";
	}
	@RequestMapping("yuncai/backstage/apply")
	public String apply(){
		return "yun/backstage/apply";
	}
	@RequestMapping("yuncai/backstage/confirm")
	public String confirm(){
		return "yun/backstage/orderConfirm";
	}
	@RequestMapping("yuncai/backstage/intermediary")
	public String intermediary(){
		return "yun/backstage/intermediary";
	}

	@RequestMapping("yuncai/backstage/supplierInfo")
	public String supplierInfo(){
		return "yun/backstage/supplierInfo";
	}
	@RequestMapping("yuncai/backstage/supplierGoods")
	public String supplierGoods(){
		return "yun/backstage/supplierGoods";
	}

	@RequestMapping("yuncai/backstage/supplierGoodsedit")
	public String supplierGoodsedit(){
		return "yun/backstage/supplierGoodsedit";
	}
	@RequestMapping("yuncai/backstage/supplierInquiry")
	public String supplierInquiry(){
		return "yun/backstage/supplierInquiry";
	}
	@RequestMapping("yuncai/backstage/supplierMarketing")
	public String supplierMarketing(){
		return "yun/backstage/supplierMarketing";
	}
	@RequestMapping("yuncai/backstage/supplierOrder")
	public String supplierOrder(){
		return "yun/backstage/supplierOrder";
	}

	@RequestMapping("yuncai/mall/index")
	public String mall(){
		return "yun/mall/index";
	}
	@RequestMapping("yuncai/mall/list")
	public String list(){
		return "yun/mall/list";
	}

    @RequestMapping("yuncai/mall/detail")
    public ModelAndView detail(@RequestParam("merchandiseId") String merchandiseId) {
        ModelAndView mv = new ModelAndView("yun/mall/detail");
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        Map<String, Object> params = new HashMap<>();
        //查询merchandise主表信息
        TYunMerchandiseEntity merchandise = tYunMerchandiseService.queryObject(merchandiseId);
        if(member !=null){
            params.put("memberId",member.getId().toString());
            params.put("merchandiseId",merchandiseId);
            params.put("providerId",merchandise.getProviderId());
            //查询是否为供应商vip
            TYunProviderVipEntity vip = tYunProviderVipService.getByProviderAndMember(params);
            if(vip != null){
                mv.addObject("vip",vip.getVipRank());
            }
            //查询商品是否收藏
            TYunMerchandiseCollectionEntity merchandiseCollection = tYunMerchandiseCollectionService.find(params);
            if(merchandiseCollection !=null){
                mv.addObject("merchandiseCollection","商品已收藏");
            }else{
                mv.addObject("merchandiseCollection","商品未收藏");
            }
            //查询供应商是否收藏
            TYunProviderCollectionEntity providerCollection = tYunProviderCollectionService.find(params);
            if(providerCollection !=null){
                mv.addObject("providerCollection","供应商已收藏");
            }else{
                mv.addObject("providerCollection","供应商未收藏");
            }
        }
        //查询供应商信息
        TYunProviderEntity provider = tYunProviderService.queryObject(merchandise.getProviderId());
        merchandise.setProvider(provider);
        //查询图片
        List<TYunMerchandiseImageEntity> images = tYunMerchandiseImageService.getByMerchandiseId(merchandiseId);
        mv.addObject("merchandise", merchandise);
        mv.addObject("merchandiseImages",images);
        return mv;
    }

	@RequestMapping("yuncai/baike/index")
	public ModelAndView orderlist(@RequestParam Map<String, Object> params) {
		ModelAndView mv = new ModelAndView("yun/baike/index");
		//查询列表数据
		Query query = new Query(params);
		List<TYunProductEntity> hotProductList = tYunProductService.hotList(query);
		List<TYunProductEntity> nameList = tYunProductService.nameList(query);
		List<TYunProductEntity> tYunProductList = tYunProductService.baikeList(query);
		List<TYunCategoryEntity> tYunCategoryList = tYunCategoryService.queryList(query);

		mv.addObject("hotProductList",hotProductList);
		mv.addObject("nameList",nameList);
		mv.addObject("baikelist",tYunProductList);
		mv.addObject("tYunCategoryList",tYunCategoryList);
		return mv;
	}
}

