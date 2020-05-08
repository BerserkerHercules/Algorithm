package worktest;

import java.util.*;

/**
 * 给定一个字符串，找出其中不含有重复字符的 最长子串 及长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: abc=3
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: b=1
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: wke=3
 *
 * @author ZhengJiawei
 * @create 2020-05-08 9:40 上午
 */
public class Test6 {

    public static void main(String[] args) {
        test1("pwwkew");
    }

    public static void test1(String s) {
        int start = 0;
        int res = 0;
        int resStart = 0;
        for (; start < s.length(); start++) {
            List<Character> list = new ArrayList<>();
            int end = start + 1;
            list.add(s.charAt(start));
            while (end < s.length()) {
                char endC = s.charAt(end);
                if (!list.contains(endC)) {
                    list.add(endC);
                    end++;
                } else {
                    if (res < (end - start)) {
                        res = end - start;
                        resStart = start;
                    }
                    break;
                }
            }
        }
        for(int i=0;i<res;i++){
            System.out.print(s.charAt(resStart+i));
        }
        System.out.println("\n长度：" + res);
    }


}
