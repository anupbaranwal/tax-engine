package com.taxathon.taxengine.domain;

import com.taxathon.taxengine.domain.modal.Loan;

public class UAEFeeCalculator implements FeeCalculator {

    private Loan loan;

    @Override
    public Loan calculate() {
        return loan;
    }
}
