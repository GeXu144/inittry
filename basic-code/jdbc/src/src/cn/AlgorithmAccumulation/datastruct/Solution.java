package src.cn.AlgorithmAccumulation.datastruct;

import java.util.HashMap;
import java.util.Map;

//两数之和算法
public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        //建立map集合
        Map<Integer, Integer> map = new HashMap<>();
        //遍历数组
        for(int i = 0; i< nums.length; i++) {
            //如果map中存在target - nums[i]，则将map中的值根据key取出，与当前循环值一起返回
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            //没有的话，将key与value存入map集合
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    public static void main(String[] args) {
        int[] num={5,3,2,9};
        int[] sum =twoSum(num, 12);
        for (int i = 0; i <sum.length ; i++) {
            System.out.println(sum[i]);
        }
    }
}
