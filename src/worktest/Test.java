package worktest;

import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Date;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**
 * 测试
 *
 * @author ZhengJiawei
 * @create 2020-04-20 1:59 下午
 */
public class Test {
    static DecimalFormat df = new DecimalFormat("######0.00");

    public static void main(String[] args) {
        double roadEntCount = 10572;
        double lastRoadEntCount = 10971;
        double allEntCount = 72980;
        double lastEntCount = 78276;

        System.out.println(tableSizeFor(5));
        System.out.println(getCapacityFactor(5));
        //System.out.println(df.format(((roadEntCount - lastRoadEntCount) / lastRoadEntCount) * 100));
        //System.out.println(df.format((((allEntCount - roadEntCount) - (lastEntCount - lastRoadEntCount)) / (lastEntCount - lastRoadEntCount)) * 100));
    }

    private static String print(){
        try{
            FileReader fr = new FileReader("c:/abc.txt");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误");
            //return "01";
        }
        return "02";
    }

    /**
     * 计算Map初始值
     */
    private static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    /**
     * 计算Map初始值
     */
    private static final double MODULE = 2;
    public static int getCapacityFactor(int size) {
        int n = size;
        int power = 0;
        while (n > 1) {
            power++;
            n >>>= 1;
        }
        int capacity = (int) Math.pow(MODULE, power);
        if (capacity < size || capacity % MODULE != 0) {
            capacity *= MODULE;
        }
        return capacity;
    }

}
