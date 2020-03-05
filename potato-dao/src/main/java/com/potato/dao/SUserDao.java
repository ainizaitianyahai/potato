package com.potato.dao;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import com.potato.entity.SUser;

/*
* 
* gen by beetlsql mapper 2019-01-28
*/
@Repository
@SqlResource("sUser")
public interface SUserDao extends BaseMapper<SUser> {
	
}
