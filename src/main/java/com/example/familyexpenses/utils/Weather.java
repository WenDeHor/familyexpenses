package com.example.familyexpenses.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;


public class Weather {
    private final static Integer TIMEOUTMILLIS = 10000;

    private static Document getPage() throws IOException {
        String url = "https://ua.sinoptik.ua";
        Document page = Jsoup.parse(new URL(url), TIMEOUTMILLIS);
        return page;
    }

    public static void main(String[] args) throws IOException {
        Document page = getPage();
        Element table = page.select("div[class=tabs]").first();
        Elements tabsWeather = table.select("div[class~=weatherIco (?i)]");
        Elements tabsDays = table.select("div[id~=bd(?i)]");
        Element tabsTemperature = tabsDays.select("div[class=temperature]").first();

        for (Element name : tabsDays) {
            String Day = name.select("*[class=day-link]").text();
            String Number = name.select("*[class~=date (?i)]").text();
            String Month = name.select("*[class=month]").text();
            System.out.println(Day);
            System.out.println(Number);
            System.out.println(Month);

            String linkHref = tabsWeather.attr("title");
            Elements imgHtml = tabsWeather.select("img[src$=.gif]");
            String img2 = imgHtml.attr("src");
            System.out.println(linkHref);
            System.out.println(img2);

            String firstTemperatureMin = tabsTemperature.select("div[class=min]").text();
            String firstTemperatureMax = tabsTemperature.select("div[class=max]").text();
            System.out.println(firstTemperatureMin);
            System.out.println(firstTemperatureMax);
        }

    }
}
