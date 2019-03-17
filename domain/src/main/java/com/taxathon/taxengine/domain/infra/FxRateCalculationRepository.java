package com.taxathon.taxengine.domain.infra;

public interface FxRateCalculationRepository {
    double getRate(String feeType, String dateOfDeal);
}
