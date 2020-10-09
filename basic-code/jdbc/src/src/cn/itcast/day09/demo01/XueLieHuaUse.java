package src.cn.itcast.day09.demo01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
/*
    序列的使用，需要注意类中必须实现serializable接口
 */
public class XueLieHuaUse {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("D:\\新建文件夹\\C.txt"));
        os.writeObject(new Person("小红",18));
        os.close();
    }
}
