package ru.algor.parser.controller;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.algor.parser.service.TenderProService;

import java.io.IOException;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/parse")
public class ParserController {
    private TenderProService tenderProService;

    @Autowired
    public ParserController(TenderProService tenderProService) {
        this.tenderProService = tenderProService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/tenderpro")
    public void parseTenderPro() {
        int countPages = 11;
        for (int i = 2; i < countPages; i++) {
            String pageLink = "https://www.tender.pro/api/tenders/list?sid=&good_name=&is_nelikvid=&tender_name=&dateb=&datee=&dateb2=&datee2=&tender_type=90&company_name=&tender_state=1&tender_show_own=0&tender_id=&tender_interest_type=&country=1&region=0_0&basis=0&mode=&okved=&tender_invited=&tender_promoter=1&tender_officer=0&company_id=&filter_reset=&by=25&order=3&page=" + i;
            tenderProService.parseTradesTablePage(pageLink);
        }
    }
}
