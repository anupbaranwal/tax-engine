package com.taxathon.taxengine.jpa;

import com.taxathon.taxengine.jpa.entity.FxRate;
import org.springframework.data.jpa.repository.JpaRepository;

interface FxRateDao extends JpaRepository<FxRate, String> {
    FxRate findByFeeTypeAndDateOfDeal(String feeType, String dateOfDeal);
}
