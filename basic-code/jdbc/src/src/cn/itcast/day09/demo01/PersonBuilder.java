package src.cn.itcast.day09.demo01;
@FunctionalInterface
public interface PersonBuilder {
    Person01 builder(String name);//根据名字创建一个类
}
