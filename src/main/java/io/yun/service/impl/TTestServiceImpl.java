package io.yun.service.impl;

import io.yun.dao.TYunProductDao;
import io.yun.entity.TYunProductEntity;
import io.yun.service.TTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/19.
 */
@Service(" TTestService")
public class TTestServiceImpl implements TTestService{

    @Autowired
    private TYunProductDao tYunProductDao;
    @Override
    public TYunProductEntity getTYunProductEntityById(int id) {
        return tYunProductDao.queryObject(id);
    }
}
