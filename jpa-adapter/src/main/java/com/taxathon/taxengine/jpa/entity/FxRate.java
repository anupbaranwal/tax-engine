package com.taxathon.taxengine.jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table( name = "T_FX_RATE")
public class FxRate {

    @Id
    @Column(name="id")
    private Long id;

    @Column(name = "FEE_TYPE")
    private String feeType;

    @Column(name="RATE")
    private double rate;

    @Column(name="DATE_OF_DEAL")
    private String dateOfDeal;

}
