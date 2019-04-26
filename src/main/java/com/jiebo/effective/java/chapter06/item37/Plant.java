package com.jiebo.effective.java.chapter06.item37;

import com.jiebo.effective.java.chapter06.item34.Planet;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author jiebo2
 * @Description EnumMap的使用示例
 * @Date 20:00 2019/4/23
 */
public class Plant {

    /**
     * 枚举定义-植物的生命周期(一年生、多年生、两年生)
     */
    enum LifeCycle{
        ANNUAL, PERENNIAL, BIENNIAL
    }

    private final String name;
    private final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle){
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    /**
     * 通过EnumMap的方式来将gargen里的植物按照生命周期进行归类
     * 1.看EnumMap的源码，它有好几个构造器，不过就是没有无参构造器，这里用到的是传入ClassType来制定Map的key的类型
     * 2.EnumMap的key通过泛型制定必须为Enum
     */
    Map<LifeCycle, Set<Plant>> plantsByLife = new EnumMap<>(LifeCycle.class);

    public static void main(String[] args) {
        Plant[] garden = {
                new Plant("Basil",    LifeCycle.ANNUAL),
                new Plant("Carroway", LifeCycle.BIENNIAL),
                new Plant("Dill",     LifeCycle.ANNUAL),
                new Plant("Lavendar", LifeCycle.PERENNIAL),
                new Plant("Parsley",  LifeCycle.BIENNIAL),
                new Plant("Rosemary", LifeCycle.PERENNIAL)
        };
        //将garden里的植物按生命周期进行分类
        Map<LifeCycle, Set<Plant>> plantsByLife = new EnumMap<>(LifeCycle.class);
        //先根据Enum的值将Map初始化
        for(LifeCycle lifeCycle : LifeCycle.values()){
            plantsByLife.put(lifeCycle, new HashSet<Plant>());
        }
        //再循环garden，根据生命周期进行匹配
        for(Plant plant : garden){
            plantsByLife.get(plant.lifeCycle).add(plant);
        }
        /**
         * 感觉就是Map啊，用法也和Map一样，不过就是是一种特殊情况(key是Enum类型)
         * 可能就是把Enum和Map的好处结合起来
         * 那什么使用会用到EnumMap呢，我感觉就是需要根据Enum来进行分类的时候
         */
    }
}
