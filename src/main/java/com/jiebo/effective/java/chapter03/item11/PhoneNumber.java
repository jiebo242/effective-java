package com.jiebo.effective.java.chapter03.item11;

import java.util.Objects;

/**
 * PhoneNumber
 * @Author jiebo2
 * @Description 重写hashCode方法
 * @Date 2019/3/6 17:15
 */
public class PhoneNumber {
    /**
     * 重写equals方法时，也务必重写hashCode方法，不然会违背hashCode方法3条约定的第2条，进而影响这些类在基于散列的集合(HashMap，HashSet)中的正常使用
     *
     * hashCode的3条约定：
     * 1.同一个对象返回的hashCode一致
     * 2.equals相同的两个对象，他们的hashCode也一致
     * 3.hashCode相同的两个对象的equals不要求一定相同
     *
     * 重写hashCode方法的3种常用方式：
     * 1.获取每个关键域(也就是参与equals方法的域)的hashCode并累加，比如String\Arrays的都是用的这种方式
     * 2.使用Objects.hash
     * 3.对于计算hashCode开销大的情况，建议进行缓存(1.创建实例时计算保存 2.延迟初始化，在第一次调用hashCode方法时计算并保存)
     * 当然最后还有一种，就是利用lomboke和AutoValue来自动重写，具体的实现可以看item10
     * 此外，建议阅读下几个包装类的hashCode是咋获取几种基本类型的hashCode的，其他的类一层层分解都是到基本类型
     */
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum){
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    //方法1：
    //为何使用31：(1)奇素数，不像偶数那样存在乘法溢出而导致信息丢失的问题 (2)31的乘法可以用移位和减法来代替，有更好的性能(31*i ==> (i<<5)-i),这个转化JVM会自动优化
    @Override
    public int hashCode(){
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    //方法2：
    //最简单，但是因为用到数组，所以性能上慢
    //Objects.hash()底层是调用的Arrays.hashCode
//    @Override
//    public int hashCode(){
//        return Objects.hash(areaCode, prefix, lineNum);
//    }

    //方法3：
    //实现方法和方法1一样，只是添加上了hashCode的缓存
//    private int hashCode;
//    @Override
//    public int hashCode(){
//        int result = hashCode;
//        if(0 == result){
//            result = Short.hashCode(areaCode);
//            result = 31 * result + Short.hashCode(prefix);
//            result = 31 * result + Short.hashCode(lineNum);
//            hashCode = result;
//        }
//        return result;
//
//    }


    public static void main(String[] args) {
        PhoneNumber pn1 = new PhoneNumber((short)707, (short)867, (short)5309);
        PhoneNumber pn2 = new PhoneNumber((short)707, (short)867, (short)5309);

        //不重写hashCode方法，pn1和pn2的hashCode会不一致
        System.out.println(pn1.hashCode());
        System.out.println(pn2.hashCode());
    }
}
