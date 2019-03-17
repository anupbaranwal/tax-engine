package com.taxathon.taxengine.domain.modal;

import lombok.Data;

@Data
public class Participant {

    public Participant() {

    }

    public Participant(String name, int percentageShare, Resident participantResidence) {
        this.name = name;
        this.percentageShare = percentageShare;
        this.participantResidence = participantResidence;
    }

    private String name;
    private int percentageShare;
    private Resident participantResidence;
}
