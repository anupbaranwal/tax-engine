package com.taxathon.taxengine;

import com.taxathon.taxengine.domain.UAEFeeCalculator;
import com.taxathon.taxengine.domain.FeeCalculator;
import com.taxathon.taxengine.domain.infra.FxRateCalculationRepository;
import com.taxathon.taxengine.domain.modal.Deal;
import com.taxathon.taxengine.domain.modal.Loan;
import com.taxathon.taxengine.domain.modal.Participant;
import com.taxathon.taxengine.domain.modal.Resident;
import com.taxathon.taxengine.jpa.FxRateCalculationAdapter;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

public class AcceptanceTest {

    @Test
    public void should_return_vat_calculated_for_bilateral_in_case_uae_lender_and_uae_borrower() {
        FxRateCalculationRepository rateCalculator = Mockito.mock(FxRateCalculationAdapter.class);

        Deal deal = Deal.builder().dealType("B").amount(34000).dealCurrency("INR").borrowerResidence(Resident.UAE_RESIDENT)
                .participant(new Participant("SocgenDubai", 100, Resident.UAE_RESIDENT)).build();
        double fxRate = 4.5;
        double expectedFee = deal.getAmount();
        double expectedVat = (deal.getAmount()/100)*5 * fxRate;

        Mockito.when(rateCalculator.getRate(deal.getFeeType(), deal.getDateOfDeal())).thenReturn(fxRate);
        FeeCalculator uaeFeeCalculator = new UAEFeeCalculator(deal, rateCalculator);

        Loan loanFee = uaeFeeCalculator.calculate();
        Assertions.assertThat(loanFee.getFee()).isEqualTo(expectedFee);
        Assertions.assertThat(loanFee.getVat()).isEqualTo(expectedVat);
    }

}
