package src.cn.itcast.day02.demo01;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <25; i++) {
            System.out.println("run"+i);
        }
    }
}
