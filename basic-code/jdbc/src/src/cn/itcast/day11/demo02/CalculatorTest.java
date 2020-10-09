package src.cn.itcast.day11.demo02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@SuppressWarnings("all")
public class CalculatorTest {
    /**
     *  创建一个测试框架
     *  当主方法执行后，检测所有方法，有异常就写入到文件中
     */
    public static void main(String[] args) throws IOException {
        //1.首先创建计算器对象
        Calculator c=new Calculator();
        //2.获取字节码文件对象，调用getclass方法
        Class cl = c.getClass();
        //3.获取所有方法
        Method[] methods = cl.getMethods();
        //4.判断方法上是否有check注解
        int number=0;
        BufferedWriter bw=new BufferedWriter(new FileWriter("bug.txt"));
        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(c);
                    //如果有注解，就执行方法
                } catch (Exception e) {
                    //捕获异常，写入bug.txt文件
                    number++;
                    bw.write(method.getName()+"方法出异常了！");
                    bw.newLine();
                    bw.write("异常的名称:"+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("---------------------");
                    bw.newLine();
                    }
            }
        }
        bw.write("本次测试一共出现"+number+"次异常");
        bw.flush();
        bw.close();
    }
}
