package cn.demo.service;

/**
 * 账户业务层接口
 */
public interface AccountService {

    /**
     * 删除账户
     * @return
     */
    public int  deleteAccount();

    /**
     * 模拟保存账户
     */
    public void saveAccount();

    /**
     * 更新账户
     */
    public  void updateAccount(int i);


}
