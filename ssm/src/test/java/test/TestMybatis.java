package test;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class TestMybatis {
    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void run() throws Exception {
        //加载文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建session对象
        SqlSession session= factory.openSession();
        //获取代理对象
        AccountDao dao =session.getMapper(AccountDao.class);
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        //关闭资源
        session.close();
        in.close();

    }

    @Test
    public void run1() throws Exception {
        //加载文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建session对象
        SqlSession session= factory.openSession();
        //获取代理对象
        AccountDao dao =session.getMapper(AccountDao.class);
        //创建account对象
        Account account=new Account();
        account.setName("吴薇");
        account.setMoney(2500d);
        //调用dao
        dao.saveAccount(account);
        //提交事务
        session.commit();
        //关闭资源
        session.close();
        in.close();

    }
}
