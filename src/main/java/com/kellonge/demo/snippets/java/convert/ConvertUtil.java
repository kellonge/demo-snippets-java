package com.kellonge.demo.snippets.java.convert;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 常用类型转换工具类
 * 
 * @author kellonge
 * @version $Id: ConvertUtil.java, v 0.1 2016年4月19日 上午11:46:16 kellonge Exp $
 */
public class ConvertUtil {

    /**
     * 检查参数是否是int类型
     * 
     * @param str
     * @return
     */
    private static Boolean isInteger(Object str) {
        try {
            Integer.parseInt(toString(str));
        } catch (Exception err) {
            return false;
        }
        return true;
    }

    /**
     * 转换成日期类型，转换失败返回当前时间。
     * 支持的时间格式 yyyy-MM-dd HH:mm:ss | yyyy/MM/dd HH:mm:ss | yyyy-MM-dd | yyyy/MM/dd
     * 
     * @param objDate
     * @return
     */
    public static Date toDateTime(Object objDate) {
        Date date = new Date();
        try {
            String strDate = toString(objDate);
            if (strDate.indexOf(":") > 0) {
                String strFormat = "yyyy-MM-dd HH:mm:ss";
                if (strDate.indexOf("/") > 0)
                    strFormat = "yyyy/MM/dd HH:mm:ss";
                SimpleDateFormat formatDateTime = new SimpleDateFormat(strFormat);
                date = formatDateTime.parse(strDate);
            } else {
                String strFormat = "yyyy-MM-dd";
                if (strDate.indexOf("/") > 0)
                    strFormat = "yyyy/MM/dd";
                SimpleDateFormat formatDate = new SimpleDateFormat(strFormat);
                date = formatDate.parse(strDate);
            }
        } catch (Exception exception) {
        }
        return date;
    }

    /**
     * 转换成String 默认为""
     * 
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        if (obj == null)
            return "";
        return obj.toString().trim();

    }

    /**
     * 转换成Integer 默认为-1
     * 
     * @param obj
     * @return
     */
    public static Integer toInt(Object obj) {
        if (isInteger(obj))
            return Integer.parseInt(toString(obj));
        else
            return -1;
    }

    /**
     * 转换成Integer 转换失败取给定的默认值
     * 
     * @param obj
     * @param nInitValue
     * @return
     */
    public static Integer toInt(Object obj, int nInitValue) {
        int nResult = toInt(obj);
        if (nResult == -1)
            nResult = nInitValue;
        return nResult;
    }

    /**
     * 转换成Long 默认为0
     * 
     * @param obj
     * @return
     */
    public static Long toLong(Object obj) {
        long num = 0L;
        try {
            num = Long.parseLong(toString(obj));
        } catch (Exception exception) {
        }
        return num;
    }

    /**
     * 转换成Float 默认为0
     * 
     * @param obj
     * @return
     */
    public static Float toFloat(Object obj) {
        float num = 0.0F;
        try {
            num = Float.parseFloat(toString(obj));
        } catch (Exception exception) {
        }
        return num;
    }

    /**
     * 转换成Double 默认为0
     * 
     * @param obj
     * @return
     */
    public static Double toDouble(Object obj) {
        double num = 0.0D;
        try {
            num = Double.parseDouble(toString(obj));
        } catch (Exception exception) {
        }
        return num;
    }

    /**
     * 转换成Boolean 传入的是 true or false
     * 
     * @param obj
     * @return
     */
    public static Boolean toBool(Object obj) {
        return toString(obj).equalsIgnoreCase("true");
    }

}
