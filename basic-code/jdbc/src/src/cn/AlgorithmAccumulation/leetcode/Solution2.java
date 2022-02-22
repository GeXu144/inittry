package src.cn.AlgorithmAccumulation.leetcode;

public class Solution2 {
    public static void changeArray(int[] array){
        int low=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]!=0){
                array[low]=array[i];
                low+=1;
            }
        }
        for (int i = low; i < array.length; i++) {
            array[i]=0;
        }
    }
}
