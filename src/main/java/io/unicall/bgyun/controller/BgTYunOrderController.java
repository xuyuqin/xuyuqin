package io.unicall.bgyun.controller;

import io.unicall.bgyun.entity.BgTYunOrderEntity;
import io.unicall.bgyun.entity.BgTYunProductEntity;
import io.unicall.bgyun.service.BgTYunOrderService;
import io.unicall.bgyun.service.BgTYunProductService;
import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;
import io.unicall.utils.annotation.SysLog;
import io.yun.utils.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 云材网后台订单管理
 * 
 * @author maxellen
 * @email bq.zhu@unicall.net.cn
 * @date 2017-06-30 14:40:55
 */
@RestController
@RequestMapping("bgyun/order")
public class BgTYunOrderController {
	
	@Autowired
	private BgTYunOrderService bgTYunOrderService;
	
	@Autowired
	private FileUtils fileUtils;


//	传入page页码,orderNo,Id查询，list显示
	@RequestMapping("/list")
	//@RequiresPermissions("sys:order:list")
	public R list(@RequestParam Map<String, Object> params){
		
		//查询列表数据
        Query query = new Query(params);

		List<Object> l = bgTYunOrderService.queryList(query);
	    int total = bgTYunOrderService.queryTotal(query);
		 		
		PageUtils pageUtil = new PageUtils(l, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);

	}

	//orderNo订单号查询
	@RequestMapping("/orderByOrderNo/{orderNo}")        //
	//@RequiresPermissions("sys:order:list")
	public R getOrderByOrderNo(@PathVariable("orderNo") String orderNo){


		return R.ok().put("order",bgTYunOrderService.queryByOrderNo(orderNo));

	}

	//id查询
	@RequestMapping("/orderById")        //
	//@RequiresPermissions("sys:order:list")
	public R getOrderById(@RequestParam String id){


		return R.ok().put("order",bgTYunOrderService.queryObject(id));

	}


	//将待发货修改为待收货，通过orderNo
	@RequestMapping("/updateDeliverStatus/{orderNo}")        //
	//@RequiresPermissions("sys:order:list")
	public R updateDeliverStatus(@PathVariable("orderNo") String orderNo){


        bgTYunOrderService.updateDeliverStatus(orderNo);
		return R.ok();

	}




	@RequestMapping(value = "test")
	public String test(){
		return "test";
	}
	
	



}
