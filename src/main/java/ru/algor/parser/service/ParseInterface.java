package ru.algor.parser.service;

import ru.algor.parser.entity.TradeCard;

import java.time.LocalDate;
import java.util.List;

public interface ParseInterface {
    List<TradeCard> parseTrades(LocalDate publicationDateFrom, LocalDate publicationDateBy, LocalDate deadlineDateFrom, LocalDate deadlineDateBy);

}
