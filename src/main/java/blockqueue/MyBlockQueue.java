package blockqueue;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 手写一个阻塞队列
 *
 * @author Milo on 2021/10/8.
 * @description
 */
public class MyBlockQueue<T> {

    private volatile List<T> myLink = Lists.newArrayList();

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private volatile AtomicInteger allow = new AtomicInteger(5);

    private volatile AtomicInteger length = new AtomicInteger(0);

    public void push(T t) {

        lock.lock();
        try {
            System.out.println("push index" + length.get());
            while (length.get() == allow.get()) {
                condition.await();
            }
            System.out.println("push " + t);
            myLink.add(t);
            length.incrementAndGet();
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T pop() {
        lock.lock();
        try {
            System.out.println("pop index" + length.get());
            while (length.get() == 0) {
                condition.await();
            }
            T t = myLink.get(0);
            myLink.remove(0);
            length.decrementAndGet();
            condition.signalAll();
            return t;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        MyBlockQueue<Integer> myBlockingQueue = new MyBlockQueue<>();
        for (int i = 0; i < 10; ++i) {
            final int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myBlockingQueue.push(j);
                }
            }).start();
        }

//
//        try {
//            System.out.println("sleep");
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    Integer t = myBlockingQueue.pop();
//                    System.out.println("pop " + t);
//                }
//            }
//        }).start();
//
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                    myBlockingQueue.push(2111);
//            }
//        }).start();
    }
}
