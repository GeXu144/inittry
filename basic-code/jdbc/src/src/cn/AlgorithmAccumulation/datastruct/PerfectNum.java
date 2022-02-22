package src.cn.AlgorithmAccumulation.datastruct;

import java.util.Scanner;

/**
 * 在给定区间内寻找完数
 * 1.给定两个数
 * 2.排除自身故需要从a+1开始循环，以及从2开始
 * 3.找出因子需要取模==0
 * 4.如果找到了就打印输出
 */
public class PerfectNum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入第一个数：");
        int a = sc.nextInt();
        System.out.println("请输入第二个数：");
        int b = sc.nextInt();
        for (int i =a+1; i < b; i++) {
            int temp=1;
            for (int j = 2; j < i; j++) {
                if (i%j==0){
                    temp+=j;
                }
            }
            if (temp==i){
                System.out.println("完数就是："+i);
            }
        }
    }
}
