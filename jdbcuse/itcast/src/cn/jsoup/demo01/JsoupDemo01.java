package cn.jsoup.demo01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo01 {
    public static void main(String[] args) throws IOException {
        //1.获取document对象，通过xml文档使用Jousp里的parse()方法
        //1.1获取xml地址
        String path = JsoupDemo01.class.getClassLoader().getResource("students.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
       //2.获取元素对象
        Elements elements = document.getElementsByTag("name");
        Element element = elements.get(0);
        String name = element.text();
        System.out.println(name);

    }
}
