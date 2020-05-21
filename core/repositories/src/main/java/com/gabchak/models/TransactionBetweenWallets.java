package com.gabchak.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_between_wallets")
@PrimaryKeyJoinColumn(name = "id")
public class TransactionBetweenWallets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "income_sum")
    private Double incomeSum;
    @Column(name = "expenditure_sum")
    private Double expendirureSum;
    @Column(name = "commission")
    private Double commision;
    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "fk_income_wallet")
    private Wallet incomeWallet;
    @ManyToOne
    @JoinColumn(name = "fk_expenditure_wallet")
    private Wallet expenditureWallet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getIncomeSum() {
        return incomeSum;
    }

    public void setIncomeSum(Double incomeSum) {
        this.incomeSum = incomeSum;
    }

    public Double getExpendirureSum() {
        return expendirureSum;
    }

    public void setExpendirureSum(Double expendirureSum) {
        this.expendirureSum = expendirureSum;
    }

    public Double getCommision() {
        return commision;
    }

    public void setCommision(Double commision) {
        this.commision = commision;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Wallet getIncomeWallet() {
        return incomeWallet;
    }

    public void setIncomeWallet(Wallet incomeWallet) {
        this.incomeWallet = incomeWallet;
    }

    public Wallet getExpenditureWallet() {
        return expenditureWallet;
    }

    public void setExpenditureWallet(Wallet expenditureWallet) {
        this.expenditureWallet = expenditureWallet;
    }
}
