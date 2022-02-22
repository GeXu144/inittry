package src.cn.AlgorithmAccumulation.datastruct;

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入第1个值：");
        int a = sc.nextInt();
        System.out.println("请输入第2个值：");
        int b = sc.nextInt();
        changeValue(a,b);

    }

    public static void changeValue(int a,int b){
        //将a,b进行与或运算，
        a=a^b;

        b=a^b;

        a=a^b;

        System.out.println("a的值为："+a);
        System.out.println("b的值为："+b);
    }
}
