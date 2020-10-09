package src.cn.itcast.day11.demo02;
//计算器
public class Calculator {
    @Check
    public void add(){
        System.out.println("1+0="+(1+0));
    }
    @Check
    public void sub(){
        System.out.println("1-0="+(1-0));
    }
    @Check
    public void div(){
        System.out.println("1/0="+(1/0));
    }
}
