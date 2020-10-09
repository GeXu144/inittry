package src.cn.itcast.day09.demo01;
//类的构造器引用
public class Demo01 {
    public static void printName(String name,PersonBuilder pb ){
        Person01 person = pb.builder(name);
        System.out.println(person.getName());
    }

    public static void main(String[] args) {
        printName("迪丽热巴",(String name)->{
            return new Person01(name );
        });
        printName("古力娜扎",Person01::new);//方法引用
    }
}
