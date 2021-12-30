package com.itheima.springbootuse.dao;


public class Demo01 {

    public  static void main(String[] args) {
        PetDao dao=new PetDao();
        dao.setAge(18);
        dao.setName("Tom");
        System.out.println(dao);

    }
}
