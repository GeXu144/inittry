package com.itheima.springbootuse.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//包含了getter setter To-string...
@AllArgsConstructor//有参构造器
@NoArgsConstructor//无参构造器
public class PetDao {
    private int age;
    private String name;
}
