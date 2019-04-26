package com.jiebo.effective.java.chapter06.item36;

/**
 * @Author jiebo2
 * @Description 使用enumSet来处理枚举类型的集合
 * @Date 20:11 2019/4/9
 */
public class TextByEnumSet {

    /**
     * 作者推荐使用EnumSet代替位域(实际上EnumSet在内部具体实现上，每个EnumSet内容都表示为位矢量)：
     * 1.性能上比得上位域
     * 2.EnumSet做了位运算的封装，可以避免手工位操作时容易出现的错误以及丑陋的代码
     *
     * EnumSet有个缺点，就是截止Java9，都无法创建不可变的EnumSet，虽然可以用Collections.unmodifiableSet将EnumSet封装起来，但是简洁性和性能会收到影响
     */

    /**
     * 内部类
     */
    public enum Style{
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }
}
