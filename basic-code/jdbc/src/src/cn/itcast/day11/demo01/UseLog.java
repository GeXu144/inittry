package src.cn.itcast.day11.demo01;

public class UseLog {
    public static void showLog(int level,MessageBuilder ms){
        if (level==1){
            System.out.println(ms.builderMessage());
        }
    }

    public static void main(String[] args) {
        String mg1="hello";
        String mg2="world";
        String mg3=".java";
        showLog(1,()->{
            return mg1+mg2 +mg3;
        });
    }
}
