package src.cn.itcast.day11.demo01;

import java.util.function.Consumer;

public class ConsumerUse {
    public static void PrintInfo(String[] arr, Consumer<String>co1,Consumer<String>co2){
        for (String message : arr) {
            co1.andThen(co2).accept(message);
        }
    }

    public static void main(String[] args) {
        String[] arr={"迪丽热巴,女","葛旭,男","张煜,女"};
        PrintInfo(arr,(message)->{
            String name=message.split(",")[0];
            System.out.println("名字:"+name);
        },(message)->{
            String gen=message.split(",")[1];//分割
            System.out.println("性别："+gen);//消费
        });
    }
}
