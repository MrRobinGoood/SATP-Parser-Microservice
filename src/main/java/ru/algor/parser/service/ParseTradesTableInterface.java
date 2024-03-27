package ru.algor.parser.service;

import ru.algor.parser.entity.TradeCard;

import java.util.List;

public interface ParseTradesTableInterface {
    List<TradeCard> parseTradesTablePage(String pageLink);

    List<TradeCard> parseTradesTablePages(List<String> pageLinks);
}
