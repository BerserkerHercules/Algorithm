import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 简单题
 *
 * @author ZhengJiawei
 * @create 2019-07-29 14:19
 */
public class LeetCodeSimple {

    /**
     * 	1、两数之和
     *
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * https://leetcode-cn.com/problems/two-sum
     *
     * 我的结果：
     * 执行用时：38 ms
     * 已经战胜 52.93 % 的 java 提交记录.
     *
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j]==target-nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    /**
     * 	7、整数反转
     *
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *
     *  示例 2:
     * 输入: -123
     * 输出: -321
     *
     * 示例 3:
     * 输入: 120
     * 输出: 21
     *
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     *
     * 我的结果：
     * 执行用时：3 ms
     * 已经战胜 97.74 % 的 java 提交记录.
     *
     */
    public int reverse(int x) {
        long res=0;
        do{
            res = res*10+x%10;
            if((int)res!=res){
                return 0;
            }
            x/=10;
        }while (x!=0);
        return (int)res;
    }

    /**
     * 9、回文数
     *
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 示例 1:
     *
     * 输入: 121
     * 输出: true
     * 示例 2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     *
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * 进阶:
     *
     * 你能不将整数转为字符串来解决这个问题吗？
     *
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     *
     * 我的结果：
     * 执行用时: 12 ms
     * 在所有 Java 提交中击败了 98.63% 的用户
     */
    public boolean isPalindrome(int x) {
        int y=x;
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }
        int res=0;
        do{
            res = res*10+x%10;
            x/=10;
        }while(x!=0);
        return res==y;
    }

    /**
     * 用字符串
     * 执行时间远大于不用字符串的方法(50ms以上)
     */
    public boolean isPalindrome2(int x) {
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }
        String str = x+"";
        return str.equals(new StringBuffer(str).reverse().toString());
    }


    public static void main(String[] args){
        LeetCodeSimple leetCodeSimple = new LeetCodeSimple();
        long startTime=System.currentTimeMillis();
        System.out.println(leetCodeSimple.isPalindrome(1234321));
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.exit(0);
    }

}
