package src.cn.AlgorithmAccumulation.datastruct;

public class Solution1 {
    public static void main(String[] args) {
        int[] array={55,0,-1,-3,0,0,-5,99,-8};
        sort(array,9);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }


    }
    public static void sort(int[] array,int length){
        int low=0;
        int high=length-1;
       for (int i=low;i<high;) {
           if (array[i] > 0) {
               swap(array[i], array[high]);
               high--;
           }
           if (array[i] == 0) {
               i++;
           }
           if (array[i] < 0) {
               swap(array[i], array[low]);
               low++;
               i++;
           }
       }
    }
    public static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }
}
