package ru.algor.parser.service;

import ru.algor.parser.entity.TradeCard;

import java.util.List;

public interface ParseCompanyInterface {
    TradeCard parseCompanyPage(String pageLink);

    List<TradeCard> parseCompanyPages(List<String> pageLinks);
}
