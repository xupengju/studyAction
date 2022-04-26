package blockqueue;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Milo on 2022/4/7.
 * @description
 */
public class MyBlockQueueTest<T> {

    // 队列
    private volatile List<T> myLink = Lists.newArrayList();
    // 锁
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private AtomicInteger allow = new AtomicInteger(5);

    private AtomicInteger length = new AtomicInteger(0);

    public void push(T t){
        lock.lock();
        try {
            System.out.println("push index:{}"+ t);
            while (length.get() == allow.get()) {
                condition.await();
            }
            System.out.println("push :{}"+ t);
            myLink.add(t);
            length.incrementAndGet();
            condition.signalAll();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }

    }

    public T pop(){
        lock.lock();
        try {
            if (length.get() == 0){
                condition.await();
            }
            T t = myLink.get(0);
            System.out.println("pop :{}"+ t);
            myLink.remove(0);
            length.decrementAndGet();
            condition.signalAll();
            return t;
        }catch (Exception e){
            return null;
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
//
//        byte a = 1;
//        Byte as = 1;
//
//        Byte asd = 0.1;
//
//        byte sdf = 0.1;
//
//        char s = 1;
//
//        char sd = 1.1;
//
//        float saa = 1;
//
//        float ss = 1.333333;
//
//        double ffd = 1;
//        double ffdd = 11.1111111;

        MyBlockQueueTest<Integer> myBlockingQueue = new MyBlockQueueTest<>();
        for (int i = 0; i < 10; ++i) {
            final int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myBlockingQueue.push(j);
                }
            }).start();
        }


        try {
            System.out.println("sleep");
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Integer t = myBlockingQueue.pop();
                    System.out.println("pop " + t);
                }
            }
        }).start();
    }
}
