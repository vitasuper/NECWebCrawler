package com.longyue.crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class HtmlFetcher {

    public String fetch(String url) {
        if (url == null || url.length() == 0 || !(url.startsWith("http://") || url.startsWith("https://"))) {
            return null;
        }
        try {
            Connection.Response response = Jsoup.connect(url).timeout(3000).execute();

            // System.out.println(response.body());  // Get the body of the HTML page

            // Recommended judging process
            return response.statusCode() / 100 == 2 ? response.body() : null;

            // return response.body();

        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public static <T> void main(String[] args) throws Exception {
        HtmlFetcher htmlFetcher = new HtmlFetcher();
        System.out.println(htmlFetcher.fetch("http://music.163.com/#/discover/playlist/?order=hot&cat=%E5%85%A8%E9%83%A8&limit=35&offset=0"));
    }

}
