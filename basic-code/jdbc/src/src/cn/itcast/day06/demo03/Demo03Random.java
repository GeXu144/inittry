package src.cn.itcast.day06.demo03;

import java.util.Random;//随机数的运用

public class Demo03Random {
    public static void main(String[] args) {
        Random r = new Random();
        int n=5;
        for (int i = 0; i < 10; i++) {
            int num=r.nextInt(n)+1;
            System.out.println(num);

        }
    }
}
