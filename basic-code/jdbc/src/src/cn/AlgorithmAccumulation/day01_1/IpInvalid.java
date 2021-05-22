package src.cn.AlgorithmAccumulation.day01_1;

import java.util.Scanner;

public class IpInvalid {
    public static String returnInvalidIp(String str){
        String res="";
        char[] array = str.toCharArray();
        for (int i = 0; i <array.length ; i++) {
           if (array[i]=='.'){
              res+="[.]";


           }
           else {
               res += array[i];
           }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入IP地址：");
        String ip = sc.next();
        String res = returnInvalidIp(ip);
        System.out.println(res);
    }
}
