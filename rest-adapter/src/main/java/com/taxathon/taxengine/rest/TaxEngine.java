package com.taxathon.taxengine.rest;


import com.taxathon.taxengine.domain.FeeCalculator;
import com.taxathon.taxengine.domain.modal.Deal;
import com.taxathon.taxengine.domain.modal.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taxengine")
public class TaxEngine {

    @Autowired
    private FeeCalculator uaeFeeCalculator;

    @PostMapping("/tax")
    public Loan calculateTax(@RequestBody Deal deal) {
        return uaeFeeCalculator.calculate(deal);
    }
}
