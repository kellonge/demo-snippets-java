package com.kellonge.demo.snippets.java.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

/**
 * 启动传入参数解析
 * 参数为-开头的键值对，多个键值对中间有逗号分隔
 * 如 -port=9090 -ip=127.0.0.1
 * 
 * @author kellonge
 * @version $Id: ArgsMain.java, v 0.1 2016年4月21日 下午4:30:23 kellonge Exp $
 */
public class ArgsMain {

    public static void main(String[] args) {
        System.out.println("start args: " + JSON.toJSONString(args));
        System.out.println("struct args:" + JSON.toJSONString(getArgsMap(args)));
    }

    /**
     * 格式化启动参数
     * 
     * @param args
     * @return
     */
    private static Map<String, Object> getArgsMap(String[] args) {
        Map<String, Object> map = new HashMap<>();
        for (String arg : args) {
            if (!arg.startsWith("-")) {
                throw new IllegalArgumentException(arg + " invalid arg");
            }
            String[] split = StringUtils.split(arg, '=');
            if (split.length != 2) {
                throw new IllegalArgumentException(arg + " invalid arg");
            }
            map.put(split[0].substring(1), split[1]);
        }
        return map;
    }
}
