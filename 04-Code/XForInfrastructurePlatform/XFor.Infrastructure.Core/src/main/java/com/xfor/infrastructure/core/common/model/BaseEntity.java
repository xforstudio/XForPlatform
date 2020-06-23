package com.xfor.infrastructure.core.common.model;

import lombok.Data;

@Data
public class BaseEntity {

    public static String _newSID() {
        return SID._newSID();
    }

    public BaseEntity() {
    }
}
