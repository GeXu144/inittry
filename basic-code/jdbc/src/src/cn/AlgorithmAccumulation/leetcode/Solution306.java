package src.cn.AlgorithmAccumulation.leetcode;

public class Solution306 {

    /**
     * 算法需要关注以下几点：
     *          1.最少三位数
     *          2. 第一位数最多为字符串长度的一半
     *          3.第三位数的长度为第一第二位长度的最大值
     * @param num
     * @return
     */
    public boolean isAdditiveNumber(String num) {
        int n=num.length();
        if(n<3){
            return false;
        }
        for(int i=1;i<=n/2;i++){
            if(num.charAt(0)=='0'&&i>1){
                return false;
            }
            Long first=Long.valueOf(num.substring(0,i));

            //第二位数的长度处理，关键在于第三位的长度是前两位的最大值
            for(int j=1;n-j-i>=Math.max(i,j);j++){
                if(num.charAt(i)=='0'&&j>1){
                    break;
                }
                Long second=Long.valueOf(num.substring(i,i+j));
                if(isValid(first,second,i+j,num)){
                    return true;
                }
            }
        }
        return false;

    }
    public boolean isValid(Long first,Long second,int start,String num){
        if(start==num.length()){
            return true;
        }
        second=second+first;//归结为两个指标后移
        first=second-first;
        String sum=second.toString();
        return (num.startsWith(sum,start)&&isValid(first,second,start+sum.length(),num));
        //判断sum是否是以start开始

    }
}
