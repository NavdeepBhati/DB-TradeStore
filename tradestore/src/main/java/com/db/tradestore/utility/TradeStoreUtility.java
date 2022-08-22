package com.db.tradestore.utility;

import java.time.LocalDate;
import java.util.Optional;

import com.db.tradestore.model.Trade;


public class TradeStoreUtility {
	
	/*
	 * Method to validate the maturity date and version of a trade
	 */
    public static boolean isValid(Optional<Trade> existingTrade, Trade incomingTrade){
    	
    	
        if(validateMaturityDate(incomingTrade)) {
        	
             if (existingTrade.isPresent()) {
                 return validateVersion(incomingTrade, existingTrade.get());
             }else{
                 return true;
             }
         }
         return false;
    }

    /*
	 * Method to validate the version of a trade
	 * where the current trade version must be greater than or equal to 
	 * already existing one
	 */
    public static boolean validateVersion(Trade incomingTrade,Trade existingTrade) {
        if(incomingTrade.getVersion() >= existingTrade.getVersion()){
            return true;
        }
        return false;
    }

    /*
	 * Method to validate the maturity date
	 * returns true if maturity date is before current date
	 * returns false otherwise
	 */
    public static boolean validateMaturityDate(Trade incomingTrade){
        return incomingTrade.getMaturityDate().isBefore(LocalDate.now())  ? false:true;
    }


}
