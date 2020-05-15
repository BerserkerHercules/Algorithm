package worktest;

/**
 * 龟兔赛跑
 * 要求：
 * (1)兔子每 0.1 秒 5 米的速度，每跑20米休息1秒;
 * (2)乌龟每 0.1 秒跑 2 米，不休息；
 * (3)其中一个跑到终点后另一个不跑了！
 *
 * @author ZhengJiawei
 * @date 2020-05-13 7:16 下午
 */
public class test7 {


    public static void main(String[] args) {
        Animal a1, a2;
        a1 = new Animal("🐰", 5, 1000, 100, 20);
        a2 = new Animal("🐢", 2, 0, 100, 0);
        a2.start();
        a1.start();

    }

}

class Animal extends Thread {
    static boolean stop = false;
    int speed;
    int sleepTime;
    String name;
    int spendTime;
    int sleepDistance;

    public Animal(String name, int speed, int sleepTime, int spendTime, int sleepDistance) {
        this.name = name;
        this.speed = speed;
        this.sleepTime = sleepTime;
        this.spendTime = spendTime;
        this.sleepDistance = sleepDistance;
    }

    @Override
    public void run() {
        int distance = 0;
        int sumTime = 0;
        while (distance <= 200) {
            if(stop){
                break;
            }
            try {
                distance += speed;
                System.out.println("------- " + name + " 跑了 " + distance + " 米");
                sleep(spendTime);
                if (sleepDistance != 0 && distance % sleepDistance == 0) {
                    sleep(sleepTime);
                }
                sumTime += (sleepTime + spendTime);
                //System.out.println("用时："+sumTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stop = true;
        System.out.println(name + "总用时：" + sumTime/1000.0);
    }

}

