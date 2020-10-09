package cn.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 通知类
 */
public class logger {

    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("beforePrintLog开始记录日志了！");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("afterReturningPrintLog开始记录日志了！");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog(){
        System.out.println("afterThrowingPrintLog开始记录日志了！");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("afterPrintLog开始记录日志了！");
    }
    public Object around(ProceedingJoinPoint point){
        Object reValues=null;
        try {
            Object[] args = point.getArgs();
            beforePrintLog();
            point.proceed(args);
            afterReturningPrintLog();
        } catch (Throwable throwable) {
            afterThrowingPrintLog();
            throw new RuntimeException(throwable);

        }finally {
            afterPrintLog();
        }
        return reValues;
    }
}
