package src.cn.AlgorithmAccumulation.datastruct;

public class QuickSort {


    public static void main(String[] args) {
        int[] array={1,3,2,4,4,5,7,9};
        quickSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(i);
        }
    }
    public static void quickSort(int[] array){
        if (array==null||array.length-1<2){
            return;
        }
        process(array,0,array.length-1);
    }
    public static void process(int[] array,int l, int r){
        if(l<r){
            swap(array, (int) (l+(Math.random()*(r-l+1))),r);//随机选中一个数返到末尾作为荷兰国旗的num
            int[] border = partition(array, l, r);
            //递归找到中间区域即可
            process(array,l,border[0]-1);
            process(array,border[1]+1,r);
        }
    }

    /**
     * 返回一个含有两个数的数组，一个是等于区域的左边界另外一个是大于区域的右边界
     * i代表当前数
     * @param array
     * @param i
     * @param r
     * @return
     */
    public static int[] partition(int[] array,int i,int r){
        int less=i-1;//<的右边界,减一主要是因为第一个数需要用
        int more=r;//>的左边界，直接r,因为最后一个数已经作为num了
        while (i<more){
            if (array[i]<array[r]){
                //当前数如果小于num,将当前数和小于区域的后一个数交换
                less=less+1;
                swap(array,less,i);
                i++;
               // swap(array,++less,i++);
            }else if (array[i]>array[r]){
                //i>num,当前值和大于区域的前一个交换，大于区域扩大，当大于区域与i撞上时结束
                //swap(array,--more,i);
                more=more-1;
                swap(array,more,i);
            }
            i++;
        }
        //循环结束代表< = >三个区域已经压缩完成，只需要把num值换到大于区域的左边界就把等于区域全部搞定
        swap(array,more,r);
        return new int[]{less+1,more};
    }

    /**
     * 交换
     * @param array
     * @param L
     * @param R
     */
    public static void swap(int[] array,int L,int R){
        int temp=array[L];
        array[L]=array[R];
        array[R]=temp;
    }
}
