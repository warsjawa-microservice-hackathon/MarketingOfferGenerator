package com.ofg.loan;

import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class MarketingOfferGenerator {


    public void save(String loanApplicationId, LoanApplication loanApplication) {
        log.info("Save loan {}.", loanApplicationId)
    }

    LoanApplication get(String loanApplicationId) {
        log.info("Getting loan {}.", loanApplicationId)
        return null;
    }
}
