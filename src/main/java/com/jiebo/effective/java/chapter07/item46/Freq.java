package com.jiebo.effective.java.chapter07.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.*;

/**
 * @Author jiebo2
 * @Description 统计文件中单词出现的次数-Stream中正确使用收集器Collectors的API
 * @Date 20:19 2019/5/21
 */
public class Freq {

    /**
     * 要正确使用Stream，就需要学会收集器Collectors API的使用
     * Collectors的API有39个方法，很多，但首先掌握其中最重要的常用的几种
     * 只有正确使用Stream，才能获得其带来的好处：描述性、速度、并行性
     *
     * 当你使用Stream时，优先看Collectors的API是否满足
     */

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);

        /**
         * 这种写法并没有正确使用Stream
         * 因为它在forEach里频繁改变外部状态-freq
         */
        Map<String, Long> freq = new HashMap<>();
        try (Stream<String> words = new Scanner(file).tokens()) {
            words.forEach(word -> {
                freq.merge(word.toLowerCase(), 1L, Long::sum);
            });
        }

        /**
         * Stream的正确使用
         * 配合收集器Collectors的API
         */
        Map<String, Long> freqN;
        try (Stream<String> words = new Scanner(file).tokens()) {
            freqN = words
                    .collect(groupingBy(String::toLowerCase, counting()));
        }

        /**
         * 筛选出现次数top10的单词
         */
        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());
    }
}
