package com.kellonge.demo.snippets.java.base;

/**
 * 错误处理-出错的时候找到报错的代码位置
 * 1.Throwable的getCause是由多个的，所以需要循环找到最初的错误
 * @author kellonge
 * @version $Id: FindCauseExceptionMain.java, v 0.1 2016年4月22日 下午5:55:51 kellonge Exp $
 */
public class FindCauseExceptionMain {
    public static void main(String[] args) {
        try {
            get1Level();
        } catch (Exception e) {
            handleException(e);
        }
    }

    private static void get1Level() throws Exception {
        try {

            get2Level();
        } catch (Exception e) {
            throw new Exception("第一层，参数错误", e);
        }
    }

    private static void get2Level() throws Exception {
        try {
            get3Level();
        } catch (Exception e) {
            throw new Exception("第二层，空指针错误", e);
        }
    }

    private static void get3Level() {
        int tmp = 1 / 0;
    }

    private static void handleException(Exception e) {
        Throwable falg = e.getCause();
        Throwable source = null;
        while (falg != null) {
            falg = falg.getCause();
            if (null != falg) {
                source = falg;
            }
        }
        if (null == source) {
            source = e;
        }
        StackTraceElement[] stackTrace = source.getStackTrace();
        if (stackTrace.length > 0) {
            StackTraceElement stackTraceElement = stackTrace[0];
            System.out.println(String.format("%s at %s.%s(%s:%s)", source.getMessage(),
                stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(),
                stackTraceElement.getLineNumber()));
        }

    }
}
