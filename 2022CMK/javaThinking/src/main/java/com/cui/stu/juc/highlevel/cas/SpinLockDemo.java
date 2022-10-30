package com.cui.stu.juc.highlevel.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/*通过CAS操作完成自旋锁，A线程先进来调用myLock方法自己持有锁5秒，
B随后进来后发现当前有线程持有锁，所以只能通过自选等待，直到A释放锁后B随后抢到
 */
public class SpinLockDemo {
    AtomicReference<Thread>  atomicReference = new AtomicReference<>();
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unLock();
        },"A").start();
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            spinLockDemo.lock();

            spinLockDemo.unLock();
        },"B").start();
    }

    public void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"--------come in");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void unLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName()+"--------come out");
    }
}
