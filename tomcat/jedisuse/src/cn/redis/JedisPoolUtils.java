package cn.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * JedisPool连接池工具类
 */
public class JedisPoolUtils {

    private static JedisPool jedisPool;//声明连接池
    //加载配置文件
    static {
        InputStream resource = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        //创建properties
        Properties pro=new Properties();
        try {
            pro.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据，设置到JedisPoolConfig
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));

        //初始化JedisPool对象
        jedisPool=new JedisPool(config, pro.getProperty("host"),Integer.parseInt(pro.getProperty("port")));
    }
    /**
     * 获取连接对象
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
