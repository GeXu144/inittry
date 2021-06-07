package com.itheima.springbootuse.utils;

import com.itheima.springbootuse.domain.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HtmlParseUtils {
    public static void main(String[] args) throws Exception {
        String url="https://search.jd.com/Search?keyword=java";
        Document document = Jsoup.parse(new URL(url), 30000);
        Element element = document.getElementById("J_goodsList");
        System.out.println(element.html());
        Elements elements = element.getElementsByTag("li");
        ArrayList<Content> list=new ArrayList<Content>();
        for (Element el : elements) {
            String img = el.getElementsByTag("imag").eq(0).attr("source-data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();
            //加入类中
            Content content=new Content();
            content.setTitle(title);
            content.setImg(img);
            content.setPrice(price);

            list.add(content);
            for (Content content1 : list) {
                System.out.println(content1);
            }

        }

    }

}
