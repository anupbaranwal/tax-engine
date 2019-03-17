package com.taxathon.taxengine.domain.modal;

public enum DealType {
    BILATERAL("B"),
    AGENT("A"),
    PARTICIPANT("P");

    private String status;
    DealType(String status) {
        this.status= status;
    }

    public String getDealType() {
        return this.status;
    }

}

