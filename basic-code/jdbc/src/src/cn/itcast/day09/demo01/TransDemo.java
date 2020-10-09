package src.cn.itcast.day09.demo01;

import java.io.*;
/*
      创建转换流对象，文件编码转换。
 */
public class TransDemo {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(new FileInputStream("D:\\新建文件夹\\a.txt"),"gbk");
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("D:\\新建文件夹\\e.txt"),"utf-8");
        int len=0;
        while ((len=isr.read())!=-1){
            osw.write(len);
        }
        isr.close();
        osw.close();
    }
}
