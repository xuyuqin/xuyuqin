package io.yun.service;

import io.unicall.entity.SysUserEntity;
import io.yun.dto.MyInfoDto;
import io.yun.entity.TYunOrderEntity;

import java.util.List;
import java.util.Map;

/**
 * 会员表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-20 16:58:14
 */
public interface TYunMemberService {

	List<TYunOrderEntity> orderList(Map<String, Object> map);

	int orderTotal(Map<String, Object> map);

    List<String> orderStatusTotal(String memberId);

    SysUserEntity queryTrader(String trader);

    void update(MyInfoDto myInfoDto);

    void updateOrder(TYunOrderEntity tYunOrder);
}
