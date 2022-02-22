package src.cn.AlgorithmAccumulation.leetcode;

public class Solution83 {
    /**
     * 删除重复的结点：遍历链表，如果当前结点的值==其后续结点的值，则将当前指针的next指向后续结点的next
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode current=head;//辅助指针
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
