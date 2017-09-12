package com.longyue.crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class HtmlFetcher {

    public String fetch(String url) {
        if (url == null || url.length() == 0) {
            return null;
        }
        try {
            Connection.Response response = Jsoup.connect(url).timeout(3000).execute();
            return response.body();
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public static <T> void main(String[] args) throws Exception {
        HtmlFetcher htmlFetcher = new HtmlFetcher();
        System.out.println(htmlFetcher.fetch("https://music.163.com/#/discover/playlist"));
    }

}