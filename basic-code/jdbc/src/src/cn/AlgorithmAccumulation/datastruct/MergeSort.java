package src.cn.AlgorithmAccumulation.datastruct;

public class MergeSort {
    public static void main(String[] args) {
        int[] array={1,5,6,8,3,3,1,2,0};
        mergeSort(array,0,array.length-1);
        for (int i : array) {
            System.out.println(i);
        }
    }
    public static void mergeSort(int[] array,int l,int r){
        if(l<r){
            int mid=l+(r-l)/2;
            mergeSort(array,l,mid);
            mergeSort(array,mid+1,r);
            merge(array,l,mid,r);
        }
    }
    public static void merge(int[] array,int l,int mid,int r){
        int[] temp=new int[r-l+1];
        int p1=l;
        int p2=mid+1;
        //辅助数组的下标
        int i=0;
        while (p1<=mid&&p2<=r){
            temp[i++]=array[p1]<=array[p2]?array[p1++]:array[p2++];
        }
        while (p1<=mid){
            temp[i++]=array[p1++];
        }
        while (p2<=r){
            temp[i++]=array[p2++];
        }
        for (i=0;i<temp.length;i++){
            array[l+i]=temp[i];
        }
    }
}
