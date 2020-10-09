package src.cn.itcast.day05.demo01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class UseProperties {
    public static void main(String[] args) throws IOException {
        show02();

    }

    private static void show02() throws IOException {
        Properties m =new Properties();
        m.load(new FileReader("E:\\a.txt"));
        Set<String> set = m.stringPropertyNames();
        for (String key : set) {
            String  value = m.getProperty(key);
            System.out.println(key+"=="+value);//读取文件中的数据遍历

    }

   /* private static void show01() throws IOException {//这是store方法存入硬盘的操作
        Properties m =new Properties();
        m.setProperty("葛旭","175");
        m.setProperty("张煜","167");
        m.setProperty("李雅琪","162");
        FileWriter fw =new FileWriter("E:\\a.txt");
        m.store(fw,"save date");*/
        /*Set<String> set = m.stringPropertyNames();使用集合的case
        for (String key : set) {
            String  value = m.getProperty(key);
            System.out.println(key+"=="+value);
        }*/
    }
}
