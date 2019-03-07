package com.jiebo.effective.java.chapter03.item14;

import java.util.Comparator;

/**
 * @Author jiebo2
 * @Description 如何编写一个好的compareTo方法
 * @Date 19:10 2019/3/7
 */
public class PhoneNumber implements Comparable<PhoneNumber> {
    /**
     * 什么样的类需要实现Comparable接口呢：
     * 1.值类 2.对排序敏感的类
     * compareTo方法的实现和item10里equals方法的实现做个对比
     * 相似的地方：
     * 主要是2者都要求类似的约定：自反性、对称性、传递性
     * 还有个非强制要求但也希望能遵守的约定：若a.compareTo(b)==0,则希望a.equals(b)==true
     * 主要影响在于：一般集合添加元素比较的是equals方法，而有序集合存放元素比较的是compareTo方法(书中拿HashSet和TreeSet存放BigDecimal举例)
     *
     * 不同的地方：
     * compareTo只能2个相同类型的对象进行比对，而equals是和object进行比对
     * 所以compareTo不存在equals那么复杂的逻辑
     *
     * 编写compareTo方法的3种方式：
     * 1.实现Comparable接口并实现compareTo方法
     * 2.使用Comparator接口的比较器构造方法，以及该接口提供的数字基本类型的比较器构造方法、对象引用类型的比较器构造方法(JDK1.8开始允许interface里包含public/default修饰的含方法体了)
     * 3.临时比对一个没有实现comparable接口的类 or 不想按照此类的compareTo方法的比较逻辑进行比对
     */

    private final short areaCode, prefix, lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum){
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    //方法1-传统的
//    @Override
//    public int compareTo(PhoneNumber o) {
//        /**
//         * 从最关键域进行比对，不==0(即相等)则继续进行下一个域的比较
//         */
//        int result = Short.compare(this.areaCode, o.areaCode);
//        if(0 == result){
//            result = Short.compare(this.prefix, o.prefix);
//            if(0 == result){
//                result = Short.compare(this.lineNum, o.lineNum);
//            }
//        }
//        return result;
//    }

    //方法2-Comparator接口的比较器构造方法
    //注意写法,这里是comparator的一种写法，另一种写法见方法3
    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber pn) -> pn.prefix)
                .thenComparingInt(pn -> pn.lineNum)
                .thenComparingInt(pn -> pn.areaCode);

    @Override
    public int compareTo(PhoneNumber o) {
        return COMPARATOR.compare(this, o);
    }


    public static void main(String[] args) {
        PhoneNumber pn1 = new PhoneNumber((short)2, (short)3, (short)6);
        PhoneNumber pn2 = new PhoneNumber((short)4, (short)2, (short)6);
        System.out.println(pn1.compareTo(pn2));

        //方法3-实际上和方法2是一样的，只是这个比较器是临时的
        //这里本来想用compartor的另一种写法，但是只能比较一个属性，不能比较三个属性
        Comparator<PhoneNumber> comparator = (t1, t2) ->
                Short.valueOf(t1.lineNum).compareTo(t2.lineNum);

        System.out.println(comparator.compare(pn1, pn2));

    }


}
