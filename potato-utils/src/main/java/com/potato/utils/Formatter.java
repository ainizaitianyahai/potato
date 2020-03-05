package com.potato.utils;

import java.util.Calendar;
import java.util.Date;

public class Formatter {
	/**
	 * 根据出生日期获取年龄
	 * @param birthday
	 * @return
	 */
	public static int getAgeByBirth(Date birthday){
        // 格式化传入的时间
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date()); // 当前时间
 
            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday); // 传入的时间
 
            //如果传入的时间，在当前时间的后面，返回0岁
            if (birth.after(now)) {
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {
            return 0;
        }
    }
}
