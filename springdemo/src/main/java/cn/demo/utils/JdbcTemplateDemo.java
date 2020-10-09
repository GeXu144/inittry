package cn.demo.utils;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate template = context.getBean("JdbcTemplate", JdbcTemplate.class);
       template.execute("insert into user(username,password) value('lisi','456')");

    }
}
