package src.cn.AlgorithmAccumulation.day01_1;

public class LastWordsLength {
    /**
     *
     * @param str
     * @return
     */
    public static int lastWorldsLength(String str){
        char[] array = str.toCharArray();
        int len=0;
        for (int i = array.length-1; i >=0; i--) {
            if(array[i]!=' '){
               len++;
            }else if (len!=0){
                return len;
            }
        }
        return len;
    }
    public static void main(String[] args) {
        String str="hello world";
        int i = lastWorldsLength(str);
        System.out.println(i);
    }
}
