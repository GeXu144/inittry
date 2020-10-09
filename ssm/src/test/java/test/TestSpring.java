package test;

import cn.itcast.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void run1(){

        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService service = context.getBean("accountService", AccountService.class);
        service.findAll();
    }

}
