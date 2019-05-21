package com.jiebo.effective.java.chapter07.item45;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Author jiebo2
 * @Description 换位词查找-迭代方式实现
 * @Date 14:51 2019/5/18
 */
public class IterativeAnagrams {

    /**
     * 需求：
     * 从一个词典文件中，读取单词，并打印出单词长度>用户指定最低值的换位词
     * 换位词：将单词的字母顺序按照从a-z重新组合，排列方式一样的就叫换位词
     *
     * 迭代方式，也就是我们最常用的循环遍历的方式来进行处理
     * for循环、while循环...
     */

    public static void main(String[] args) throws IOException {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        //将换位词放到Map中，key为按字母顺序排列后的单词，value为Set<word>
        Map<String, Set<String>> groups = new HashMap<>();
        //这种try-with-resources的写法，可以确保关闭文件
        try(Scanner s = new Scanner(dictionary)){
            while(s.hasNext()){
                String word = s.next();
                //Java8中，新增方法，面向函数接口的API
                groups.computeIfAbsent(alphabetize(word),
                        /*因为是函数接口，所以使用了lambda*/
                        (unused)->new TreeSet<>()).add(word);
            }
        }

        //打印出指定长度的换位词
        for(Set<String> group : groups.values()){
            //这一句是换位词数量>最小限制的，而不是单词的长度啊，难道需求理解错了
            if(group.size() > minGroupSize){
                System.out.println(group.size() + ":" + group);
            }
        }
    }


    /**
     * alphabetize
     * @Author jiebo2
     * @Description 将一个单词按照字母a-z的顺序重新排列
     * @Date 2019/5/18 15:01
     * @Param [word]
     * @Return java.lang.String
     */
    private static String alphabetize(String word){
        char[] alphabets = word.toCharArray();
        Arrays.sort(alphabets);
        return new String(alphabets);
    }
}
