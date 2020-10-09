package src.cn.itcast.day08.demo01;

import java.io.File;

public class DeleteText {
    public static void main(String[] args) {
        show01();
    }

    private static void show01() {
        File d = new File("E:\\Helloworld.java");
        boolean b = d.delete();
        System.out.println(b);
    }
}
