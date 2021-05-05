package src.cn.itcast.day12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapPractice {
    /**
     * 统计字符个数
     */
    public static void CharacterCounter(){
        System.out.println("请输入：");
        Scanner sc=new Scanner(System.in);
        String str = sc.next();
        //转换成char数组
        char[] chars = str.toCharArray();
        HashMap<Character,Integer>map=new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)){
                //map中已经存在
                //取出已经存在的value并且加1
                Integer value = map.get(c);
                value++;
                //加完之后再存入map集合
                map.put(c,value);
            }else{
                //如果原先不存在
                map.put(c,1);
            }
        }
        //遍历map，打印结果
        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        for (Map.Entry<Character, Integer> entry : set) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+"\t"+value+"次");
        }
    }
    public static void main(String[] args) {
        CharacterCounter();
    }
}
