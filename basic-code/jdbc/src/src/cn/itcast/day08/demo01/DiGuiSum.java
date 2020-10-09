package src.cn.itcast.day08.demo01;

public class DiGuiSum {
    public static void main(String[] args) {
        int s =SUM (100);
        System.out.println(s);
    }
    public static int SUM(int n){
        if (n==1){
            return 1;
        }
        return n+SUM(n-1);
    }
}
