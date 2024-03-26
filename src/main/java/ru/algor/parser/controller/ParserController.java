package ru.algor.parser.controller;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/parser")
public class ParserController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/tenderpro")
    public void createInfo() {
        try {
            String url = "https://www.tender.pro/api/tenders/list?sid=&company_id=&face_id=0&order=3&tender_id=&tender_name=&company_name=&good_name=&tender_type=90&tender_state=1&country=1&region=0&basis=0&okved=&dateb=&datee=&dateb2=&datee2=";
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla")
                    .timeout(5000)
                    .referrer("http://google.com")
                    .get();
            Elements titles =doc.getElementsByClass("link _black2 _visited");
            System.out.println(titles);
        } catch (HttpStatusException ex) {
            //...
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//https://www.tender.pro/api/tenders/list?sid=&company_id=&face_id=0&order=3&tender_id=&tender_name=&company_name=&good_name=&tender_type=90&tender_state=1&country=1&region=0&basis=0&okved=&dateb=&datee=&dateb2=&datee2=
//https://www.tender.pro/api/tenders/list?sid=&good_name=&is_nelikvid=&tender_name=&dateb=&datee=&dateb2=&datee2=&tender_type=90&company_name=&tender_state=1&tender_show_own=0&tender_id=&tender_interest_type=&country=1&region=0&basis=0&mode=&okved=&tender_invited=&tender_promoter=1&tender_officer=0&company_id=&filter_reset=&by=25&order=3&page=1

//https://icetrade.by/search/foreign?search_text=&auc_num=&company_title=&countries%5B%5D=RUS&industries=&period=&created_from=&created_to=&request_end_from=&request_end_to=&sort=num%3Adesc&sbm=1&onPage=20
//https://icetrade.by/search/foreign?search_text=&auc_num=&company_title=&countries%5B%5D=RUS&industries=&period=&created_from=&created_to=&request_end_from=&request_end_to=&sort=num%3Adesc&sbm=1&onPage=20&p=2