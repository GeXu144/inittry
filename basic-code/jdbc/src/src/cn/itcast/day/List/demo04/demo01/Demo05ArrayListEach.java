package src.cn.itcast.day.List.demo04.demo01;

import java.util.ArrayList;

public class Demo05ArrayListEach {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("葛旭");
        list.add("知秋一叶");
        list.add("马小玲");

        System.out.println(list);

        int num=list.size();
        System.out.println("集合里有几个元素"+num);

        String name1=list.remove(2);
        System.out.println("删掉第三个元素后的集合:"+list);

        String name2 = list.get(1);
        System.out.println("第二个小可爱叫什么:"+name2);

    }
}
