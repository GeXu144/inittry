package com.itheima.springbootuse;


import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {
    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    void contextLoads() {
        //System.out.println(person);
        logger.trace(()->"追踪日志");
        logger.debug(()->"这是debug日志");
        logger.info(()->"info日志");
        logger.warn(()->"warn日志");
        logger.error(()->"错误日志");

    }

}
