package com.jiebo.effective.java.chapter05.item33;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

/**
 * @Author jiebo2
 * @Description 有限制的类型令牌-这个方法没看懂
 * @Date 12:05 2019/3/20
 */
public class PrintAnnotation {

    /**
     * 注解API(item39)就广泛使用到了有限制的类型令牌
     *
     * 使用asSubClass方法在编译时读取类型未知的注解，从而避免编译错误或警告
     */

    /**
     * 运行时读取注解的方法
     */
    public static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName){
        Class<?> annotationType = null;
        try{
            annotationType = Class.forName(annotationTypeName);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(
                    "Usage: java PrintAnnotation <class> <annotation>");
            System.exit(1);
        }
        try{

            String className = args[0];
            String annotationTypeName = args[1];
            Class<?> klass = Class.forName(className);
            System.out.println(getAnnotation(klass, annotationTypeName));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
