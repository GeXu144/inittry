package src.cn.itcast.day06.demo03;

import java.util.Random;
import java.util.Scanner;

public class Demo04RandomGame {
    public static void main(String[] args) {
        Random r = new Random();
        int randomNum=r.nextInt(101);
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("请输入猜测的数字:");
            int guessNum=sc.nextInt();
            if (guessNum>randomNum){
                System.out.println("太大了，请重试");
            }
            else if (guessNum<randomNum){
                System.out.println("太小了，请重试");
            }
            else{
                System.out.println("恭喜你，猜对了");
                break;
            }
        }
        System.out.println("game over!");


    }
}
