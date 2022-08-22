package com.db.tradestore.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.db.tradestore.dao.TradeStoreDao;
import com.db.tradestore.model.Trade;

@Repository
public class TradeStoreDaoImpl implements TradeStoreDao {

	@Override
	public void saveTradeData(Trade trade) {
		
		tradeMap.put(trade.getTradeId(), trade);
	}

	@Override
	public List<Trade> findAllTrades() {
		return tradeMap.values().stream().
                collect(Collectors.toList());
	}

	@Override
	public Optional<Trade> findTradeById(String tradeId) {
		return Optional.ofNullable(tradeMap.get(tradeId));
	}

}
