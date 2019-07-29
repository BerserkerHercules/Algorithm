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


    public static void main(String[] args){
        LeetCodeSimple leetCode = new LeetCodeSimple();
        long startTime=System.currentTimeMillis();
        System.out.println(leetCode.reverse(1534236469));
        long endTime=System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println(endTime);
    }

}
