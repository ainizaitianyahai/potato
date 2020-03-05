package com.potato.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.potato.dao.SUserDao;
import com.potato.entity.SUser;
import com.potato.service.UserService;
@Service
public class UserServiceImpl extends BaseServiceImpl<SUser> implements UserService {
	@Autowired 
	SUserDao userDao;
	
	@Override
	Class<SUser> getClassType() {
		return SUser.class;
	}

	@Override
	public SUser getSUserByUserId(String userId) {
		return userDao.createQuery().andEq("user_id", userId).single();
	}
}
