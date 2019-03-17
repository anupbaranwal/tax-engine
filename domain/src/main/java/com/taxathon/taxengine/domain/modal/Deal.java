package com.taxathon.taxengine.domain.modal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Deal {

    public Deal(){}

    public Deal(String dealType, Participant participant, double amount,
                String dateOfDeal, String feeType, String dealCurrency, Resident borrowerResidence) {
        this.dealType = dealType;
        this.participant = participant;
        this.amount = amount;
        this.dateOfDeal = dateOfDeal;
        this.feeType = feeType;
        this.dealCurrency = dealCurrency;
        this.borrowerResidence = borrowerResidence;
    }

    private String dealType;
    private Participant participant;
    private double amount;
    private String dateOfDeal;
    private String feeType;
    private String dealCurrency;
    private Resident borrowerResidence;

}
