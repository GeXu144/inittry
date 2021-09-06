package src.cn.itcast.day02.demo01;
/*
模拟时钟，运用sleep方法，线程暂时停止一秒钟
 */
public class Demo02Sleep {
    public static void main(String[] args) {
        RunnableImp1 r=new RunnableImp1();
        Thread t1=new Thread(r);
        Thread t2=new Thread(r);
        Thread t3=new Thread(r);

        //开启线程
        t1.start();
        t2.start();
        t3.start();
    }
}
