package io.yun.controller;

import io.unicall.entity.SysRegisterEntity;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;
import io.unicall.utils.ShiroUtils;
import io.yun.dto.OrderDto;
import io.yun.dto.OrderSpecDto;
import io.yun.entity.TYunOrderEntity;
import io.yun.entity.TYunOrderMerchandiseEntity;
import io.yun.service.TYunMerchandiseService;
import io.yun.service.TYunOrderMerchandiseService;
import io.yun.service.TYunOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 订单表
 * 
 * @author chenshuren
 * @email sr.chen@unicall.net.cn
 * @date 2017-06-26 13:43:31
 */
@RestController
@RequestMapping("yun/order")
public class TYunOrderController {
	@Autowired
	private TYunOrderService tYunOrderService;
	@Autowired
    private TYunOrderMerchandiseService tYunOrderMerchandiseService;
	@Autowired
    private TYunMerchandiseService tYunMerchandiseService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("tyunorder:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TYunOrderEntity> tYunOrderList = tYunOrderService.queryList(query);
		int total = tYunOrderService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tYunOrderList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("tyunorder:info")
	public R info(@PathVariable("id") String id){
		TYunOrderEntity tYunOrder = tYunOrderService.queryObject(id);
		
		return R.ok().put("tYunOrder", tYunOrder);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tyunorder:save")
	public R save(@RequestBody TYunOrderEntity tYunOrder){
		tYunOrderService.save(tYunOrder);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tyunorder:update")
	public R update(@RequestBody TYunOrderEntity tYunOrder){
		tYunOrderService.update(tYunOrder);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tyunorder:delete")
	public R delete(@RequestBody String[] ids){
		tYunOrderService.deleteBatch(ids);
		
		return R.ok();
	}

	/**
	 * 确认订单
	 */
	//设置初值，订单编号，限时支付，订单状态，下单用户，下单时间
	//添加order表，ordermerchandise表数据
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public R addOrder(@RequestBody OrderDto orderDto){
//        //判断是否登录
        SysRegisterEntity member = ShiroUtils.getRegisterEntity();
        if(member == null) {
            return R.error("请先登录！");
        }

        TYunOrderEntity order = new TYunOrderEntity();
        //设置订单编号
        String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int numD = tYunOrderService.queryOrderNumToday();
        Integer numI = numD+1;
        String numS = numI.toString();
        for(int i=numS.length();i<7;i++){
            numS="0"+numS;
        }
        order.setOrderNo(str+numS);//orderNo
        //限时支付
        Calendar ca=Calendar.getInstance();
        ca.setTime(new Date());
        //+3小时
        ca.add(Calendar.HOUR_OF_DAY, 3);
        order.setPaymentExpire(ca.getTime());//paymentExpire
        order.setOrderPrice(orderDto.getOrderPrice());//orderPrice
        order.setStatus(1);//设置初始状态status
        order.setInvoiceStatus(orderDto.getInvoiceStatus());
        if(("1").equals(orderDto.getInvoiceStatus())){
            order.setInvoiceHead(orderDto.getInvoiceHead());
            order.setInvoiceAddress(orderDto.getInvoiceAddress());
        }
        order.setInvoiceHead(orderDto.getInvoiceHead());//invoiceHead
        order.setInvoiceAddress(orderDto.getInvoiceAddress());//invoiceAddress
        order.setInvoiceStatus(orderDto.getInvoiceStatus());//invoiceStatus
        order.setDeliveryMethod(orderDto.getDeliveryMethod());//deliveryMethod
        order.setDeliveryCredential(orderDto.getDeliveryCredential());//deliveryCredential
        order.setDeliveryComment(orderDto.getDeliveryComment());//deliveryComment
        order.setOrderTime(new Date());//orderTime
        order.setIsDelete(1);//isDelete
        order.setMemberId(String.valueOf(member.getId()));//下单用户memberId
        //添加order表数据，同时添加order_merchandise表数据
        int flag = 0;
        for(Iterator<OrderSpecDto> iterator = (orderDto.getSpecifications()).iterator(); iterator.hasNext();){
            OrderSpecDto ms = iterator.next();
            if(flag == 0){
                String providerId = (tYunMerchandiseService.queryObject(ms.getMerchandiseId())).getProviderId();//获取providerId
                order.setProviderId(providerId);
//                order = tYunOrderService.save(order);
                tYunOrderService.save(order);
                flag = 1;
            }
            TYunOrderMerchandiseEntity orderMerchandise = new TYunOrderMerchandiseEntity();
            orderMerchandise.setOrderId(order.getId());
            orderMerchandise.setOrderMerchandiseId(ms.getMerchandiseId());//orderMerchandiseId
            orderMerchandise.setSpecificationId(ms.getSpecificationId());//specificationId
            orderMerchandise.setAmount(ms.getAmount());
//            orderMerchandise = tYunOrderMerchandiseService.save(orderMerchandise);
            tYunOrderMerchandiseService.save(orderMerchandise);
        }
	    return R.ok("下单成功").put("order",order);
    }
}
