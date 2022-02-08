package src.cn.AlgorithmAccumulation.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution448 {
    /**
     *[4,3,2,7,8,2,3,1],
     * 1.寻找消失的数，4已经出现，其下标为3，将数组中对应的位置的数改为负数以表示其已经出现，以此类推
     * 遍历数组，遇到大于0的数，则表示找到了消失的数
     * 2.也可以将对应的值加上n,然后遍历，如果没有大于大于n,则表示该下标加一为消失的值
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums){
            int index=(num-1)%n;
            nums[index]+=n;
        }
        List<Integer> result=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i]<=n){
                result.add(i+1);
            }
        }
        return result;
    }

}