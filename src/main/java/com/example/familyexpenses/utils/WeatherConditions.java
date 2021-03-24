package com.example.familyexpenses.utils;

import com.example.familyexpenses.model.Weather;
import com.example.familyexpenses.repository.WeatherRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.IOException;
import java.net.URL;


public class WeatherConditions {
    private final static Integer TIMEOUTMILLIS = 10000;
    @Autowired
    WeatherRepository weatherRepository;

    private Document getPage() throws IOException {
        String url = "https://ua.sinoptik.ua";
        Document page = Jsoup.parse(new URL(url), TIMEOUTMILLIS);
        return page;
    }

    public void getWeather() throws IOException {
        Document page = getPage();
        Element table = page.select("div[class=tabs]").first();
        Elements tabsWeather = table.select("div[class~=weatherIco (?i)]");
        Elements tabsDays = table.select("div[id~=bd(?i)]");
        Element tabsTemperature = tabsDays.select("div[class=temperature]").first();

        for (Element name : tabsDays) {
            String day = name.select("*[class=day-link]").text();
            String number = name.select("*[class~=date (?i)]").text();
            String month = name.select("*[class=month]").text();
            System.out.println(day);
            System.out.println(number);
            System.out.println(month);

            String linkHref = tabsWeather.attr("title");
            Elements imgHtml = tabsWeather.select("img[src$=.gif]");
            String img2 = imgHtml.attr("src");
            System.out.println(linkHref);
            System.out.println(img2);

            String temperatureMin = tabsTemperature.select("div[class=min]").text();
            String temperatureMax = tabsTemperature.select("div[class=max]").text();
            System.out.println(temperatureMin);
            System.out.println(temperatureMax);
            Weather weatherConditions = Weather.builder()
                    .number(number)
                    .day(day)
                    .month(month)
                    .linkHref(linkHref)
                    .img(img2)
                    .temperatureMin(temperatureMin)
                    .temperatureMax(temperatureMax)
                    .build();
            weatherRepository.save(weatherConditions);
        }

    }
}
