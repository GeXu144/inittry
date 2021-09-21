package src.cn.AlgorithmAccumulation.datastruct;

public class Hanoi {
    /**
     *  Algorithm idea: 1. n=1, then a-->c
     *                   2. n>1,then n-1->b,n-->c,then b-->c
     * @param n
     * @param a
     * @param b
     * @param c
     */
    public static void hanoi(Integer n,String a,String b,String c){
        if (n==1){
            System.out.println(a+"转到"+c);
        }else{
            hanoi(n-1,a,c,b);
            System.out.println(a+"转到"+c);
            hanoi(n-1,b,a,c);
        }

    }

    public static void main(String[] args) {
        hanoi(5,"塔1","塔2","塔3");
    }

}
