package com.collegeInfo.demo.services;

import com.collegeInfo.demo.models.KoreaStats;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusDataService {
    private static String KOREA_COVID_DATAS_URL = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13";

    @PostConstruct
    public List<KoreaStats> getKoreaCovidDatas() throws IOException {
        List<KoreaStats> koreaStatsList = new ArrayList<>();
        Document doc = Jsoup.connect(KOREA_COVID_DATAS_URL).get();
        Elements contents = doc.select("table tbody tr");

        for (int i=0; i<contents.size()-1; i++) {
            Elements tdContents = contents.get(i).select("td");

            KoreaStats koreaStats = KoreaStats.builder()
                    .country(contents.get(i).select("th").text())
                    .diffFromPrevDay_sum(Integer.parseInt(tdContents.get(0).text().replaceAll("[,]","")))
                    .total(Integer.parseInt(tdContents.get(3).text().replaceAll("[,]","")))
                    .death(Integer.parseInt(tdContents.get(6).text().replaceAll("[,]","")))
                    .incidence(Double.parseDouble(tdContents.get(7).text().replaceAll("[,]","")))
                    .build();
            koreaStatsList.add(koreaStats);
        }
        return koreaStatsList;
    }
}
