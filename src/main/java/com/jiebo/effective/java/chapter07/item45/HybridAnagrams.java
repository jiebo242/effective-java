package com.jiebo.effective.java.chapter07.item45;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * @Author jiebo2
 * @Description 换位词查找-迭代+Stream方式实现
 * @Date 08:39 2019/5/20
 */
public class HybridAnagrams {

    /**
     * 不要一股脑儿的想着把所有的循环转换成Stream
     *
     * 有些场景使用Stream，有些场景使用迭代，而大部门情况则需要两者混用，才能达到代码简洁、可读性高的效果
     * Stream是通过函数对象(Lambda/方法引用)来描述重复的计算--这个一定记住，Stream是和函数对象一起使用的
     * 迭代版本则利用代码块来描述重复的计算
     *
     * 不适合Stream的场景+适合Stream的场景，见书中P162
     *
     */

    public static void main(String[] args) throws IOException {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        try (Stream<String> words = Files.lines(dictionary)) {
            //就排序单词的这块没用Stream，因为比较长，所以单独抽出来一个方法
            words.collect(groupingBy(word -> alphabetize(word)))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .forEach(g -> System.out.println(g.size() + ": " + g));
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
