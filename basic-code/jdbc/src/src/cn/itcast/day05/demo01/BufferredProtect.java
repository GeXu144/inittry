package src.cn.itcast.day05.demo01;

import java.io.*;
import java.util.HashMap;
/*
      1.先创建map集合，泛型皆为string类型
      2.创建字符缓冲流，调用BufferedReader中的readline方法逐行读取文件，然后利用split方法分割文件，存入集合
      3.遍历集合得到相对应的文本，即排好序之后的文本。
      4.创建字符缓冲流，调用write方法，写入硬盘。

 */
public class BufferredProtect {
    public static void main(String[] args) throws IOException {
        HashMap<String,String> map=new HashMap<>();
        BufferedReader n=new BufferedReader(new FileReader("D:\\新建文件夹\\b.txt"));
        BufferedWriter m=new BufferedWriter(new FileWriter("D:\\新建文件夹\\C.txt"));
        String line;
        while ((line=n.readLine())!=null){
            String[] arr = line.split("\\.");//分割文件的方法，以"."分割返回字符串数组。
            map.put(arr[0],arr[1]);
        }
        for (String key:map.keySet()) {
            String value = map.get(key);
            line=key+"."+value;
            System.out.println(line);
            m.write(line);
            m.newLine();
        }
        n.close();
        m.close();
    }
}
