package src.cn.itcast.day.List.demo04.demo01;

import java.util.Arrays;

public class Demo06Arrays {
    public static void main(String[] args) {
        String str="abggjuibjjkijuhe68874898yufhnvjdbvu";
        char[] chars=str.toCharArray();//对字符串进行数组处理
        Arrays.sort(chars);//对数组升序排列，即从小到大
        for (int i = chars.length - 1; i >= 0; i--) {   //倒序打印
            System.out.println(chars[i]);
        }
    }
}
