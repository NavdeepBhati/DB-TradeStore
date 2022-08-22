package com.db.tradestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.tradestore.model.Trade;
import com.db.tradestore.service.TradeStoreService;

@RestController
public class TradeStoreController {

	@Autowired
	TradeStoreService tradeStoreService;

	@PostMapping("/trade")
	public ResponseEntity<String> tradeValidateStore(@RequestBody Trade trade) {

		tradeStoreService.saveTradeData(trade);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
