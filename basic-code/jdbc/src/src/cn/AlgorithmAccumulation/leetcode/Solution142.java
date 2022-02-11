package src.cn.AlgorithmAccumulation.leetcode;

public class Solution142 {
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
