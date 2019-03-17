package com.taxathon.taxengine.domain;

import com.taxathon.taxengine.domain.infra.FxRateCalculationRepository;
import com.taxathon.taxengine.domain.modal.Deal;
import com.taxathon.taxengine.domain.modal.DealType;
import com.taxathon.taxengine.domain.modal.Loan;
import org.springframework.beans.factory.annotation.Autowired;

public class UAEFeeCalculator implements FeeCalculator {

    @Autowired
    private FxRateCalculationRepository fxRateCalculationAdapter;

    public UAEFeeCalculator(){}

    public UAEFeeCalculator(FxRateCalculationRepository fxRateCalculationAdapter) {
        this.fxRateCalculationAdapter = fxRateCalculationAdapter;
    }


    @Override
    public Loan calculate(Deal deal) {
        Loan loan = new Loan();
        double fxRate = fxRateCalculationAdapter.getRate(deal.getFeeType(), deal.getDateOfDeal());
        if(DealType.BILATERAL.getDealType().equalsIgnoreCase(deal.getDealType())) {
            loan.setFee(deal.getAmount());
            loan.setDealType(DealType.BILATERAL.getDealType());
            loan.setLenderName(deal.getParticipant().getName());
            loan.setPercentageShare(100);
            loan.setVat(calculateVat(deal.getAmount())*fxRate);
        }
        return loan;
    }

    private double calculateVat(double fee) {
        return (fee/100)*5;
    }
}
