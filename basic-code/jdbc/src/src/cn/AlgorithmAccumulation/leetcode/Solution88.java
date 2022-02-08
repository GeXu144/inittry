package src.cn.AlgorithmAccumulation.leetcode;

public class Solution88 {
    public static void main(String[] args) {
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int k=m+n;
        int[] temp=new int[k];
        for (int index=0, nums1Index=0, nums2Index=0;index<k;index++){
            if (nums1Index>=m){
                temp[index]=nums2[nums2Index++];
            }else if (nums2Index>=n){
                temp[index]=nums1[nums1Index++];
            }else if (nums1[nums1Index]<nums2[nums2Index]){
                temp[index]=nums1[nums1Index++];
            }else{
                temp[index]=nums2[nums2Index++];
            }
        }
        for (int i = 0; i < k; i++) {
            nums1[i]=temp[i];
        }
    }
}
