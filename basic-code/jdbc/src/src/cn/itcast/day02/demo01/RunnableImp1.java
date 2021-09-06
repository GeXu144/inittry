package src.cn.itcast.day02.demo01;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableImp1 implements Runnable {
    //定义100张票，以演示线程安全的解决方法
    private int tickets=100;
    ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
           //同步代码块解决方法
            /*synchronized (this){
                if (tickets>0){
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName()+"卖第"+tickets+"张票");
                        tickets--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
           }*/

            //Lock锁的解决方法
            lock.lock();
            if (tickets>0){
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+"卖第"+tickets+"张票");
                    tickets--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //无论是否异常，都将lock锁释放掉
                    lock.unlock();
                }
            }
        }
    }
}
