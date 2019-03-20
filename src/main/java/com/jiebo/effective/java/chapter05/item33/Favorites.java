package com.jiebo.effective.java.chapter05.item33;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author jiebo2
 * @Description 类型安全的异构容器
 * @Date 11:16 2019/3/20
 */
public class Favorites {

    /**
     * 类型安全之前已经频繁提到过了，就是通过泛型在编译时能够确保参数的类型
     * 那啥是异构容器呢？
     * 就是相比于参数化了的容器(整个容器进行了参数化限制，只能存放固定类型的元素)，通过类型令牌实现将键key进行参数化而不是将容器参数化，从而可以存放不同类型的元素
     *
     * 类型令牌：
     * 当一个类的字面被用在方法中，来传达编译时和运行时的类型信息时，就被称作类型令牌
     * 比如String.class属于Class<String>类型，Integer.class属于Class<Integer>类型
     */
    //异构容器，key通过类型令牌实现,value为Object
    private Map<Class<?>, Object> favorites = new HashMap<>();

    //存放异构元素
    public <T> void putFavorite(Class<T> type, T instance){
        //用到了动态转换，来保证类型的安全,cast的底层实现也是先判断类型再进行强转
        favorites.put(type, type.cast(instance));
    }

    //获取异构元素
    public <T> T getFavorite(Class<T> type){
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 123);
        f.putFavorite(Class.class, Favorites.class);
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        //java使用print打印也和C一样，可以通过%s %x指定打印的类型，%n会产生当前平台的行分隔符
        System.out.printf("%s %s %s %n", favoriteString,
                favoriteInteger, favoriteClass.getName());
    }
}
