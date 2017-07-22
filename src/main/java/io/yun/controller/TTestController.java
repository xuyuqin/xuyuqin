package io.yun.controller;

import io.unicall.utils.PageUtils;
import io.unicall.utils.Query;
import io.unicall.utils.R;
import io.yun.dto.HomeProviderDto;
import io.yun.entity.TYunProductEntity;
import io.yun.service.HomeService;
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
@RequestMapping("yun/test")
public class TTestController {
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
