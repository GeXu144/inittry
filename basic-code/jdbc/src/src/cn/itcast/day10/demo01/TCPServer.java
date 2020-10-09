package src.cn.itcast.day10.demo01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server =new ServerSocket(8889);
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Socket socket = server.accept();//服务器必须知道是哪个用户端访问，所以调用accept方法
                        InputStream m = socket.getInputStream();//服务器本身没有io流，所以必须调用用户端的io流，调用getInputStream方法
                        File file = new File("d:\\upload");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        String filename = "www." + System.currentTimeMillis() + new Random().nextInt(1000) + ".txt";
                        FileOutputStream fos = new FileOutputStream(file + "\\" + filename);
                        int len = 0;
                        byte[] by = new byte[1024];
                        while ((len = m.read(by)) != -1) {
                            fos.write(by, 0, len);//将文件传入到硬盘中
                        }
                        socket.getOutputStream().write("上传成功".getBytes());//告诉客户端上传成功
                        fos.close();
                        socket.close();
                        server.close();
                    }catch (IOException e){
                        System.out.println(e );
                    }
                }
            }).start();
            /*Socket socket = server.accept();//服务器必须知道是哪个用户端访问，所以调用accept方法
            InputStream m = socket.getInputStream();//服务器本身没有io流，所以必须调用用户端的io流，调用getinputstream方法
            File file = new File("d:\\upload");
            if (!file.exists()) {
                file.mkdirs();
            }
            String filename = "www." + System.currentTimeMillis() + new Random().nextInt(1000) + ".txt";
            FileOutputStream fos = new FileOutputStream(file + "\\" + filename);
            int len = 0;
            byte[] by = new byte[1024];
            while ((len = m.read(by)) != -1) {
                fos.write(by, 0, len);//将文件传入到硬盘中
            }
            socket.getOutputStream().write("上传成功".getBytes());//告诉客户端上传成功
            fos.close();
            socket.close();
            server.close();*/
        }

    }
}
