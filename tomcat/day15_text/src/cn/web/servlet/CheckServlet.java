package cn.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet( "/checkServlet")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int height=50;
        int width=100;
        //1.创建图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        //2.美化图片
        //2.1填充背景色,需要用到画笔对象image.getGraphics()
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);//填充背景色
        g.fillRect(0,0,width,height);

        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);

        //2.3写验证码
        String str="ABCDEFGHIJKLMNOPQUVWXYZabcdefghijklmnopquvwxyz0123456789";
        Random ran = new Random();
        for (int i = 0; i <4 ; i++) {
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);
            g.drawString(ch+"",width/5*i,height/2);
        }
        //2.4划线
        g.setColor(Color.GREEN);
        for (int i = 0; i <5 ; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        //3.将图片输出到页面
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }
}
