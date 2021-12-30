package src.cn.AlgorithmAccumulation.datastruct;

import java.util.Stack;

public class Solution3 {
    public static void main(String[] args) {
        String s="()[[";
        Solution3 a=new Solution3();
        boolean valid = a.isValid(s);
        if (valid==true){
            System.out.println("括号匹配成功");
        }else{
            System.out.println("匹配失败");
        }
    }
    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<Character>();
        for (char c:s.toCharArray()) {
            if (c=='('||c=='['||c=='{'){
                stack.push(c);
            }
            else{
                if (stack.isEmpty()){
                    return false;
                }
                if (c==')'&&stack.pop()!='('){
                    return false;
                }
                if (c=='}'&&stack.pop()!='{'){
                    return false;
                }
                if (c==']'&&stack.pop()!='['){
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
