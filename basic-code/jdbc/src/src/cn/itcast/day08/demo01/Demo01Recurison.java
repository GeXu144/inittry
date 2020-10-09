package src.cn.itcast.day08.demo01;

import java.io.File;

public class Demo01Recurison {
    public static void main(String[] args) {
        File file = new File("D:\\IdeaProjects\\basic-code\\day04-code\\src\\cn\\itcast");
        getPointFile(file);
    }

    private static void getPointFile(File dir) {
        File[] files=dir.listFiles();
        for (File f : files) {
            if (f.isDirectory()){
                getPointFile(f);
            }else{
                if (f.getName().toLowerCase().endsWith(".java"));//递归思想搜索以.java结尾的文件
                System.out.println(f);
            }
        }
    }
}
