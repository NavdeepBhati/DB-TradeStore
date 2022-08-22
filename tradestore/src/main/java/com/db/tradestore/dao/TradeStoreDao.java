package com.db.tradestore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.db.tradestore.model.Trade;

public interface TradeStoreDao {

	public  static Map<String,Trade> tradeMap =new HashMap<>();

	public void saveTradeData(Trade trade);

	List<Trade> findAllTrades();

	Optional<Trade> findTradeById(String tradeId);

}
