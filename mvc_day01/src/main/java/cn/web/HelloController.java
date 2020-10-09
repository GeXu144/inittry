package cn.web;

import cn.domain.Account;
import cn.domain.User;
import cn.exception.SysException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * 控制器类
 */
@Controller
@RequestMapping(path = "/user")
public class HelloController {

    @RequestMapping(path = "/sayHello")
    public String sayHello(String username){
        System.out.println("hello");
        System.out.println(username);
        return "success";
    }

    /**
     * 请求参数，将表单进行封装为JavaBean
     * @param account
     * @return
     */
    @RequestMapping(path = "/saveAccount")
    public String saveAccount(Account account){
        System.out.println(account);
        return "success";
    }

    /**
     * 获取原生的servlet API
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(path = "/testServlet")
    public void testServlet(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println(" testServlet执行了");
        //转发
       //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
        response.sendRedirect(request.getContextPath()+"/success.jsp");
    }

    /**
     * restful编码风格
     * (@PathVariable(name = "sid")简单运用
     * @param id
     * @return
     */
    @RequestMapping(path = "/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println(id);
        return "success";
    }

    /**
     * ModelAndView对象的使用
     * @return
     */
    @RequestMapping(path = "/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println(" testModelAndView方法执行了");
        //创建 ModelAndView对象
        ModelAndView mv=new ModelAndView();
        User user=new User();
        user.setUname("葛旭");
        user.setAge(22);

        //封装到request域中
        mv.addObject("user",user);
        //跳转页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字进行跳转
     * @return
     */
    @RequestMapping(path = "/testKeyWords")
    public String testKeyWords(){
        System.out.println("hello");
        //return "forward:/WEB-INF/pages/success.jsp";
        return "redirect:/index.jsp";
    }

    /**
     * 接受ajax发送的数据
     * @param user
     */
    @RequestMapping(path = "/textJson")
    public @ResponseBody User textJson(@RequestBody User user){
        //通过导入Jackson坐标，可以将客户端发送的Jason数据封装到user对象中
        System.out.println(user);
        //响应
        user.setAge(40);
        user.setUname("李雅琪");
        return user;
    }

    /**
     * 传统方式文件上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/traditionalUpload")
    public String traditionalUpload(HttpServletRequest request) throws Exception {
       //获取上传的路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在，创建文件夹
        File file=new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        //创建磁盘文件项工厂，解析文件项
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload sf=new ServletFileUpload(factory);

        //解析request
        List<FileItem> fileItems = sf.parseRequest(request);
        for (FileItem item : fileItems) {
            //判断是否为表单项
            if (item.isFormField()){
                //普通表单
            }else {
                //上传文件项
                String filename = item.getName();
                //完成上传
                item.write(new File(path,filename));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /**
     * SpringMVC方式上传文件
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/upload")
    public String upload(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("upload执行了");
        //获取上传的路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在，创建文件夹
        File file=new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        //名字唯一值UUID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        //完成文件的上传
        upload.transferTo(new File(path,filename));

        return "success";
    }

    /**
     * 异常处理器的简单运用
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/testException")
    public String testException() throws Exception{
        System.out.println("testException执行了");
        try {
            int i=10/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询所有用户信息出现错误......");
        }
        return "success";
    }

    @RequestMapping(path = "/testInterceptor")
    public String testInterceptor(){
        System.out.println("hello");
        return "success";
    }
}
