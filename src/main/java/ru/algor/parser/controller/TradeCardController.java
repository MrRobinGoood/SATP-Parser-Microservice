package ru.algor.parser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.algor.parser.entity.TradeCard;
import ru.algor.parser.service.TradeCardService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/trades")
public class TradeCardController {

    private TradeCardService tradeCardService;

    @Autowired
    public TradeCardController(TradeCardService tradeCardService) {
        this.tradeCardService = tradeCardService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<TradeCard> getTradeCards() {
        return tradeCardService.getTradeCards();
    }

}
