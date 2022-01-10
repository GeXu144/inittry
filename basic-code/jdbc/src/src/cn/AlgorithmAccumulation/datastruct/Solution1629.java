package src.cn.AlgorithmAccumulation.datastruct;

public class Solution1629 {

    /**
     * 根据题意，从先往后处理每个 kp[i]，计算每次的持续时间（当前结束时间与上次时间的差值）
     *      rt[i] - rt[i - 1]，遍历过程中维护最大持续时间和对应的字符下标。
     * @param rt
     * @param kp
     * @return
     */
    public static char slowestKey(int[] rt, String kp) {
        int n=rt.length;
        int index=0;
        int max=rt[0];
        for (int i = 1; i < n; i++) {
           int cur=rt[i]-rt[i-1];
           if (cur>max){
               max=cur;
               index=i;
           }else if (cur==max&&kp.charAt(i)>kp.charAt(index)){
               index=i;
           }
        }
        return kp.charAt(index);
    }
}
