package com.taxathon.taxengine.domain.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
public enum Resident {
    UAE_RESIDENT(1),
    NON_UAE_RESIDENT(2);

    @Getter
    private final int residenceStatus;
}
