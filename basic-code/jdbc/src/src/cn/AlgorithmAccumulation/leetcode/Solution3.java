package src.cn.AlgorithmAccumulation.leetcode;

import java.util.Stack;


public class Solution3 {
    public static void main(String[] args) {

    }

    /**
     * 利用栈实现括号匹配
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<Character>();
        for (char c:s.toCharArray()) {
            if (c=='('||c=='['||c=='{'){
                stack.push(c);
            }
            else{
                if (stack.isEmpty()){
                    return false;
                }
                if (c==')'&&stack.pop()!='('){
                    return false;
                }
                if (c=='}'&&stack.pop()!='{'){
                    return false;
                }
                if (c==']'&&stack.pop()!='['){
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }


    /**
     * leetCode-2两数相加
     * 算法关键在于对于第三个链表的使用，以及进位carry的表示
     *  1.ListNode head = new ListNode(0);
     *    ListNode p = head;
     *  2.carry = sum / 10;//进位
     *    sum = sum % 10;//实际数值
     *  3.遍历两个已给链表，跳出循环之后，如果carry==1，则新建结点。
     *  总结：将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 0，比如 987 + 23 = 987 + 023 = 1010
     * 每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
     * 如果两个链表全部遍历完毕后，进位值为 1，则在新链表最前方添加节点 1
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 +n2 + carry;

            carry = sum / 10;//进位
            sum = sum % 10;//实际数值
            p.next = new ListNode(sum);

            p = p.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            p.next = new ListNode(carry);
        }
        return head.next;
    }

}
