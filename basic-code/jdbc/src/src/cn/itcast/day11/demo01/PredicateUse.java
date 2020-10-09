package src.cn.itcast.day11.demo01;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateUse {
    public static ArrayList<String> fileter(String[]arr, Predicate<String>ps1,Predicate<String>ps2){
        ArrayList<String> list =new ArrayList<>();
        for (String s : arr) {
            boolean b = ps1.and(ps2).test(s);
            if (b){
                    list.add(s );
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] arr={"迪丽热巴,女","马尔扎哈,男","古力娜扎,女"};
       ArrayList<String> list = fileter(arr,(String s)->{
            return s.split(",")[1].contains("女");
        },(String s)->{
            return  s.split(",")[0].length()==4;
        });
        for (String s : list) {
            System.out.println(s );
        }
    }

}
