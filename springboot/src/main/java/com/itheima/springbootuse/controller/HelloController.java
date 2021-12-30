package com.itheima.springbootuse.controller;

import com.itheima.springbootuse.dao.PetDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping(value = "test/getPet")
    public PetDao getPet(){
        PetDao p=new PetDao();
        p.setName("Tom");
        p.setAge(5);
        return p;
    }
}
