package worktest;

/**
 * 写两个线程，一个线程打印 1~ 52，另一个线程打印 A~Z，打印顺序是 12A34B…5152Z
 *
 * @author ZhengJiawei
 * @date 2020-04-19 11:09 下午
 */
public class Test3 {

    public static void main(String[] args) {
        Object obj = new Object();
        Thread1 thread1 = new Thread1(obj);
        Thread2 thread2 = new Thread2(obj);
        thread1.start();
        thread2.start();
    }

}

class Thread1 extends Thread {
    private final Object obj;

    public Thread1(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 1; i < 53; i++) {
                System.out.print(i++ + "" + i);
                if (i <= 52) {
                    obj.notifyAll();
                    try {
                        obj.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Thread2 extends Thread {
    private final Object obj;

    public Thread2(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 26; i++) {
                System.out.print((char) ('A' + i));
                obj.notifyAll();
                if (i <= 24) {
                    try {
                        obj.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

