package worktest;

import java.io.FileReader;
import java.util.Date;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**
 * 测试
 *
 * @author ZhengJiawei
 * @create 2020-04-20 1:59 下午
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(tableSizeFor(2));
        System.out.println(getCapacityFactor(2));
        Date d = new Date();
        System.out.println(!d.after(d));
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
