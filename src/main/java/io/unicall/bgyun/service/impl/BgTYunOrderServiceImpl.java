package io.unicall.bgyun.service.impl;


import io.unicall.bgyun.dao.BgTYunOrderDao;
import io.unicall.bgyun.dao.BgTYunProductDao;
import io.unicall.bgyun.entity.BgTYunProductEntity;
import io.unicall.bgyun.service.BgTYunOrderService;
import io.unicall.bgyun.service.BgTYunProductService;
import io.yun.entity.TYunOrderEntity;
import io.yun.entity.TYunProductImageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("bgTYunOrderService")
@Transactional
public class BgTYunOrderServiceImpl implements BgTYunOrderService {
	
	@Autowired
	private BgTYunOrderDao bgTYunOrderDao;




	@Override
	public List<Object> queryList(Map<String, Object> map) {
		
		return bgTYunOrderDao.queryList(map);
	}


	@Override
	public int queryTotal(Map<String, Object> map) {
	
		return bgTYunOrderDao.queryTotal(map);
	}

	@Override
	public Object queryObject(Object id) {
		return bgTYunOrderDao.queryObject(id);
	}

	@Override
	public TYunOrderEntity queryByOrderNo(String orderNo) {
		return bgTYunOrderDao.queryByOrderNo(orderNo);
	}

	@Override
	public void updateDeliverStatus(String orderNo) {
         bgTYunOrderDao.updateDeliverStatus(orderNo);
	}




}
