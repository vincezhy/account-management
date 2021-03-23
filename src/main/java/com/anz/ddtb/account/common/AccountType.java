package com.anz.ddtb.account.common;

public enum AccountType {

    Savings("Savings"),
    Current("Current");

    private String value;
    AccountType(String value){
        this.value = value;
    }

    public String value(){
        return this.value;
    }

}
