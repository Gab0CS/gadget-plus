package com.gabo.gadget_plus.enums;

public enum LikeKey {
    AFTER("AFTER"), 
    BETWEEN("BETWEEN"), 
    BEFORE("BEFORE");

    private final String key;

    LikeKey(String key){
        this.key = key;
    }

    public static String getKey(String key) {
        return key;
    }
}
