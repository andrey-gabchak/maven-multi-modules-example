package com.gabchak.dto;

import java.util.Set;

public class WalletDto {
    private Integer id;
    private String name;
    private Double balance;
    private Boolean isIncome;
    private Boolean isCountInGeneralBalance;

    private Integer currencyId;

    private Set<Integer> records;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Boolean getIncome() {
        return isIncome;
    }

    public void setIncome(Boolean income) {
        isIncome = income;
    }

    public Boolean getCountInGeneralBalance() {
        return isCountInGeneralBalance;
    }

    public void setCountInGeneralBalance(Boolean countInGeneralBalance) {
        isCountInGeneralBalance = countInGeneralBalance;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Set<Integer> getRecords() {
        return records;
    }

    public void setRecords(Set<Integer> records) {
        this.records = records;
    }
}
