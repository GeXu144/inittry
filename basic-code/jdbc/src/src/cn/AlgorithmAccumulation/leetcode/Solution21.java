package src.cn.AlgorithmAccumulation.leetcode;

public class Solution21 {
    /**
     * 循环加双指针
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoList(ListNode l1,ListNode l2){
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode resultList=new ListNode(0);
        ListNode p=resultList;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                p.next=l1;
                l1=l1.next;
            }else {
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        if (l1!=null){
            p.next=l1;
        }
        if (l2!=null){
            p.next=l2;
        }
        return resultList.next;
    }
}
