package ru.algor.parser.service;

import ru.algor.parser.entity.TradeCard;

import java.util.List;

public interface ParseTradeCardInterface {
    TradeCard parseTradeCardPage(String pageLink);

    List<TradeCard> parseTradeCardPages(List<String> pageLinks);

}
