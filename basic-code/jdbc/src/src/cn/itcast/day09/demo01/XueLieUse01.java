package src.cn.itcast.day09.demo01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/*
    反序列化的使用
 */
public class XueLieUse01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois =new ObjectInputStream(new FileInputStream("D:\\新建文件夹\\C.txt"));
        Object m = ois.readObject();//调用反序列化的readObject方法进行读取
        ois.close();//释放资源
        System.out.println(m);//打印person类
    }
}
