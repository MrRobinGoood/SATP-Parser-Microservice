package ru.algor.parser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.algor.parser.entity.TradeCard;
import ru.algor.parser.repository.TradeCardRepository;

import java.util.List;

@Service
public class TradeCardService {

    private TradeCardRepository tradeCardRepository;

    @Autowired
    public TradeCardService(TradeCardRepository tradeCardRepository) {
        this.tradeCardRepository = tradeCardRepository;
    }

    public List<TradeCard> getTradeCards(){
        return tradeCardRepository.findAll();
    }

    public void saveTradeCards(List<TradeCard> tradeCards) {
        tradeCardRepository.saveAll(tradeCards);
    }

}
