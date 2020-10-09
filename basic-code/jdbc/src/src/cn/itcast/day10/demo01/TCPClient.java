package src.cn.itcast.day10.demo01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis =new FileInputStream("D:\\新建文件夹\\a.txt");//创建字节输入流对象
        Socket socket =new Socket("192.168.100.3",8889);//创建客户端对象
        OutputStream o = socket.getOutputStream();
        int len=0;
        byte[] by=new byte[1024];
        while ((len=fis.read(by ))!=-1){
            o.write(by,0,len);
        }//读取本地资源并且将其上传到服务器
        socket.shutdownOutput();//中断文件阻塞，使后面的程序继续正常秩序
        System.out.println("while死循环结束啦");
        InputStream m = socket.getInputStream();//服务器本身没有io流，所以必须调用用户端的io流，调用getinputstream方法
        while ((len=m .read(by ))!=-1){
            System.out.println(new String(by ,0,len));
        }//读取来自服务器的回复
        fis.close();
        socket.close();//释放资源
    }
}
