package io.unicall.dao;

import java.util.List;
import java.util.Map;

/**
 * 基础Dao(还需在XML文件里，有对应的SQL语句)
 * 
 * @author unicall
 * 
 * @date 2016年9月18日 上午9:31:36
 */
public interface BaseDao<T> {              //基础Dao方法接口
	
	void save(T t);                         //保存对象
	
	void save(Map<String, Object> map);      //
	
	void saveBatch(List<T> list);
	
	int update(T t);
	
	int update(Map<String, Object> map);
	
	int delete(Object id);
	
	int delete(Map<String, Object> map);
	
	int deleteBatch(Object[] id);

	T queryObject(Object id);
	
	T queryObject1(Object id);
	
	List<T> queryList(Map<String, Object> map);
	
	
	List<T> queryList(Object id);

	List<T> queryList1(Object id);
	
	int queryTotal(Map<String, Object> map);

	int queryTotal1(Map<String, Object> map);

	int queryTotal();
}
