<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
   <script src="js/jquery-1.11.0.min.js"></script>

    <script>
    $(function (){
        //绑定单击事件
        $("#btn").click(function () {
           //发送ajax请求
            $.ajax({
                url:"user/textJson",
                contentType:"application/json;charset=utf-8",
                data:'{"uname":"葛旭","age":22}',
                dataType:"json",
                type:"post",
                success:function (data) {
                    alert(data.age);
                    alert(data.uname);
                }
            });
        });
    });
    </script>
</head>
<body>
    <%--<<h3>入门程序</h3>
    <a href="hello?username=gexu">入门程序</a>--%>
    <%--<<form action="user/saveAccount" method="post">
       用户名：<input type="text" name="username">
        密码：<input type="text" name="password">
        生日：<input type="text" name="birthday">
        <input type="submit" value="提交">
    </form>--%>
    <%--<a href="user/testPathVariable/520">入门程序</a>--%>
    <%--<<a href="user/testKeyWords">入门程序</a>--%>
    <%--<<button id="btn" type="text/javascript">提交</button>--%>

    <%--文件上传--%>
    <%--<<form action="user/upload" method="post" enctype="multipart/form-data">
        文件上传：<input type="file" name="upload" /><br>
        <input type="submit" value="上传"><br>
    </form>--%>

    <%--springMVC异常处理--%>
    <h3>异常处理</h3>
    <a href="user/testException">异常处理</a>

    <a href="user/testInterceptor">入门程序</a>
</body>
</html>
