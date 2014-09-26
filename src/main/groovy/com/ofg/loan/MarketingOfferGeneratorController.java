package com.ofg.loan;

import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/marketing")
@Api(value = "marketingOfferGenerator", description = "Manages Loan marketing offers")
class MarketingOfferGeneratorController {

    private MarketingOfferGenerator marketingOfferGenerator;

    @Autowired
    MarketingOfferGeneratorController(MarketingOfferGenerator marketingOfferGenerator) {
        this.marketingOfferGenerator = marketingOfferGenerator;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{loanApplicationId}", consumes = "application/json")
    ResponseEntity saveLoan(@PathVariable("loanApplicationId") String loanApplicationId,
                                      @RequestBody LoanApplication loanApplication) {
        marketingOfferGenerator.save(loanApplicationId, loanApplication);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{loanApplicationId}", produces = "application/json")
    ResponseEntity<LoanApplication> getLoan(@PathVariable("loanApplicationId") String loanApplicationId) {
        LoanApplication loanApplication = marketingOfferGenerator.get(loanApplicationId);
        if (loanApplication == null) {
            return new ResponseEntity<>(loanApplication, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(loanApplication, HttpStatus.OK);
    }
}