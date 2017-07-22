package io.yun.service.impl;

import io.yun.dao.TYunMyProviderDao;
import io.yun.entity.TYunMyProviderEntry;
import io.yun.service.TYunMyProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/11.
 */
@Service("TYunMyProviderService")
public class TYunMyProviderServiceImpl implements TYunMyProviderService {
    @Autowired
    private TYunMyProviderDao tYunMyProviderDao;
    @Override
    public List<TYunMyProviderEntry> queryList(Map<String, Object> map) {
        return tYunMyProviderDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return tYunMyProviderDao.queryTotal(map);
    }
}
