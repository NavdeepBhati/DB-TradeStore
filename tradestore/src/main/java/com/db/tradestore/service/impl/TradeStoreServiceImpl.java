package com.db.tradestore.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.tradestore.dao.TradeStoreDao;
import com.db.tradestore.exception.InvalidTradeException;
import com.db.tradestore.model.Trade;
import com.db.tradestore.service.TradeStoreService;
import com.db.tradestore.utility.TradeStoreUtility;

@Service
public class TradeStoreServiceImpl implements TradeStoreService{

	@Autowired
	TradeStoreDao tradeStoreDao;

	@Override
	public void saveTradeData(Trade incomingTrade) {
		
		 Optional<Trade> exsitingTrade = findTradeById(incomingTrade.getTradeId());
		 if(TradeStoreUtility.isValid(exsitingTrade, incomingTrade)) {
			 incomingTrade.setCreatedDate(LocalDate.now());
			 tradeStoreDao.saveTradeData(incomingTrade);
		 }else{
			 throw new InvalidTradeException(incomingTrade.getTradeId());
		 }
		
	}

	@Override
	public List<Trade> findAllTrades() {
		return tradeStoreDao.findAllTrades();
	}

	@Override
	public void updateExpiryFlagOfTrade() {
		tradeStoreDao.findAllTrades().stream().forEach(t -> {
            if (!TradeStoreUtility.validateMaturityDate(t)) {
                t.setExpiredFlag("Y");
                tradeStoreDao.saveTradeData(t);
            }
        });
    }

	@Override
	public Optional<Trade> findTradeById(String tradeId) {
		return tradeStoreDao.findTradeById(tradeId);
	}
	
	
}
