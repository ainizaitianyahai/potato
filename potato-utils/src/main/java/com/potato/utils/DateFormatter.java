package com.potato.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {

	private String datePattern;
    private SimpleDateFormat dateFormat;

    public DateFormatter(String datePattern) {
        dateFormat = new SimpleDateFormat(datePattern);
        dateFormat.setLenient(false);
    }
    public Date parse(String s, Locale locale) throws ParseException {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
            dateFormat.setLenient(false);
            return dateFormat.parse(s);
        } catch (ParseException e) {
            throw new IllegalArgumentException("invalid date format. Please use this pattern\"" + datePattern + "\"");
        }
    }

    public String print(Date date, Locale locale) {
        return dateFormat.format(date);
    }
    /**获取日期格式
     * @return
     */
    public static SimpleDateFormat getDateFormatEsc(){
    	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return sd;
    }
    /**获取日期格式
     * @return
     */
    public static SimpleDateFormat getDateFormat(){
    	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    	return sd;
    }
    /**
     * 转换日期格式
     * @param date
     * @return
     */
    public static String formatEsc(Date date) {
    	return getDateFormatEsc().format(date);
    }
    /**
     * 转换日期格式
     * @param date
     * @return
     */
    public static String format(Date date) {
    	return getDateFormat().format(date);
    }
    /**
     * 转换日期格式
     * @param date
     * @return
     * @throws ParseException 
     */
    public static Date format(String date){
    	try {
			return getDateFormatEsc().parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return new Date();
    }
    /**
     * 获取今天日期的指定前一个月的日期
     * @param day
     * @return
     */
    public static Date beforeMonthDay() {
        return beforeMonthDay(new Date(),-1);
    }
    /**
     * 获取今天日期的指定月的日期
     * @param day
     * @return
     */
    public static Date beforeMonthDay(int month) {
        return beforeMonthDay(new Date(),month);
    }
    /**
     * 获取指定日期的前指定月的日期
     * @param day
     * @return
     */
    public static Date beforeMonthDay(Date day,int month) {
    	Calendar c = Calendar.getInstance();
        //过去一月
        c.setTime(day);
        c.add(Calendar.MONTH, month);
        Date date = c.getTime();
        return date;
    }
    /**
     * 指定日期获取该日期所在周的周一至周日的日期
     * @param time	指定日期
     * @return
     */
    public static List<String> weekList(Date time){
    	List<String> weekList = new ArrayList<String>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(time);  
        //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得传入日期是一个星期的第几天  
        if(1 == dayWeek) {  
          cal.add(Calendar.DAY_OF_MONTH, -1);  
        }  
        //System.out.println("要计算日期为:"+sdf.format(cal.getTime())); //输出要计算日期  
        cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
        int day = cal.get(Calendar.DAY_OF_WEEK);//获得传入日期是一个星期的第几天  
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day);//根据日历的规则，给传入日期减去星期几与一个星期第一天的差值   
        String Monday = sdf.format(cal.getTime());  
        weekList.add(Monday);
        //System.out.println("所在周星期一的日期："+Monday);   
        cal.add(Calendar.DATE, 1);  
        String Tuesday = sdf.format(cal.getTime());  
        weekList.add(Tuesday);
        //System.out.println("所在周星期二的日期："+Tuesday);   
        cal.add(Calendar.DATE, 1);  
        String Wednesday = sdf.format(cal.getTime());
        weekList.add(Wednesday);
        //System.out.println("所在周星期三的日期："+Wednesday);   
        cal.add(Calendar.DATE, 1);  
        String Thursday = sdf.format(cal.getTime());
        weekList.add(Thursday);
        //System.out.println("所在周星期四的日期："+Thursday);   
        cal.add(Calendar.DATE, 1);  
        String Friday = sdf.format(cal.getTime());
        weekList.add(Friday);
        //System.out.println("所在周星期五的日期："+Friday);   
        cal.add(Calendar.DATE, 1);  
        String Saturday = sdf.format(cal.getTime()); 
        weekList.add(Saturday);
        //System.out.println("所在周星期六的日期："+Saturday);   
        cal.add(Calendar.DATE, 1);  
        String Sunday = sdf.format(cal.getTime()); 
        weekList.add(Sunday);
        //System.out.println("所在周星期日的日期："+Sunday);                            
		return weekList;
    }
    /**
   	 * 判断时间是否在时间段内
   	 * @param nowTime
   	 * @param beginTimeStr
   	 * @param endTimeStr
   	 * @return
   	 */
    public static boolean belongCalendar(Date date, String beginTimeStr, String endTimeStr) {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
		//初始化
		Date nowTime =null;
		Date beginTime = null;
		Date endTime = null;
		try {
			//格式化当前时间格式
			nowTime = df.parse(df.format(date));
			//定义开始时间
			beginTime = df.parse(beginTimeStr);
			//定义结束时间
			endTime = df.parse(endTimeStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//调用判断方法
		return belongCalendar(nowTime, beginTime, endTime);
	}
    /**
	 * 判断时间是否在时间段内
	 * @param nowTime
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
		//设置当前时间
		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);
		//设置开始时间
		Calendar begin = Calendar.getInstance();
		begin.setTime(beginTime);
		//设置结束时间
		Calendar end = Calendar.getInstance();
		end.setTime(endTime);
		//处于开始时间之后，和结束时间之前的判断
		if (date.after(begin) && date.before(end)) {
			return true;
		} else {
			return false;
		}
	}
	/**
     * date2比date1多的天数
     * @param date1    
     * @param date2
     * @return    
     */
    public static int differentDays(Date date1,Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
       int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年            
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            
            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }
}
