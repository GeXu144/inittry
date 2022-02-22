package src.cn.AlgorithmAccumulation.datastruct;

import java.util.Scanner;
/**
    Ip无效化，将'.'换成'[.]'
*/
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
