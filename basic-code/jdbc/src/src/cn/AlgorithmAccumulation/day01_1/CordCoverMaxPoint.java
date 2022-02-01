package src.cn.AlgorithmAccumulation.day01_1;



public class CordCoverMaxPoint {
    public static void main(String[] args) {
        int[] array={1,3,4,7,9,15,17};
        int l=6;
        int point = maxPoint2(array, l);
        //int point = maxPoint(array, l);
        System.out.println(point);
    }

    /**
     *  该算法主要处理绳子覆盖最多的点数，L指绳子的长度
     *  array为有序数组
     *  思想：贪心加二分，绳子末尾覆盖开始遍历，在当前结点i之前找到比array[i]-L更大的值的个数
     * @param array
     * @param L
     * @return
     */
    public static int maxPoint(int[] array,int L){
        int res=1;
        for (int i = 0; i < array.length; i++) {
            int index=nearIndex(array,i,array[i]-L);
            res=Math.max(res,i-index+1);
        }
        return res;
    }
    public static int nearIndex(int[] array,int high ,int value){
        int low=0;
        int index=high;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (array[mid]>=value){
                index=mid;
                high=mid-1;

            }else {
                low=mid+1;
            }

        }
        return index;
    }
    public static int maxPoint2(int[] array,int L){
        int left=0;
        int right=0;
        int len=array.length;
        int max_point=0;
        while (left<len){
            while (right<len&&array[right]-array[left]<=L){
                right++;
            }
            max_point=Math.max(max_point,right-(left++));
        }
        return max_point;
    }

}
