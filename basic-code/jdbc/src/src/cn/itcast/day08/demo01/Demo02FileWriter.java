package src.cn.itcast.day08.demo01;

import java.io.FileWriter;
import java.io.IOException;

//字符输出流，最后需要flush刷新内存才能存入硬盘。
public class Demo02FileWriter {
    public static void main(String[] args) throws IOException {
       FileWriter fw =new FileWriter("E:\\c.txt",true);//续写格式如以下代码，append是续写开关
        // true代表不会覆盖之前的内容

        for (int  i = 0;  i <10 ;  i++) {
            fw.write("helloworld"+i+" \r\n" );
        }
       /*fw.write(97);//写入单个字符。
        char[] m ={'a','b','c','d'};
        fw.write(m);//写入多个字符
        fw.write(m,2,2);//从字符数组中由索引开始两个字符写入
        fw.write("葛旭喜欢");
        fw.write("很漂亮",3,3);*/

       fw.close();//刷新，跟close的区别是，flush刷新之后流对象可以使用，而close刷新之后释放内存，流对象不可再使用。
    }
}
