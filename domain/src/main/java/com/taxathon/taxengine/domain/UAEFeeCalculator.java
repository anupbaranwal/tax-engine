package com.taxathon.taxengine.domain;

import com.taxathon.taxengine.domain.infra.FxRateCalculationRepository;
import com.taxathon.taxengine.domain.modal.Deal;
import com.taxathon.taxengine.domain.modal.DealType;
import com.taxathon.taxengine.domain.modal.Loan;

public class UAEFeeCalculator implements FeeCalculator {

    private FxRateCalculationRepository fxRateCalculator;
    private Loan loan;
    private Deal deal;

    public UAEFeeCalculator(){}

    public UAEFeeCalculator(Deal deal, FxRateCalculationRepository fxRateCalculator) {
        this.fxRateCalculator = fxRateCalculator;
        this.deal = deal;
    }


    @Override
    public Loan calculate() {
        loan = new Loan();
        double fxRate = fxRateCalculator.getRate(deal.getFeeType(), deal.getDateOfDeal());
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
