package com.jiebo.effective.java.chapter07.item45;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * @Author jiebo2
 * @Description 换位词查找-Stream方式实现
 * @Date 15:23 2019/5/18
 */
public class StreamAnagrams {

    /**
     * 啥是Stream，你可以理解为直接将一个文件、集合、数组等直接转换成流的形式来进行操作和计算，但不是那种字节流、字符流啥的
     * Stream的元素可以是引用类型或者基本类型(int,long,double)
     *
     * Stream的过度使用，不建议这么做
     * 因为滥用Stream，导致程序代码难以读懂和维护
     *
     * Java8中增加的Stream API是为了简化大批量的操作or计算时使用的
     * Stream API是流式的，默认Stream pipeline是顺序执行(串行)
     *
     * 使用得当，Stream可以让程序变得简洁清晰
     * 使用不当，则会让程序变得混乱且难以维护(本例就是这种)
     */

    public static void main(String[] args) throws IOException {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        //将换位词放到Map中，key为按字母顺序排列后的单词，value为Set<word>
        Map<String, Set<String>> groups = new HashMap<>();
        //这种try-with-resources的写法，可以确保关闭文件
        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(
                    //又是方法引用，又是lambda，看不懂
                    groupingBy(word -> word.chars().sorted()
                            .collect(StringBuilder::new,
                                    (sb, c) -> sb.append((char) c),
                                    StringBuilder::append).toString()))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .map(group -> group.size() + ": " + group)
                    .forEach(System.out::println);
        }

        //打印出指定长度的换位词
        for(Set<String> group : groups.values()){
            //这一句是换位词数量>最小限制的，而不是单词的长度啊，难道需求理解错了
            if(group.size() > minGroupSize){
                System.out.println(group.size() + ":" + group);
            }
        }
    }
}
