package com.gabchak.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "is_income")
    private Boolean isIncome;
    @Column(name = "is_count_in_general_balance")
    private Boolean isCountInGeneralBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_currency_id")
    private Currency currency;

    @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY)
    private Set<Record> records;

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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }
}
