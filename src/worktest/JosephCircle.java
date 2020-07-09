package worktest;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫环
 * 15个基督教徒和15个非教徒在海上遇险，必须将其中一半的人投入海中，其余的人才能幸免于难.
 * 于是30个人围成一圈，从某一个人开始从1报数，报到9的人就扔进大海，
 * 他后面的人继续从1开始报数，重复上面的规则，直到剩下15个人为止。
 * 结果由于上帝的保佑，15个基督教徒最后都幸免于难，
 * 问原来这些人是怎么排列的，哪些位置是基督教徒，哪些位置是非教徒。
 * 请用代码实现。
 *
 * @author ZhengJiawei
 * @create 2020-07-08 4:23 下午
 */

public class JosephCircle {

    public static void main(String[] args) {
        f(30, 9, 15);
    }

    public static void f(int n, int m, int size) {
        List<Integer> list = new ArrayList<>(n);
        List<Integer> listCopy = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
            listCopy.add(i);
        }
        for (int i = 1, index = 0; i <= n; i++) {
            if (i % m == 0) {
                if (list.size() <= size) {
                    break;
                }
                list.remove(index);
                n--;
                i = 1;
            }
            if (index > n - 1) {
                index = 0;
            }
            index++;
        }
        listCopy.forEach(e -> {
            if (list.contains(e)) {
                System.out.print(" 基" + e);
            } else {
                System.out.print(" 非" + e);
            }
        });
    }

}
