package worktest;

import java.util.*;

/**
 * 给定字符串，要求按照字符串中每个汉字出现的次数，从少到多有序输出汉字及其出现的次数。
 *
 * @author ZhengJiawei
 * @date 2020-04-20 10:08 上午
 */
public class Test5 {

    public static String str = "适用主题：关于坚持，潜心积累，为目标奋斗，磨炼等作文立意。示例：人们往往羡慕他人所取得的成功，殊不知，成功的背后是无数个日夜的艰辛奋斗。实现理想，从来没有捷径可言。泰戈尔曾说：“只有流过血的手指，才能弹出世间的绝唱。”郎朗经历无数个不为人知、默默练习的日日夜夜，有朝一日人们为他华美绚丽的钢琴弹奏所倾倒；羽生结弦一次次受伤又爬起，坚持苦练，终于为世界呈现出无懈可击的冰上英姿；屠呦呦做了数百次试验，才有了惊人的发现，在40年后终登上诺奖之巅。就像唯有经历磨练的人生，才能过得充实；唯有经历磨练的青春，才会更加光彩照人。";

    public static void main(String[] args) {
        printNum(str);
    }

    public static void printNum(String str){
        Map<Character,Integer> map = new TreeMap<>();
        char[] charArr = str.toCharArray();
        for (char c : charArr) {
            if(!isChineseChar(c)){
                continue;
            }
            if(map.containsKey(c)){
                Integer num = map.get(c);
                map.put(c,++num);
            }else{
                map.put(c,1);
            }
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<Character, Integer> entry : list) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static boolean isChineseChar(char c) {
        return String.valueOf(c).matches("[\u4e00-\u9fa5]");
    }
}
