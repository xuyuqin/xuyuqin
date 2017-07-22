package io.yun.service;

import io.yun.entity.TYunDemandReplyEntity;

import java.util.List;
import java.util.Map;

/**
 * 求购单报价表
 * 
 * @author unicall
 * @email bq.zhu@unicall.com
 * @date 2017-06-27 14:05:08
 */
public interface TYunDemandReplyService {
	
	TYunDemandReplyEntity queryObject(String id);
	
	List<TYunDemandReplyEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TYunDemandReplyEntity tYunDemandReply);
	
	void update(TYunDemandReplyEntity tYunDemandReply);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
