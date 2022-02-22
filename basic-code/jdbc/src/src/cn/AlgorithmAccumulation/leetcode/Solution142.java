package src.cn.AlgorithmAccumulation.leetcode;

public class Solution142 {
    /**
     * 返回环中第一个结点：首先找到环，然后将slow还原到head，之后slow一步，head一步，当两者相等时就找到了第一个结点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head){
        if (head==null){
            return null;
        }
        ListNode fast=head;ListNode slow=head;
        boolean isRing=false;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                isRing=true;
                break;
            }
        }
        if (isRing){
            slow=head;
            while (slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
        return null;
    }
}
