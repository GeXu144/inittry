package src.cn.AlgorithmAccumulation.leetcode;

public class Solution283 {
    public static void moveZeros(int[] nums){
        if (nums==null) return;
        int insertPos=0;
        for (int num : nums) {
            if (num!=0){
                nums[insertPos++]=num;
            }
        }
        //非0剩余位置置0
        for (int i = insertPos; i <nums.length ; i++) {
            nums[i]=0;
        }
    }
}
