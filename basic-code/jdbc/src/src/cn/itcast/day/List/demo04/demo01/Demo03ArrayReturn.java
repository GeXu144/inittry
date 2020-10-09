package src.cn.itcast.day.List.demo04.demo01;

public class Demo03ArrayReturn {
    public static void main(String[] args) {
    int[] result=calculate(5,6,7);
        System.out.println("总和是:"+result[0]);
        System.out.println("平均数是:"+result[1]);
    }
    public static int[] calculate(int a,int b,int c){
      int sum = a+b+c;
      int avg = sum/3;
      int[] array = {sum,avg};
      return array;
    }
}
