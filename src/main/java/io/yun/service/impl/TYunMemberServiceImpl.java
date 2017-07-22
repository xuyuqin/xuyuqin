package io.yun.service.impl;

import io.unicall.dao.SysRegisterDao;
import io.unicall.dao.SysUserDao;
import io.unicall.entity.SysUserEntity;
import io.yun.dao.TYunOrderDao;
import io.yun.dto.MyInfoDto;
import io.yun.entity.TYunOrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.yun.service.TYunMemberService;



@Service("tYunMemberService")
public class TYunMemberServiceImpl implements TYunMemberService {
	@Autowired
	private TYunOrderDao tYunOrderDao;
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysRegisterDao sysRegisterDao;

	@Override
	public List<TYunOrderEntity> orderList(Map<String, Object> map){
		return tYunOrderDao.queryList(map);
	}

	@Override
	public int orderTotal(Map<String, Object> map){
		return tYunOrderDao.queryTotal(map);
	}

	@Override
	public  List<String> orderStatusTotal(String memberId){
		return tYunOrderDao.statusTotal(memberId);
	}
	@Override
	public SysUserEntity queryTrader(String trader) {
		return sysUserDao.queryObject(trader);
	}

	@Override
	public void update(MyInfoDto myInfoDto) {
		sysRegisterDao.update1(myInfoDto);
	}

	@Override
	public void updateOrder(TYunOrderEntity tYunOrder){
		tYunOrderDao.update(tYunOrder);
	}
}
