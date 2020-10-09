package cn.demo.service.impl;

import cn.demo.service.AccountService;

public class AccountServiceImpl implements AccountService {
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }

    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新操作"+i);
    }
}
