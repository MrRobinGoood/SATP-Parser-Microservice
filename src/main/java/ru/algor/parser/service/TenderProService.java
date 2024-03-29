package ru.algor.parser.service;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.algor.parser.entity.Company;
import ru.algor.parser.entity.TradeCard;

import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TenderProService implements ParseTradesTableInterface, ParseTradeCardInterface, ParseCompanyInterface, ParseInterface {
    private TradeCardService tradeCardService;

    private CompanyService companyService;

    @Autowired
    public TenderProService(TradeCardService tradeCardService, CompanyService companyService) {
        this.tradeCardService = tradeCardService;
        this.companyService = companyService;
    }

    @Override
    public List<TradeCard> parseTradesTablePage(String pageLink) {


        String className = "table-stat__row"; // заданный класс


        try {
            Document doc = Jsoup.connect(pageLink).get();
            Elements tradeRow = doc.select("." + className);

            List<TradeCard> tradeCards = new ArrayList<TradeCard>();

            for (int i = 1; i < tradeRow.size(); i++) {

                Company company = new Company();
                company.setTitle(tradeRow.get(i).select("a.link._black2._visited").get(1).text());
                company.setLink(tradeRow.get(i).select("a.link._black2._visited").get(1).attr("href"));

                TradeCard tradeCard = new TradeCard();
                tradeCard.setTitle(tradeRow.get(i).select("a.link._black2._visited").first().text());
                tradeCard.setStage(tradeRow.get(i).select("img[title]").first().attr("title"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                tradeCard.setPublicationDateTime(LocalDateTime.parse(tradeRow.get(i).select("div.mobile-data__item").get(1).select("span").last().text().replace(".", "-") + " 00:00", formatter));
                tradeCard.setDeadlineDateTime(LocalDateTime.parse(tradeRow.get(i).select("div.mobile-data__item").get(2).select("span").last().text().replace(".", "-") + " 00:00", formatter));
                tradeCard.setLink(tradeRow.get(i).select("a.link.text_500").first().attr("href"));
                tradeCard.setStatus(tradeRow.get(i).select("td.tender__status img.text_bottom").first().attr("title"));
                tradeCard.setSourceName("«ТендерПро»");
                Company savedCompany = companyService.saveCompany(company);
                tradeCard.setCompany(savedCompany);

                tradeCards.add(tradeCard);

            }
            tradeCardService.saveTradeCards(tradeCards);
        } catch (HttpStatusException ex) {
            //...
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        try {
//            Document doc = Jsoup.connect(pageLink)
//                    .userAgent("Mozilla")
//                    .timeout(5000)
//                    .referrer("http://google.com")
//                    .get();
//            Elements titles =doc.getElementsByClass("link _black2 _visited");
//            System.out.println(titles);
//        } catch (HttpStatusException ex) {
//            //...
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        return null;
    }

    @Override
    public List<TradeCard> parseTradesTablePages(List<String> pageLinks) {
        return null;
    }

    @Override
    public TradeCard parseTradeCardPage(String pageLink) {
        return null;
    }

    @Override
    public List<TradeCard> parseTradeCardPages(List<String> pageLinks) {
        return null;
    }

    @Override
    public TradeCard parseCompanyPage(String pageLink) {
        return null;
    }

    @Override
    public List<TradeCard> parseCompanyPages(List<String> pageLinks) {
        return null;
    }

    @Override
    public List<TradeCard> parseTrades(LocalDate publicationDateFrom, LocalDate publicationDateBy, LocalDate deadlineDateFrom, LocalDate deadlineDateBy) {
        return null;
    }
}
