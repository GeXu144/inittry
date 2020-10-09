package cn.jsoup.demo01;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
    XPath查询

 */
public class JsoupDemo02 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //1.获取document对象，通过xml文档使用Jousp里的parse()方法
        //1.1获取xml地址
        String path = JsoupDemo01.class.getClassLoader().getResource("students.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        //2.需要基于document对象创建JXdocument对象
        JXDocument jxNode=new JXDocument(document);
        //3.结合xpath语法查询
        List<JXNode> jxNodes = jxNode.selN("//students");
        for (JXNode node : jxNodes) {
            System.out.println(node);
        }
        System.out.println("---------------------------");
        List<JXNode> jxNodes1 = jxNode.selN("//students/name");
        for (JXNode node : jxNodes1) {
            System.out.println(node);
        }
        System.out.println("---------------------------");
        List<JXNode> jxNodes3 = jxNode.selN("//students/name[@id]");
        for (JXNode node : jxNodes3) {
            System.out.println(node);
        }

    }
}
