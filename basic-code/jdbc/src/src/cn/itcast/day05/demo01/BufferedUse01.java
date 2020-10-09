package src.cn.itcast.day05.demo01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
/*  1.字节缓冲流的使用步骤，先创建字节流对象，参数给文件地址。
           2.创建字节缓冲流对象，参数使用字节流对象
           3.调用read方法，读取。
        */
public class BufferedUse01 {
    public static void main(String[] args) throws IOException {
        FileInputStream a =new FileInputStream("D:\\新建文件夹\\a.txt");
        BufferedInputStream b =new BufferedInputStream(a );
        int len=0;
        while((len=b.read())!=-1){
            System.out.println(len);
        }
        b.close();
    }
}
