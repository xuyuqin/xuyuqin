package io.yun.controller;

import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;
import io.yun.dto.HomeProviderDto;
import io.yun.entity.TYunDemandEntity;
import io.yun.entity.TYunMerchandiseEntity;
import io.yun.entity.TYunNewsEntity;
import io.yun.service.HomeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 首页
 * Created by sr.chen on 2017/6/30.
 */
@RestController
@RequestMapping("yun/home")
public class HomeController {
    @Autowired
    private HomeService homeService;           //home主页得service服务接口，提空需要的信息

    /**
     * 云材商城，获取供应商数据
     */
    @RequestMapping("/provider")
    //param主要需要page（当前页数）和limit（每页条数）属性
    public R ProviderList(@RequestParam Map<String, Object> params){

        Query query = new Query(params);       //param进行再次封装
        List<HomeProviderDto> providerList=homeService.providerList(query);     //根据query查询对应信息
        int total = homeService.providerTotal(query);    //获取信息总数

        PageUtils pageUtils = new PageUtils(providerList, total, query.getLimit(), query.getPage());   //对获取信息进行封装
        System.out.print(pageUtils);
         return R.ok().put("page", pageUtils);
    }

    /**
     * 云材商城，获取求购单数据
     */
    @RequestMapping("/demand")
    public R DemandList(@RequestParam Map<String, Object> params){

        Query query = new Query(params);                 //
        List<TYunDemandEntity> providerList=homeService.demandList(query);
        int total = homeService.demandTotal(query);

        PageUtils pageUtils = new PageUtils(providerList, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtils);
    }

    /**
     * 云材商城，为您推荐商品
     */
    @RequestMapping("/recommend")
    public R RecommendList(@RequestParam Map<String, Object> params){

        params.put("isRecommend",1);
        Query query = new Query(params);
        List<TYunMerchandiseEntity> merchandiseList=homeService.merchandisesList(query);
        int total = homeService.merchandisesTotal(query);

        PageUtils pageUtils = new PageUtils(merchandiseList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtils);
    }

    /**
     * 新闻资讯
     */
    @RequestMapping("/news")
    public R NewsList(@RequestParam Map<String, Object> params){

        Query query = new Query(params);
        List<TYunNewsEntity> providerList=homeService.newsList(query);
        int total = homeService.newsTotal(query);

        PageUtils pageUtils = new PageUtils(providerList, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtils);
    }
}
