package src.cn.itcast.day06.demo03;


import java.util.Scanner;//导包。除了lang包不需要之外其他均需要导包。

public class Demo02ScannerSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字:");
        int a = sc.nextInt();
        System.out.println("请输入第二个数字:");
        int b = sc.nextInt();
        System.out.println("请输入第三个数字:");
        int c = sc.nextInt();
        int result = a+b+c;
        System.out.println("三个数相加的结果是："+result);
        int temp = a>b?a:b;
        int max = temp>c?temp:c;
        System.out.println("最大值是:" +max);
    }

}
