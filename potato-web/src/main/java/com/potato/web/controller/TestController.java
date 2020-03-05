package com.potato.web.controller;
import java.util.Arrays;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.ext.gen.GenConfig;
import org.beetl.sql.ext.gen.GenFilter;
import org.beetl.sql.ext.gen.MapperCodeGen;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.potato.utils.SpringUtil;

@Controller
@RequestMapping(value="/test")
public class TestController{
	
	@ResponseBody
	@RequestMapping(value="/test")
	public String test(String id) {
		System.out.println(id);
		//单个对象生成
		/*SQLManager sqlManager = (SQLManager)SpringUtil.getBean(SQLManager.class);
		//sql.genPojoCodeToConsole("userRole"); 快速生成，显示到控制台
		// 或者直接生成java文件
		GenConfig config = new GenConfig();
		config.preferBigDecimal(true);
		try {
			sqlManager.genPojoCode("s_dept","com.mt.MTsrv.bean",config);
		} catch (Exception e) {
			e.printStackTrace();
			return "失败";
		}
		return "完成";*/
		
		SQLManager sqlManager = (SQLManager)SpringUtil.getBean(SQLManager.class);
		//sql.genPojoCodeToConsole("userRole"); 快速生成，显示到控制台
		// 或者直接生成java文件
		GenConfig config = new GenConfig();
		//是否用BigDecimal代替Double
		config.preferBigDecimal(false);
		try {
			MapperCodeGen mapper = new MapperCodeGen("com.potato.activiti.dao");
			config.codeGens.add(mapper);
			final String[] createTableName = {"s_task_record","","",""};//s_message
			sqlManager.genALL("com.potato.activiti.entity", config, new GenFilter() {
				@Override
				public boolean accept(String tableName) {
					return Arrays.asList(createTableName).contains(tableName);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return "失败";
		}
		return "完成";
	}
}
