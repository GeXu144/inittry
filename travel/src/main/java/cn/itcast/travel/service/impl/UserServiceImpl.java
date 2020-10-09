package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //1.根据用户名查询用户对象
        User u = dao.findByUsername(user.getUsername());
        if (u!=null){
            //用户名存在，注册失败
            return false;
        }
        //设置激活码
        user.setCode(UuidUtil.getUuid());
        // 设置激活状态
        user.setStatus("N");
        //2.保存用户信息
        dao.save(user);
        //发送邮件
        String content="<a href='http://localhost/user/active?code="+user.getCode()+"'>点击激活旅游网</a>";
        MailUtils.sendMail(user.getEmail(),content,"激活邮件页面");
        return true;
    }

    /**
     * 激活用户
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户
        User user=dao.findByCode(code);
        if (user!=null){
            //2.调用dao调整用户状态
            dao.updateStatus(user);
            return true;
        }else {
            return false;
        }
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return dao.login(user.getUsername(),user.getPassword());
    }
}
