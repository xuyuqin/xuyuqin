package io.yun.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 资源单-用户关系表
 * 
 * @author zc
 * @email chao.zhou@unicall.net.cn
 * @date 2017-06-19 13:52:10
 */
public class TYunResourceCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//资源单id
	private String resourceId;
	//会员id
	private String memberId;
	//创建时间
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
