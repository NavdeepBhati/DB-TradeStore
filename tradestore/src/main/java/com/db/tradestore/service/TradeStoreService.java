package com.db.tradestore.service;

import java.util.List;
import java.util.Optional;

import com.db.tradestore.model.Trade;


public interface TradeStoreService {

	public void  saveTradeData(Trade trade);
	
	public List<Trade> findAllTrades();
	
	public void updateExpiryFlagOfTrade();
	
	Optional<Trade> findTradeById(String tradeId);
	
}
