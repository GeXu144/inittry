package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao dao=new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //1.调用dao实现查询
        List<User> users = dao.findAll();
        return users;
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        //2.调用dao进行登录操作
        User loginuser = dao.login(user);
        return loginuser;
    }

    /**
     * 添加
     * @param user
     */
    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    /**
     * 根据id删除用户数据
     * @param id
     */
    @Override
    public void deleteUser(String id) {
       dao.deleteUser(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedById(String[] ids) {
        for (String id : ids) {
            dao.deleteUser(Integer.parseInt(id));
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
       int currentPage=Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //1.创建一个空的PageBean
        PageBean<User> pb=new PageBean<User>();
        //2.设置参数
        if (currentPage<=0){
            currentPage=1;
        }
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
       //调用查询总记录数
        int totalCount=dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        //调用dao查询List集合
        //计算开始的索引
        int start=(currentPage-1)*rows;
       List<User> list= dao.findByPage(start,rows,condition);
       pb.setList(list);

       //计算总页码
        int totalPage=(totalCount%rows) ==0 ? totalCount/rows : (totalCount/rows)+1;
        pb.setTotalPage(totalPage);
        return pb;
    }
}
