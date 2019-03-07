package com.jiebo.effective.java.chapter03.item10;


import lombok.Builder;
import lombok.EqualsAndHashCode;

import java.util.Objects;

/**
 * @Author jiebo2
 * @Description equals方法-对称性验证-使用lombok插件
 * @Date 15:50 2019/3/5
 */
@EqualsAndHashCode
@Builder
public class CaseInsensitiveStringWithLombok {
    /**
     * 通过lombok的注解@EqualsAndHashCode自动生成equals方法和hashcode方法
     */
    @Builder.Default
    private final String s;

    public CaseInsensitiveStringWithLombok(String s){
        //JDK以及一些常用的第三方框架已经封装好了一些工具方法，注意整理和使用
        this.s = Objects.requireNonNull(s);
    }

    public static void main(String[] args) {
        //验证对称性
        CaseInsensitiveStringWithLombok s1 = new CaseInsensitiveStringWithLombok("java");
        String s2 = "java";
        CaseInsensitiveStringWithLombok s3 = new CaseInsensitiveStringWithLombok("java");

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
        //3254877
        //3254818
        //3254877


        //通过添加@Builder很简单就支持了构建器Builder方式，@Builder注解会给此类添加一个private的构造方法
        //lombok比AutoValue简单些，不过AutoValue能看到自动生成的代码这点挺好的(lombok也可以看编译后的class，来看lombok生成的代码是啥样的)
        //简单场景下，使用lombok足够了，简单方便，在更加复杂的场景（接口类、抽象类、实现类），考虑使用AutoValue，更复杂场景下可能就需要手写了
        CaseInsensitiveStringWithLombok s4 = CaseInsensitiveStringWithLombok.builder().s("java").build();
        System.out.println(s1.equals(s4));
        System.out.println(s4.hashCode());
    }

}
