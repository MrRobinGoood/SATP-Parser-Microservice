package ru.algor.parser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.algor.parser.entity.TradeCard;

import java.time.LocalDate;
import java.util.List;

@Service
public class TenderProService implements ParseTradesTableInterface, ParseTradeCardInterface, ParseCompanyInterface, ParseInterface {
    private TradeCardService tradeCardService;


    @Override
    public List<TradeCard> parseTradesTablePage(String pageLink) {
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
