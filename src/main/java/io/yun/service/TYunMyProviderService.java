package io.yun.service;

import io.yun.entity.TYunMyProviderEntry;

import java.util.List;
import java.util.Map;

/**
 * Created by ZhangLei on 2017/7/11.
 */
public interface TYunMyProviderService {
    List<TYunMyProviderEntry> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
}
