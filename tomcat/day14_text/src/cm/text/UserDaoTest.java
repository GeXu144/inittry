package cm.text;

import cm.dao.UserDao;
import cm.daomain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testlogin(){
        User loginuser =new User();
        loginuser.setUsername("baby");
        loginuser.setPassword("123");

        UserDao dao =new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }
}
