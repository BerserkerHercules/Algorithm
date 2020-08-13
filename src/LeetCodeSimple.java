import java.util.*;
import java.util.Stack;

/**
 * LeetCode 简单题
 *
 * @author ZhengJiawei
 * @create 2019-07-29 14:19
 */
public class LeetCodeSimple {

    /**
     * 1、两数之和
     * <p>
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <p>
     * https://leetcode-cn.com/problems/two-sum
     * <p>
     * 我的结果(2019-07-29)：
     * 执行用时：38 ms
     * 已经战胜 52.93 % 的 java 提交记录.
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 7、整数反转
     * <p>
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * 输入: 123
     * 输出: 321
     * <p>
     *  示例 2:
     * 输入: -123
     * 输出: -321
     * <p>
     * 示例 3:
     * 输入: 120
     * 输出: 21
     * <p>
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     * <p>
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * <p>
     * 我的结果(2019-07-29)：
     * 执行用时：3 ms
     * 已经战胜 97.74 % 的 java 提交记录.
     */
    public int reverse(int x) {
        long res = 0;
        do {
            res = res * 10 + x % 10;
            if ((int) res != res) {
                return 0;
            }
            x /= 10;
        } while (x != 0);
        return (int) res;
    }

    /**
     * 9、回文数
     * <p>
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 121
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * <p>
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * 进阶:
     * <p>
     * 你能不将整数转为字符串来解决这个问题吗？
     * <p>
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * <p>
     * 我的结果(2019-07-29)：
     * 执行用时: 12 ms
     * 在所有 Java 提交中击败了 98.63% 的用户
     */
    public boolean isPalindrome(int x) {
        int y = x;
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int res = 0;
        do {
            res = res * 10 + x % 10;
            x /= 10;
        } while (x != 0);
        return res == y;
    }

    /**
     * 用字符串
     * 执行时间远大于不用字符串的方法(50ms以上)
     */
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        String str = x + "";
        return str.equals(new StringBuffer(str).reverse().toString());
    }

    /**
     * 13、罗马数字转整数
     * <p>
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例；
     * 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
     * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * <p>
     * 示例 1:
     * 输入: "III"
     * 输出: 3
     * <p>
     * 示例 2:
     * 输入: "IV"
     * 输出: 4
     * <p>
     * 示例 3:
     * 输入: "IX"
     * 输出: 9
     * <p>
     * 示例 4:
     * 输入: "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     * <p>
     * 示例 5:
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * <p>
     * 链接：https://leetcode-cn.com/problems/roman-to-integer
     * <p>
     * 我的结果(2019-07-29)：
     * 执行用时：27 ms
     * 已经战胜 56.62 % 的 java 提交记录
     */
    public int romanToInt(String s) {
        String[] strArr = s.split("");
        int result = 0;
        Map<String, Integer> maps = new HashMap<>();
        maps.put("I", 1);
        maps.put("V", 5);
        maps.put("X", 10);
        maps.put("L", 50);
        maps.put("C", 100);
        maps.put("D", 500);
        maps.put("M", 1000);
        for (int i = 0; i < strArr.length; i++) {
            int a = maps.get(strArr[i]);
            int b = i < strArr.length - 1 ? maps.get(strArr[i + 1]) : 0;
            result += a >= b ? a : -a;
        }
        return result;
    }

    /**
     * 14、编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * <p>
     * 所有输入只包含小写字母 a-z 。
     * <p>
     * <p>
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        if (strs.length <= 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; ) {
                if (i >= strs[j].length()) {
                    return res.toString();
                }
                if (strs[0].charAt(i) == strs[j].charAt(i)) {
                    j++;
                } else {
                    return res.toString();
                }
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }

    /**
     * 20、给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     * <p>
     * 输入: "{[]}"
     * 输出: true
     * <p>
     * <p>
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * <p>
     * 我的想法：
     * 考虑使用堆栈
     * 先进(遇到左括号，则放入其对应的右括号)
     * 后出(碰到右括号，则往外取出，并对比取出顺序)
     */
    public boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        String[] str = s.split("");
        Map<String, String> maps = new HashMap<>(3);
        maps.put("{", "}");
        maps.put("(", ")");
        maps.put("[", "]");
        Stack<String> stack = new Stack<>();
        int i = 0;
        for (; i < str.length; i++) {
            if (maps.get(str[i]) == null) {
                if (i == 0 || !stack.pop().equals(str[i])) {
                    return false;
                }
            } else {
                if (i == str.length - 1) {
                    return false;
                }
                stack.push(maps.get(str[i]));
            }
        }
        return i != 0;
    }



    /**
     * 26、给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例 1:
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 2:
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 说明:
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * 你可以想象内部操作如下:
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     * <p>
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * <p>
     * 执行用时 : 2 ms, 在所有 Java 提交中击败了 92.94% 的用户
     */
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 1:
     * <p>
     * 给定 nums = [3,2,2,3], val = 3,
     * <p>
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * <p>
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * <p>
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * <p>
     * 注意这五个元素可为任意顺序。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 说明:
     * <p>
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * <p>
     * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * <p>
     * 你可以想象内部操作如下:
     * <p>
     * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
     * int len = removeElement(nums, val);
     * <p>
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     * <p>
     * 链接：https://leetcode-cn.com/problems/remove-element
     */
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {

        }
        return 1;
    }

    /**
     * 28、实现 strStr() 函数。
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
     * 如果不存在，则返回  -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * <p>
     * "mississippi"
     * "issipi"
     * <p>
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char first = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            if (first == haystack.charAt(i)) {
                if (i + needle.length() <= haystack.length() && needle.equals(haystack.substring(i, i + needle.length()))) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * 35、给定一个排序数组和一个目标值，
     * 在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     */
    public int searchInsert(int[] nums, int target) {
        if(nums[nums.length-1]<target){
            return nums.length;
        }
        if(nums[0]>=target){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
            if (nums[i] == target) {
                return i;
            }
        }
        return nums.length - 1;
    }

}
