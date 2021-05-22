package src.cn.AlgorithmAccumulation.day01_1;

import java.util.Scanner;

//整数反转算法，使用取模，并且判断int的值是否溢出 范围 -2147483648到2147483647
public class IntegerReversal {

    public static int integerReversal(int x){
        int res=0;
        while (x!=0){
            int tem=x%10;
            if (res>214748364||(res==214748364&&tem>7)){//先找出最后一位，判断是否超过214748364，没有则判断最后一位是否超过7
                return 0;
            }
            if (res<-214748364||(res==-214748364&&tem<-8)){
                return 0;

            }
            res=res*10+tem;//反转
            x/=10;//x取模但是x本身是没有变化的，所以需要将x自除10，以达到取下一个模数的目的
        }
        return res;
    }

    public static void main(String[] args) {

        int i = integerReversal(9856221);
        System.out.println(i);
    }
}
