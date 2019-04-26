package com.jiebo.effective.java.chapter06.item36;

/**
 * @Author jiebo2
 * @Description 通过位域来实现枚举类型的集合
 * @Date 20:04 2019/4/9
 */
public class TextByBitField {
    /**
     * 实际上，这一条的场景并不是很理解，可能是平常用到的地方不多吧
     *
     * 书中说：用OR位运算将几个常量合并到一个集合中，称作位域bit field
     * 感觉就像C++里面，为了节约空间，将不到一个字节的(以位为单位的)几个标识符放到一个字节(或几个字节)的结构体的一种做法
     *
     * 位域具有int枚举常量的所有缺点
     */

    public static final int STYLE_BOLD = 1 << 0;//1
    public static final int STYLE_ITALIC = 1 << 1;//2
    public static final int STYLE_UNDERLINE = 1 << 2;//4
    public static final int STYLE_STRIKETHROUGH = 1 << 3;//8
}
