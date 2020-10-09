package src.cn.itcast.day08.demo01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo02Reader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("E:\\c.txt");//创建对象
       /* int len=0;
        while((len=fr.read())!=-1){
            System.out.print((char)len);
        }*/
        char[] m=new char[1024];
        int len =0;
        while((len=fr.read(m))!=-1){
            System.out.println(new String(m ,0,len));
            //这是String类的构造方法，把字符数组一部分转化为字符串，offset是开始索引，count是个数。
        }
       fr.close();

    }
}
