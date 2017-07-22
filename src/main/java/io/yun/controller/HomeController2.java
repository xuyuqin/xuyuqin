package io.yun.controller;

import io.unicall.utils.PageUtils;
import io.unicall.utils.R;
import io.yun.dto.HomeProviderDto;
import io.yun.entity.TYunProductEntity;
import io.yun.service.HomeService;
import io.unicall.utils.Query;
import io.yun.service.impl.TTestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2017/7/13.
 */
@RestController
@RequestMapping("yun/home2")
public class HomeController2 {
    @Autowired
    private HomeService homeService;

    @RequestMapping(value = "/provider")
    public R getHomeProviderDto(@RequestParam Map<String, Object> params){
        Query query = new Query(params);   //将param内的page，limit等map从新封装

        List<HomeProviderDto> providerList=homeService.providerList(query);     //通过homeService通过dao层获取homeProviderListDao的list数据集合
        int total=homeService.providerTotal(query);
        PageUtils pageUtils=new PageUtils(providerList,total,query.getLimit(),query.getPage());

        return R.ok().put("page",pageUtils);

    }
    @Autowired
    private TTestServiceImpl tTestServiceImpl;

    @RequestMapping(value = "/test")
    public R test(@RequestParam("id") int id ){
        TYunProductEntity tYunProductEntity=tTestServiceImpl.getTYunProductEntityById(id);
        return R.ok().put("TunProductEntity",tYunProductEntity);
    }
    @RequestMapping(value = "/test2")
    public R test(){
        return R.ok();
    }
}
