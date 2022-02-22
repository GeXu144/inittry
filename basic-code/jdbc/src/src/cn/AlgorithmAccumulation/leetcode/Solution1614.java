package src.cn.AlgorithmAccumulation.leetcode;

/**
 * LeetCode括号最大镶嵌深度----实质就是左括号的最大连续数，考虑math的max方法
 */
public class Solution1614 {

    /**
     * LeetCode-1614：寻找到最大的连续左括号数
     *算法思想：1.遇到左括号+1，遇到右括号-1，统计最大值
     * @param s
     * @return
     */
    public static int maxDepth(String s) {
        int n = s.length();
        char[] item = s.toCharArray();
        int ans=0;
        for (int i = 0,cur=0; i < n; i++) {
            //处理左括号
            if (item[i]=='('){
                cur++;
                ans=Math.max(ans,cur);
            }
            //处理右括号
            if (item[i]==')'){
                cur--;
            }
        }
        return ans;
    }
}
