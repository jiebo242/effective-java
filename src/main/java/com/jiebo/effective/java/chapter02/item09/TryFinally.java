package com.jiebo.effective.java.chapter02.item09;

import java.io.*;

/**
 * @Author jiebo2
 * @Description 传统方式的try-catch-finally格式来关闭资源
 * @Date 19:13 2019/3/4
 */
public class TryFinally {

    /**
     * 这个是传统方式
     * AutoCloseable是1.7才新增的，呵呵，而且还是本书作者写的
     */

    public static String firstLineOfFile(String path) throws IOException {
        //资源的初始化
        BufferedReader bis = new BufferedReader(new FileReader(path));
        try{
            //资源的操作
            return bis.readLine();
        }finally {
            //手动关闭资源
            bis.close();
        }
    }

    /**
     * 2个或多个资源的嵌套
     * 虽然代码上没啥问题，但结构不清晰
     */
    public void copy(String srcPath, String dstPath) throws IOException{
        //读资源的初始化
        InputStream in = new FileInputStream(srcPath);
        try{
            //写资源的初始化,实际上可以把这个初始化和in放在一起也行，只是这里为了表现出try-with-resources的简洁，所以这里故意写成嵌套，显得复杂些
            OutputStream out = new FileOutputStream(dstPath);
            try{
                //资源的操作
                byte[] buf = new byte[1024];
                int n;
                //循环读取，判断是否还有数据
                while((n = in.read(buf)) >= 0){
                    out.write(buf, 0, n);
                }
            }finally {
                //关闭资源
                out.close();
            }

        }finally {
            //关闭资源
            in.close();
        }
    }
}
