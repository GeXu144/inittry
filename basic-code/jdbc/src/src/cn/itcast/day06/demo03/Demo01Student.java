package src.cn.itcast.day06.demo03;

public class Demo01Student {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setAge(21);
        stu.setName("葛旭");
        stu.setMale(true);
        System.out.println("名字是" + stu.getName());
        System.out.println("年龄" + stu.getAge());
        System.out.println("是不是帅气的男孩子" + stu.isMale());
    }
}
