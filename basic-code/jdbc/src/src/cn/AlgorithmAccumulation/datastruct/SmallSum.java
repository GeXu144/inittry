package src.cn.AlgorithmAccumulation.datastruct;

public class SmallSum {
    public static int smallSum(int[] array){
        if (array==null||array.length<2){
            return 0;
        }
        return process(array,0,array.length-1);
    }
    public static int process(int[] array,int low,int high){
        if (low==high){
            return 0;
        }
        int mid=low+((high-low)>>1);
        return process(array,low,mid)+process(array,mid+1,high)+merge(array,low,mid,high);
    }
    public static int merge(int[] array,int l,int mid,int r){
        int[] help=new int[r-l+1];
        int i=0;//处理help数组
        int p1=l;
        int p2=mid+1;
        int res=0;
        while (p1<=mid&&p2<=r){
            res+=array[p1]<array[p2]?(r-p2+1)*array[p1]:0;
            help[i++]=array[p1]<array[p2]?array[p1++]:array[p2++];
        }
        while (p1<=mid){
            help[i++]=array[p1++];
        }
        while (p2<=r){
            help[i++]=array[p2++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array={1,3,4,2,5};
        int sum = smallSum(array);
        System.out.println(sum);
    }
}
