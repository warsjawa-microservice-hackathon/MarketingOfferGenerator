package com.ofg.loan;

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class MarketingOfferGenerator {

    @Autowired
    LoanApplicationRepository loanApplicationRepository

    public void save(String loanApplicationId, LoanApplication loanApplication) {
        log.info("Save loan {}.", loanApplicationId)
        loanApplication.setId(loanApplicationId)
        loanApplicationRepository.save(loanApplication)
    }

    LoanApplication get(String loanApplicationId) {
        log.info("Getting loan {}.", loanApplicationId)
        return loanApplicationRepository.findOne(loanApplicationId);
    }
}
