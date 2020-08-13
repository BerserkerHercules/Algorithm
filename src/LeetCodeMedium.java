/**
 * leetCode中等题
 *
 * @author ZhengJiawei
 * @create 2020-07-09 3:34 下午
 */
public class LeetCodeMedium {

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 7 -> 0 -> 8
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode res = start;
        int carry = 0;
        int i = 0;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            res.next = new ListNode(sum % 10);
            res = res.next;
            if (l1 != null) { l1 = l1.next; }
            if (l2 != null) { l2 = l2.next; }
            i++;
        }
        if (carry != 0) {
            res.next = new ListNode(carry);
        }
        return start.next;
    }

}
