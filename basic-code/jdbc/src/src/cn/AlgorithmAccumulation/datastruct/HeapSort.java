package src.cn.AlgorithmAccumulation.datastruct;

public class HeapSort {

    public static void main(String[] args) {
        int[] array={13,38,49,65,97};
        heapSort(array);

    }
    public static void heapSort(int[] array){
        if (array==null||array.length<2){
            return;
        }
        //建堆
        for (int i = array.length/2; i>0 ; i--) {
            heapify(array,i,array.length);
        }
        int heapSize=array.length;
        swap(array,0,--heapSize);
        while (heapSize>0){
            heapify(array,0,heapSize);
            swap(array,0,--heapSize);
        }
    }
    public static void heapify(int[] array, int index,int heapSize){
        int left=2*index+1;
        while (left<heapSize){
            int largest=left+1<heapSize&&array[left+1]>array[left]?left+1:left;
            largest=array[largest]>array[index]?largest:index;
            if (largest==index){
                break;
            }
            swap(array,largest,index);
            index=largest;
            left=2*index+1;
        }
    }
    public static void swap(int[] array,int L,int R){
        int temp=array[L];
        array[L]=array[R];
        array[R]=temp;
    }
}
