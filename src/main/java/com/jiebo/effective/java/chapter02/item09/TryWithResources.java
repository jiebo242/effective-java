package com.jiebo.effective.java.chapter02.item09;

import java.io.*;

/**
 * @Author jiebo2
 * @Description 1.7以后新型的try-with-resources格式来关闭资源
 * @Date 19:13 2019/3/4
 */
public class TryWithResources {

    /**
     * 最大的优点是不用再手动关闭资源,省了好几行代码
     * 1.该资源需要实现AutoCloseable
     * 2.资源的创建在try()里面
     * 3.作者说这种形式的写法，会保留第一个异常，禁止后面的异常，这个正好和try-catch-finally是相反的
     */

    public static String firstLineOfFile(String path) throws IOException {
        try(
            //资源的初始化
            BufferedReader bis = new BufferedReader(new FileReader(path))){
            //资源的操作
            return bis.readLine();
        }
    }

    /**
     * 2个或多个资源的时候代码更加简洁
     */
    public void copy(String srcPath, String dstPath) throws IOException{
        try(
            //读资源的初始化
            InputStream in = new FileInputStream(srcPath);
            //写资源的初始化
            OutputStream out = new FileOutputStream(dstPath)) {
            //资源的操作
            byte[] buf = new byte[1024];
            int n;
            //循环读取，判断是否还有数据
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }
}
