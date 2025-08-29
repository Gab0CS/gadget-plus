package com.gabo.gadget_plus.enums;

public enum DateEval {
    AFTER("AFTER"), 
    BEFORE("BEFORE");

    private final String key;

    DateEval(String key){
        this.key = key;
    }

    public static String getKey(String key) {
        return key;
    }
}
