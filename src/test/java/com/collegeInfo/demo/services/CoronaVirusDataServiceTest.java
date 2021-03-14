package com.collegeInfo.demo.services;

import com.collegeInfo.demo.models.KoreaStats;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoronaVirusDataServiceTest {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;
    @Test
    public void getKoreaCovidDatas_동작확인() throws IOException {
        //given
        List<KoreaStats> coronaList = new ArrayList<>();

        //when
        coronaList = coronaVirusDataService.getKoreaCovidDatas();

        // then
        assertThat(coronaList.get(0).getCountry()).isEqualTo("합계");
        assertThat(coronaList.get(0).getTotal()).isGreaterThan(0);
    }
}
