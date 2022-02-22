package src.cn.AlgorithmAccumulation.datastruct;

public class BitOperation {
    public static void main(String[] args) {
        int[] array={1,2,3,4,4,3,8,8,8,8,9,9};
        printOddTimesNum2(array);

    }
    public static void printOddTimesNum2(int[] array){
        int ero=0;
        for (int cur : array) {
            ero^=cur;
        }
        int rightOne=ero&(~ero+1);//获取最右边的一，第八位的一
        int ero1=0;
        for (int cur : array) {
            if ((cur&rightOne)==0){
                ero1^=cur;
            }
        }
        System.out.println(ero1+"  "+(ero^ero1));
    }
}
