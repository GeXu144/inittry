package src.cn.AlgorithmAccumulation.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution70 {
    /**
     * 该算法本质上还是斐波那契数列，这里使用hash主要是为了避免递归过程中的重复计算
     */
    private static Map<Integer,Integer> map=new HashMap<>();
    public static int climbStairs(int n){
        if (n==1)return 1;
        if (n==2)return 2;
        if (null !=map.get(n)){
            return map.get(n);
        }else{
            int result=climbStairs(n-1)+climbStairs(n-2);
            map.put(n,result);
            return result;
        }
    }
    public static int climbStairs2(int n){
        if (n==1)return 1;
        if (n==2)return 2;
        int result =0;
        int pre=2;
        int prePre=1;
        for (int i = 3; i <=n ; i++) {
            result=pre+prePre;
            prePre=pre;
            pre=result;
        }
        return result;
    }
    public static void main(String[] args) {
        int n=4;//楼梯数
        int stairs1= climbStairs(n);
        int stairs2 = climbStairs2(n);
        System.out.println(stairs1);

    }
}
