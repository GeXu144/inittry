package src.cn.itcast.day05.demo01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedUse04 {
    public static void main(String[] args) throws IOException {
        BufferedReader n=new BufferedReader(new FileReader("D:\\新建文件夹\\b.txt"));
        String line;
        while ((line=n.readLine())!=null){
            System.out.println(line);
        }
        n.close();
    }
}
