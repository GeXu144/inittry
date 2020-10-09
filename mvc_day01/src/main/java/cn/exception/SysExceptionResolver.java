package cn.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver{
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        SysException e=null;
       if (ex instanceof SysException){
           e=(SysException)ex;
       }else {
           e=new SysException("系统正在维护。。。。。");
       }
       ModelAndView mv=new ModelAndView();
       mv.addObject("errorMsg",e.getMessage());
       mv.setViewName("error");
        return mv;
    }
}
