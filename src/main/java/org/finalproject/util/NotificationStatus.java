package org.finalproject.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.EnumUtils;


public enum NotificationStatus {
    pending("pending"),
    viewed("viewed");



    private final String val;

    NotificationStatus(String val) {
        this.val = val;
    }

    @JsonValue
    public String getValue() {
        return val;
    }

    @JsonCreator
    public static NotificationStatus forValue(String name) {
        return EnumUtils.getEnumMap(NotificationStatus.class).get(name);
    }
}


