package com.taxathon.taxengine.jpa;

import com.taxathon.taxengine.domain.infra.FxRateCalculationRepository;
import com.taxathon.taxengine.jpa.entity.FxRate;

public class FxRateCalculationAdapter implements FxRateCalculationRepository {

    private FxRateDao fxRateDao;

    @Override
    public double getRate(String feeType, String dateOfDeal) {
        FxRate fxRate = fxRateDao.findByFeeTypeAndDateOfDeal(feeType, dateOfDeal);
        return fxRate.getRate();
    }
}
