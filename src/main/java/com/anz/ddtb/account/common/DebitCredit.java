package com.anz.ddtb.account.common;

public enum DebitCredit {

    Debit("Debit"),
    Credit("Credit");

    private String value;
    DebitCredit(String value){
        this.value = value;
    }

    public String value(){
        return this.value;
    }

}
