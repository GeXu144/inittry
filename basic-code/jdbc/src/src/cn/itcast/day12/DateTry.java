package src.cn.itcast.day12;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTry {
    public static void main(String[] args) throws Exception {
        System.out.println("请输入出生日期：");
        Scanner scanner =new Scanner(System.in);
        String birthday = scanner.next();
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sf.parse(birthday);
        long birthtime = parse.getTime();
        long t_time = new Date().getTime();

        long d=t_time-birthtime;

        System.out.println(d/1000/60/60/24);
        /*
        long t_time = new Date().getTime();
        System.out.println(t_time/(60*60*24));*/
    }
}
