package src.cn.itcast.day06.demo03;

public class DalloilNum {
    public static void main(String[] args) {

        for (int num = 100; num <=999 ; num++) {
            int g=num%10;
            int s=(num/10)%10;
            int b=num/100;
            if (b*b*b+s*s*s+g*g*g==num){
                System.out.println(num+"是水仙花数");
            }

        }
    }
}
