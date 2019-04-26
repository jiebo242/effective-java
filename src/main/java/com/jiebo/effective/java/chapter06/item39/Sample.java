package com.jiebo.effective.java.chapter06.item39;

/**
 * @Author jiebo2
 * @Description 注解的使用
 * @Date 20:32 2019/4/25
 */
public class Sample {

    /**
     * 因为注解的所有元素都有默认值，所以可以不设置任何元素的值
     */
    @Test
    public void test1(){

    }

    /**
     * 这种不带key的赋值方式，默认是设置 元素名为value的元素的值
     */
    @Test(2)
    public void test2(){

    }

    /**
     * 这种就是一个完整注解的元素赋值方式了
     */
    @Test(value = 3, name = {"1", "2"}, exception = RuntimeException.class)
    public void test3(){

    }
}
