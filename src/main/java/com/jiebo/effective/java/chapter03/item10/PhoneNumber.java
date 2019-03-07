package com.jiebo.effective.java.chapter03.item10;

/**
 * @Author jiebo2
 * @Description 如何编写一个好的equals方法
 * @Date 16:14 2019/3/5
 */
public class PhoneNumber {
    /**
     * 1.先使用==比较2个对象的引用
     * 2.使用instanceof检查参数是否为正确的类型
     * 3.将参数转换为正确的类型并依次比较2个实例的每个"关键"域
     * 4.写完之后编写测试用例测试对称性、传递性、一致性等
     * ps:我发现作者特别喜欢使用final修饰符，估计是本着"最小可变性"的原则
     *
     * 这里作者推荐使用google开源的AutoValue框架来自动生成equals、hashcode等方法
     * 了解之后发现，这个AutoValue和lombok挺像的，都是自动生成一些通用方法和一些通用的校验，但AutoValue用起来更加复杂，但是在复杂的场景（接口类、抽象类、实现类）上扩展性更大
     * 具体代码可参考：CaseInsensitiveStringWithLombok和CaseInsensitiveStringWithAutovalue
     * 这种自动化插件确实挺灵活的，用熟了之后能节省很多开发量和冗余代码，但是我认为根本上我们还是要能手动写出这些方法，才能更好的理解和掌握这些工具
     */
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum){
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public boolean equals(Object obj){
        //先直接比较2个实例的引用是否相同
        if(this == obj){
            return true;
        }
        //进行类型的校验和转换
        if(!(obj instanceof PhoneNumber)){
            return false;
        }
        PhoneNumber pn = (PhoneNumber)obj;
        //进行关键域的比对
        //这里有个小诀窍：优先比较那些最可能不一致的属性
        //ps：基本类型里，除了浮点型float和double，其他都可以直接使用==比对
        //浮点型应该使用Float.compare和Double.compare,不建议使用Float.equals和Double.equals,因为自动装箱影响性能
        return pn.lineNum == this.lineNum && pn.areaCode == this.areaCode && pn.prefix == this.prefix;
    }
}
