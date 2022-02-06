package src.cn.AlgorithmAccumulation.datastruct;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static Map<Integer,Integer> map=new HashMap<>();
    public static int fibonacci1(int n){
        if(n==0)return 0;
        if (n==1)return 1;
        if (map.get(n)!=null){
            return map.get(n);
        }else{
            int result=fibonacci1(n-2)+fibonacci1(n-1);
            map.put(n,result);
            return result;
        }
    }

    public static int fibonacci2(int n){
        if(n==0)return 0;
        if (n==1)return 1;
        int result =0;
        int pre=1;
        int prePre=0;
        for (int i = 2; i <=n ; i++) {
            result=pre+prePre;
            prePre=pre;
            pre=result;
        }
        return result;
    }

    public static void main(String[] args) {
        int n=3;
        int value1 = fibonacci1(n);
        int value2=fibonacci2(n);
        System.out.println(value2);
    }
}
