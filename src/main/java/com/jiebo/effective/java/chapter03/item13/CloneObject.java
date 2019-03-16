package com.jiebo.effective.java.chapter03.item13;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author jiebo2
 * @Description 使用clone方法来克隆对象
 * @Date 14:30 2019/3/7
 */
@Getter
@Setter
@ToString
public class CloneObject implements Cloneable {

    /**
     * 首先需要实现Cloneable，不然执行clone方法会报CloneNotSupportedException
     * 为CloneObject添加各种类型的属性，用于验证哪些类型是需要拷贝内部信息的
     */

    //基本类型
    private int num;

    //引用类型-字符串类型(因为String是不可变对象，当它变的时候实际上是一个新的对象了，所以克隆对它没影响或者说没必要)
    private String cloneString;

    //引用类型-实体
    private Attribute attribute;

    //引用类型-数组
    private String[] array;

    public CloneObject(int num, String cloneString, Attribute attribute, String[] array){
        this.num = num;
        this.cloneString = cloneString;
        this.attribute = attribute;
        this.array = array;
    }

    /**
     * 直接复用object的clone方法
     */
//    @Override
//    public CloneObject clone(){
//        try{
//            return (CloneObject)super.clone();
//        }catch (CloneNotSupportedException e){
//            throw new AssertionError();
//        }
//    }

    /**
     * 重写靠谱的clone方法
     * 相当于是需要一层层的对每个域进行clone，直到基础类型
     */
    @Override
    public CloneObject clone(){
        try{
            CloneObject cloneObject = (CloneObject)super.clone();
            //将引用类型的属性依次克隆
            cloneObject.array = array.clone();
            cloneObject.attribute = attribute.clone();
            return cloneObject;
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }

    /**
     * 使用拷贝构造器或者拷贝静态工厂方法代替clone
     * 相当于就是一个构造器，重新实例化一个对象，然后设置新对象的各属性和克隆对象保持一致
     * 这种方式，实际上违背了cloneable架构的从基础的逐域复制的机制的，而且性能也比clone
     * 但是作者建议使用这种方式，因为有很多好处：
     * 1.不依赖于某一种很有风险的、语言之外的对象创建机制
     * 2.不会与final域的正常使用发生冲突
     * 3.不会抛出不必要的受检查异常
     * 4.不需要进行类型转化
     * 除非以下2种场景才推荐使用：
     * 1.有性能优化的要求 2.数组的clone方法很好，可以直接用
     */
    public static CloneObject cloneInstance(CloneObject originObject){
        //这种写法不行，因为还是传递的引用给克隆后的对象
//        return new CloneObject(originObject.num, originObject.cloneString, originObject.attribute, originObject.array);
        //得一个个属性进行初始化
        Attribute attribute = new Attribute();
        attribute.setAttributeString(originObject.attribute.getAttributeString());
        String[] cloneArray = originObject.array.clone();
        return new CloneObject(originObject.num, originObject.cloneString, attribute, cloneArray);
    }


    /**
     * 分别复用object的clone方法和重写clone方法进行测试
     * 直接复用clone的情况下,对克隆后对象的操作会影响到原对象
     */
    public static void main(String[] args) {
        //先初始化一个对象
        Attribute attribute = new Attribute();
        attribute.setAttributeString("origin");
        String[] originArray = {"1", "2"};

        CloneObject originObject = new CloneObject(1, "origin", attribute, originArray);

        /****************clone的方式**********************/
        //进行克隆
        CloneObject cloneObject = originObject.clone();
        System.out.println("###" + originObject);
        System.out.println("###" + cloneObject);

        //修改原对象(这种修改方式，对于克隆后的对象是没有影响的，因为这种修改方式是替换的整个属性，直接将引用整个是给替换掉了)
        originObject.setNum(2);
        originObject.setCloneString("22");
        Attribute attribute2 = new Attribute();
        attribute2.setAttributeString("222");
        String[] originArray2 = {"3", "4"};
        originObject.setAttribute(attribute2);
        originObject.setArray(originArray2);

        //观察克隆后的对象是否收到了影响
        System.out.println("###" + originObject);
        System.out.println("###" + cloneObject);

        //重新克隆1个
        CloneObject cloneObject3 = originObject.clone();
        System.out.println("------------------------------");
        System.out.println("¥¥¥" + originObject);
        System.out.println("¥¥¥" + cloneObject3);

        //修改原对象(这种方式是对某个引用类型的属性其中一个元素进行变化，而clone对象的引用是和orgin一样的，所以在引用地址不变的情况，引用对应的内容发生变化会对origin和clone对象都产生影响)
        //需注意基本类型和String类型是不受影响的
        originObject.setNum(3);
        originObject.setCloneString("33");
        originObject.getAttribute().setAttributeString("333");
        originObject.getArray()[0] = "5";
        originObject.getArray()[0] = "6";

        //观察克隆后的对象是否收到了影响
        System.out.println("¥¥¥" + originObject);
        System.out.println("¥¥¥" + cloneObject3);

        /****************静态拷贝工厂方法的方式**********************/
        //重新克隆1个
        CloneObject cloneObject4 = CloneObject.cloneInstance(originObject);
        System.out.println("------------------------------");
        System.out.println("***" + originObject);
        System.out.println("***" + cloneObject4);

        //修改原对象(这种方式是对某个引用类型的属性其中一个元素进行变化，而clone对象的引用是和orgin一样的，所以在引用地址不变的情况，引用对应的内容发生变化会对origin和clone对象都产生影响)
        //需注意基本类型和String类型是不受影响的
        originObject.setNum(4);
        originObject.setCloneString("44");
        originObject.getAttribute().setAttributeString("444");
        originObject.getArray()[0] = "7";
        originObject.getArray()[0] = "8";

        //观察克隆后的对象是否收到了影响
        System.out.println("***" + originObject);
        System.out.println("***" + cloneObject4);
    }

}
