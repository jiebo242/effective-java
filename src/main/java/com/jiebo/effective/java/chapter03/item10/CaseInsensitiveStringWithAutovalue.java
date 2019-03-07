package com.jiebo.effective.java.chapter03.item10;


import com.google.auto.value.AutoValue;


/**
 * @Author jiebo2
 * @Description equals方法-对称性验证-使用AutoValue注解
 * @Date 15:50 2019/3/5
 */
@AutoValue
public abstract class CaseInsensitiveStringWithAutovalue {
    /**
     * 使用AutoValue的@AutoValue注解来自动实现equals和hashcode方法
     * 不过这个的用法比lombok要复杂
     * 1.自己的这个类需要写成可继承的，一般是写成抽象类
     * 2.编译的时候AutoValue自动继承此类，并实现equals和hashcode方法
     * 因为多了一个类，感觉代码冗余,而且这个原始类的写法就没有那么随意了
     * 官方使用方法说明https://github.com/google/auto/blob/master/value/userguide/index.md
     */

    /**
     * 相当于不用写属性，而是写了个属性的get方法
     */
    abstract String s();

    /**
     * 这个方法的名字没有限制
     * 不过需执行mvn compile命令编译下，自动生成实现类，要不然AutoValue_CaseInsensitiveStringWithAutovaule是找不到的
     * 插件自动生成的实现类的位置：target/classes 和 target/generated-sources下面对应的package里
     * 看了下，自动生成的方法和自己手动实现的差不多
     */
    static CaseInsensitiveStringWithAutovalue create(String s){
        return new AutoValue_CaseInsensitiveStringWithAutovalue(s);
    }

    /**
     * 和lombok一样，AutoValue也支持构建器Builder方式，不过实现方式也比较复杂
     * 测试后发现，添加了Builder，AutoValue会自动把构造器AutoValue_CaseInsensitiveStringWithAutovalue置为private的，所以不像lombok，两种方式不能并存
     * 如果使用Builder方式，需把方法create注销调，并放开下面的代码
     */
//    static Builder builder(){
//        return new AutoValue_CaseInsensitiveStringWithAutovalue.Builder();
//    }
//
//    @AutoValue.Builder
//    abstract static class Builder{
//        abstract Builder s(String s);
//        abstract CaseInsensitiveStringWithAutovalue build();
//    }

}
