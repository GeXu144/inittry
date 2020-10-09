package src.cn.itcast.day02.demo01;
/*
模拟时钟，运用sleep方法，线程暂时停止一秒钟
 */
public class Demo02Sleep {
    public static void main(String[] args) {
        for (int i =1; i <=60 ; i++) {
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
