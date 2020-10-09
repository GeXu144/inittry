package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账户web层
 */
@Controller
@RequestMapping("account/")
public class AccountController {
    @Autowired
    private AccountService service;

    /**
     * 查询所有
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model){

        System.out.println("查询所有");
        List<Account> list = service.findAll();
        model.addAttribute("list",list);
        return "success";
    }

    /**
     * 用户保存操作
     * @param account
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
       service.saveAccount(account);
       response.sendRedirect(request.getContextPath()+"/account/findAll");
       return;
    }
}
