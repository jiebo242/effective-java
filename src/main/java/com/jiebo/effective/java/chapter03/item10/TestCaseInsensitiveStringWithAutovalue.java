package com.jiebo.effective.java.chapter03.item10;


/**
 * @Author jiebo2
 * @Description equals方法-对称性验证-使用AutoValue插件
 * @Date 15:50 2019/3/5
 */
public class TestCaseInsensitiveStringWithAutovalue {

    public static void main(String[] args) {
        //验证对称性
        CaseInsensitiveStringWithAutovalue s1 = CaseInsensitiveStringWithAutovalue.create("java");
        String s2 = "java";
        CaseInsensitiveStringWithAutovalue s3 = CaseInsensitiveStringWithAutovalue.create("java");

        //交换着进行比对，结果是不同的
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s1));
        System.out.println(s1.equals(s3));
        System.out.println(s3.equals(s1));

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());

        //输出结果
        //false
        //true
        //true
        //4122721
        //3254818
        //4122721

        //构建器方式实例化对象

//        //验证对称性
//        CaseInsensitiveStringWithAutovalue s1 = CaseInsensitiveStringWithAutovalue.builder().s("java").build();
//        String s2 = "java";
//        CaseInsensitiveStringWithAutovalue s3 = CaseInsensitiveStringWithAutovalue.builder().s("java").build();
//
//        //交换着进行比对，结果是不同的
//        System.out.println(s1.equals(s2));
//        System.out.println(s2.equals(s1));
//        System.out.println(s1.equals(s3));
//        System.out.println(s3.equals(s1));
//
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
//        System.out.println(s3.hashCode());
//
//        //输出结果和上面是一样的
//        //false
//        //true
//        //true
//        //4122721
//        //3254818
//        //4122721
    }

}
