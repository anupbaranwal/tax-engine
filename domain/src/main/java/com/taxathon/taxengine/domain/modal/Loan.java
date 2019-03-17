package com.taxathon.taxengine.domain.modal;

import lombok.Data;

@Data
public class Loan {

    private Double fee;
    private Double vat;
    private String lenderName;
    private int percentageShare;
    private String dealType;
}
