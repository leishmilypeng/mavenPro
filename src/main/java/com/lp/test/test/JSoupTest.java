package com.lp.test.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by CPR161 on 2016-12-09.
 */
public class JSoupTest {
    public static void main(String[] args) {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://10.0.14.205:8080/erp/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements newsHeadlines = doc.select("a");

        System.out.println(newsHeadlines);
    }
}
