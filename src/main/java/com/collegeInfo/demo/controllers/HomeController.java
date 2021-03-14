package com.collegeInfo.demo.controllers;

import com.collegeInfo.demo.models.KoreaStats;
import com.collegeInfo.demo.services.CoronaVirusDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/korea")
    public String korea(Model model) throws IOException {
        List<KoreaStats> koreaStatsList = coronaVirusDataService.getKoreaCovidDatas();
        model.addAttribute("koreaStats", koreaStatsList);

        return "korea";
    }
}
