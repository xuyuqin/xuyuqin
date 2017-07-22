package io.yun.service;

import io.yun.dao.TYunProductDao;
import io.yun.entity.TYunProductEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/7/19.
 */
public interface TTestService {
  public TYunProductEntity getTYunProductEntityById(int id);
}
