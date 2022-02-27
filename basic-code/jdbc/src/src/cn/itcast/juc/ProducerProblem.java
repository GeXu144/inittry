package src.cn.itcast.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//生产者消费者问题，判断等待--业务--通知
public class ProducerProblem {
    public static void main(String[] args) {
        Data data=new Data();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        },"C").start();
    }
}
class Data{
    private Lock lock=new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();//对象监视器，条件队列
    private int number=1;//1A 2B 3C
    public void printA(){
        lock.lock();
        try {
            //判断
            while (number!=1){
                //等待
                condition1.await();
            }
            //业务
            System.out.println(Thread.currentThread().getName()+"=>AAAAA");
            number=2;
            //通知B
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try {
            //判断
            while (number!=2){
                //等待
                condition2.await();
            }
            //业务
            System.out.println(Thread.currentThread().getName()+"=>BBBB");
            //通知C
            number=3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try {
            //判断
            while (number!=3){
                //等待
                condition3.await();
            }
            //业务
            System.out.println(Thread.currentThread().getName()+"=>CCCC");
            //通知A
            number=1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
