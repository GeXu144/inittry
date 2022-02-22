package src.cn.AlgorithmAccumulation.leetcode;

public class Solution1576 {
    public static void main(String[] args) {
        String s="ubv?w";
        String s1 = modifyString(s);
        System.out.println(s1);
    }
    /**
     * 算法思想：
     *      根据题意进行模拟，尝试对每个 s[i]进行替换，能够替换的前提是 s[i]s为 ?，
     *      且替换字符与前后字符（若存在）不同，由于只需要确保与前后字符不同，因此必然最多在 3个字符内找到可替换的值。
     *      需要使得当前i的前后值都与被替换的值不同即可。
     *
     * @param s
     * @return
     */
    public static String modifyString(String s) {
        char[] array = s.toCharArray();
        int len=array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 3&&array[i]=='?'; j++) {
                boolean tag=true;
                if (i-1>=0&&array[i-1]=='a'+j){
                    tag=false;
                }
                if (i+1<len&&array[i+1]=='a'+j){
                    tag=false;
                }
                if (tag)array[i]= (char) ('a'+j);
            }
        }
        return String.valueOf(array);
    }

}
