package worktest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZhengJiawei
 * @create 2020-06-04 8:53 上午
 */
public class Test8 {
    /**
     * 编写一个程序，开启 3 个线程，这三个线程的 ID 分别为 A、B、C，
     * 每个线程将自己的 ID 在屏幕上打印 10 遍，
     * 要求输出的结果必须按顺序显示。如：ABCABCABC…… 依次递归。
     */
    public static int cnt = 0;
    public static final int COUNT = 30;
    static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadA a = new ThreadA("A");
        ThreadB b = new ThreadB("B");
        ThreadC c = new ThreadC("C");
        for (int i = 0; i < 30; i++) {

        }
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.print(ThreadA.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadB extends Thread {
        public ThreadB(String name) {
            super(name);
        }

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.print(ThreadA.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadC extends Thread {
        public ThreadC(String name) {
            super(name);
        }

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.print(ThreadA.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}


