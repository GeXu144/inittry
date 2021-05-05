package src.cn.itcast.day12;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapEntry {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("葛旭",22);
        map.put("赵丽颖",25);
        //遍历方式一
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+":"+value);
        }
        System.out.println("-----------------------");
        //遍历方式二
        Set<String> keySet = map.keySet();
        for (String key1 : keySet) {
            Integer value1 = map.get(key1);
            System.out.println(key1+":"+value1);
        }
    }
}
