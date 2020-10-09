package src.cn.itcast.day05.demo01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/*  1.字符缓冲流的使用步骤，先创建字符流对象，参数给文件地址。
           2.创建字符缓冲流对象，参数使用字符流对象
           3.调用write方法，读取。
        */
public class BufferedUse03 {
    public static void main(String[] args) throws IOException {
        BufferedWriter m=new BufferedWriter(new FileWriter("D:\\新建文件夹\\b.txt"));
        for (int i = 0; i <10 ; i++) {
            m.write("你好中国",2,2);
            m.newLine();//换行
        }
        m.flush();
        m.close();
    }
}
