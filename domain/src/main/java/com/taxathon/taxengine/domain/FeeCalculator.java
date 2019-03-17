package com.taxathon.taxengine.domain;

import com.taxathon.taxengine.domain.modal.Deal;
import com.taxathon.taxengine.domain.modal.Loan;

public interface FeeCalculator {
    Loan calculate(Deal deal);
}
