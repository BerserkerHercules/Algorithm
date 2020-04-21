package worktest;

import java.io.FileReader;

/**
 * 测试
 *
 * @author ZhengJiawei
 * @create 2020-04-20 1:59 下午
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(print());
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

}
