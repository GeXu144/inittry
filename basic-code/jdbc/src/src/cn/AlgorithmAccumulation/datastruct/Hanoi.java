package src.cn.AlgorithmAccumulation.datastruct;

public class Hanoi {
    /**
     * Algorithm idea: 1. n=1, then a-->c
     * 2. n>1,then 将第n-1由a经由c移动到b,第n个由a移动到c,then b-->c
     *
     * @param n
     * @param a
     * @param b
     * @param c
     */
    public static void hanoi(Integer n, String a, String b, String c) {
        if (n == 1) {
            System.out.println(a + "转到" + c);
        } else {
            hanoi(n - 1, a, c, b);
            System.out.println(a + "转到" + c);
            hanoi(n - 1, b, a, c);//b经由a移动到c,以上类似
        }

    }

    public static void main(String[] args) {
        hanoi(3, "a", "b", "c");
    }
}