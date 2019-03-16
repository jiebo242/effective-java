package com.jiebo.effective.java.chapter04.item20;

import java.util.Map;
import java.util.Objects;

/**
 * @Author jiebo2
 * @Description 编写一个"抽象骨架实现类"
 * @Date 16:57 2019/3/13
 */
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {

    /**
     * 接口优于抽象类的原因如下：
     * 1.当子类需要进行更新，引入新的属性时，可以很方便的实现新的接口，而要扩展新的抽象类就比较复杂(无法更新子类来扩展新的抽象类，而只能把抽象类放在继承层次的高处，这种影响范围会影响所有的后代类)
     * 2.接口是定义mixin(混合类型)的理想选择，而抽象类无法多继承导致无法mixin
     * 3.接口允许构造非层次结构的类型框架，而抽象类的继承是有层次结构的，而这种层次结构有时候是臃肿的
     *
     * 当然，接口有个最大问题就是接口一旦添加新的抽象方法，所有的实现类都需要进行更改
     *
     * 对接口提供一个"抽象的骨架实现类"，可以把接口和抽象类的优点结合起来：
     * 1.接口负责定义类型，提供一些缺省方法
     * 2.骨架实现类则负责实现除基本类型接口方法之外，剩下的非基本类型接口方法
     *
     * 抽象骨架实现类通常起名：AbstractInterface，比如每个集合接口都有一个骨架类：AbstractCollection AbstractSet AbstractList AbstractMap
     * 接口的骨架实现类的简单实现，就是直接实现这个接口，不是抽象的，可以直接子类化
     *
     * 需要注意的一点：抽象骨架实现类就是为了继承而设计的，所以需要遵循item19说的，要有良好的文档说明
     *
     * 如何编写一个骨架实现类呢？
     * 1.首先，认真研究接口，确定哪些方法是最基本的，其他方法则可以根据它们来实现。这些基本方法则成为骨架实现类中的抽象方法
     * 2.然后，在接口中为所有可以在基本方法上直接实现的方法，提供缺省方法
     * 可以阅读上面举例的集合接口的骨架类源码，来思考哪些是基本抽象方法，而哪些要提供缺省方法，比如本例中，编写Map.Entry<K, V>抽象骨架类一样
     *
     * 作者建议：如果你导出一个重要接口，那务必考虑同时提供骨架实现类，而且尽可能的通过缺省方法在接口中提供骨架实现，以便所有接口的实现类都能使用
     */

    /**
     * 这个是基本抽象方法，需子类进行实现
     */
    @Override
    public V setValue(V vlaue){
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof Map.Entry)){
            return false;
        }
        Map.Entry<?, ?> entry = (Map.Entry)o;
        return Objects.equals(entry.getKey(), this.getKey()) && Objects.equals(entry.getValue(), this.getValue());

    }

    @Override
    public int hashCode(){
//        return Objects.hashCode(this.getKey())*31 + Objects.hashCode(this.getValue());
        return Objects.hashCode(this.getKey()) ^ Objects.hashCode(this.getValue());
    }

    @Override
    public String toString(){
        return this.getKey() + "=" + this.getValue();
    }

}
