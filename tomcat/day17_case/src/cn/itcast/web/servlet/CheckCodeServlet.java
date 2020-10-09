package cn.itcast.web.servlet;

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

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int height=30;
        int width=80;
        //1.创建图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        //2.美化图片
        //2.1填充背景色,需要用到画笔对象image.getGraphics()
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);//填充背景色
        g.fillRect(0,0,width,height);

        //2.2画边框
        g.setColor(Color.black);
        g.drawRect(0,0,width-1,height-1);
        //2.3写验证码
        String str="ABCDEFGHIJKLMNOPQUVWXYZ0123456789";
        Random ran = new Random();
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i <4 ; i++) {
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);//生成的字符
           sb.append(ch);
            g.drawString(ch+"",width/5*i,height/2);
        }
        String checkCode_session = sb.toString();
        request.getSession().setAttribute("checkCode_session",checkCode_session);
        g.setFont(new Font("黑体",Font.BOLD,24));
        //3.将图片输出到页面
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
