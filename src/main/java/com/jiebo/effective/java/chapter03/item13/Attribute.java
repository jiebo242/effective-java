package com.jiebo.effective.java.chapter03.item13;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author jiebo2
 * @Description 属性类
 * @Date 14:29 2019/3/7
 */
@Getter
@Setter
@ToString
public class Attribute implements Cloneable{

    private String attributeString;

    @Override
    public Attribute clone(){
        try{
            return (Attribute)super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
}
