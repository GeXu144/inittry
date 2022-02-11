package src.cn.AlgorithmAccumulation.leetcode;

public class Solution141 {
    /**
     * 判断链表中是否有环：定义两个指针，fast走两步，slow走一步，当两者相等之时便可判断存在环路
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head){
        if(head==null){
            return false;
        }
        ListNode fast=head;ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                return true;
            }
        }
        return false;
    }
}
