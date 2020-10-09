package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 过滤敏感词汇
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //创建代理对象，增强获取参数的方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter
                //判断是否是getParameter
                if (method.getName().equals("getParameter")){
                    String value= (String) method.invoke(req,args);
                    if (value!=null){
                        for (String str : list) {
                           if (value.contains(str)){
                               value=value.replaceAll(str,"***");
                           }
                        }
                    }
                    return value;
                }
                else{
                    return method.invoke(req,args);
                }
            }
        });

        chain.doFilter(proxy_req, resp);
    }
    private List<String> list=new ArrayList<String>();//敏感词汇的list集合
    public void init(FilterConfig config) throws ServletException {

        try {
            //1.加载
            String realPath = config.getServletContext().getRealPath("/WEB-INF/classes/sensitive.txt");//文件在src目录下的写法
            BufferedReader bf=new BufferedReader(new FileReader(realPath));
            //2.读取
            String line=null;
            while ((line=bf.readLine())!=null){
                list.add(line);
            }
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
    }
}
