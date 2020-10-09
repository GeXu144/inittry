package src.cn.itcast.day02.demo01;
/*
 多线程的操作方式，子类继承Thread,重写Thread的run方法，调用start方法。
 */
public class Demo01Tread {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();


        for (int i = 0; i <25; i++) {
            System.out.println("main"+i);
        }

    }
}
