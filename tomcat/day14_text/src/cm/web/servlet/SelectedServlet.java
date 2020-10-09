package cm.web.servlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/selectedServlet")
public class SelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Map<String,Object> map=new HashMap<String,Object>();
        if ("gexu".equals(username)){
            //用户名存在
            map.put("userExist",true);
            map.put("msg","此用户名太受欢迎，请换一个");
        }else {
            //用户名不存在
            map.put("userExist",false);
            map.put("msg","此用户名可以使用！");
        }
        //将map转为json
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper=new ObjectMapper();
       mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
