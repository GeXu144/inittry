package src.cn.AlgorithmAccumulation.leetcode;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode current=head;
        while(null!=current.next){
            if(current.val==current.next.val){
                current.next=current.next.next;
            }else{
                current=current.next;
            }
        }
        return head;
    }
}
