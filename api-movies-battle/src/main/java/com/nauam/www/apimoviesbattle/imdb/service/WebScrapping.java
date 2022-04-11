package com.nauam.www.apimoviesbattle.imdb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nauam.www.apimoviesbattle.imdb.model.IMDb;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class WebScrapping {

    @Bean
    public List<IMDb> scrapping() throws IOException {
        String url = "https://www.imdb.com/chart/top/?ref_=nv_mv_250";
        Document doc = Jsoup.connect(url).get();
        Element table = doc.getElementsByClass("chart full-width").first();
        Element tbody = table.getElementsByTag("tbody").first();
        Elements movies = tbody.getElementsByTag("tr");
        List<IMDb> imdbs = new ArrayList<>();

        for (Element movie: movies) {
            IMDb imdb = new IMDb();
            Elements attributes = movie.getElementsByTag("td");
            String[] info = attributes.get(1).text().split("\\. ");
            imdb.setRanking(info[0]);
            imdb.setRating(attributes.get(2).text());
            imdb.setName(info[1]);
            imdbs.add(imdb);
        }

        return imdbs;
    }

}