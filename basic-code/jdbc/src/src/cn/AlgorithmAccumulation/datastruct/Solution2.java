package src.cn.AlgorithmAccumulation.datastruct;

import java.util.Stack;

/**
 * 利用栈处理
 */
public class Solution2 {

    public static String reverseParentheses(String s){
        char[] array = s.toCharArray();
        Stack<String> stack=new Stack<>();
        //创建一个可变字符串
        StringBuilder sb=new StringBuilder();
        for (char c : array) {
            if (c=='('){
                stack.push(sb.toString());
                sb.setLength(0);
            }else if (c==')'){
                //右括号处理，可以保证从内往外去掉括号
                sb.reverse();
                sb.insert(0,stack.pop());
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str="(beautiful(stress)love)";
        String res = reverseParentheses(str);
        System.out.println(res);
    }
}
