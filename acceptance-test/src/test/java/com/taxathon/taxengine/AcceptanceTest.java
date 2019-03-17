package com.taxathon.taxengine;

import com.taxathon.taxengine.domain.UAEFeeCalculator;
import com.taxathon.taxengine.domain.FeeCalculator;
import com.taxathon.taxengine.domain.modal.Loan;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AcceptanceTest {

    @Test
    public void should_return_vat_calculated_for_bilateral_in_case_uae_lender_and_uae_borrower() {
        FeeCalculator uaeFeeCalculator = new UAEFeeCalculator();

        Loan loanFee = uaeFeeCalculator.calculate();
        Assertions.assertThat(loanFee).isNull();
    }

}
