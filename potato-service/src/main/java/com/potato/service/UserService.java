package com.potato.service;

import com.potato.entity.SUser;


public interface UserService extends BaseService<SUser>{
	/**
	 * 根据人员登录Id获取人员信息对象
	 * @param userId	人员登录Id
	 * @return
	 */
	SUser getSUserByUserId(String userId);
}
