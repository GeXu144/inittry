package src.cn.itcast.day06.demo03;

public class Student {
    private String name;
    private int age;
    private boolean male;

    public void setName(String str){
        name = str;
    }
    public String getName(){
        return name;
    }
    public void setAge(int num){
        age = num;
    }public int getAge(){
        return age;
    }
    public void setMale(boolean b){
        male = b;
    }
    public boolean isMale(){
        return male;
    }

}
