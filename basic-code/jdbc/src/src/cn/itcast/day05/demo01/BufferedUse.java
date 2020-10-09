package src.cn.itcast.day05.demo01;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedUse {
    public static void main(String[] args) throws IOException {
        FileOutputStream m =new FileOutputStream("D:\\新建文件夹\\a.txt");
        BufferedOutputStream n =new BufferedOutputStream(m );
        /*  1.字节缓冲流的使用步骤，先创建字节流对象，参数给文件地址。
            2.创建字节缓冲流对象，参数使用字节流对象
            3.调用write方法，写入。
         */


        try (m ;n ){
            n.write("葛旭好靓仔！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            n.close();
        }
    }
}
