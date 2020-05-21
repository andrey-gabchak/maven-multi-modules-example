package com.gabchak.dto;

import java.time.LocalDateTime;

public class RecordDto {

    private Integer id;
    private Double sum;
    private Boolean isIncome;
    private LocalDateTime dateTime;
    private String comment;

    private WalletDto wallet;
    private CategoryDto category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Boolean getIncome() {
        return isIncome;
    }

    public void setIncome(Boolean income) {
        isIncome = income;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public WalletDto getWallet() {
        return wallet;
    }

    public void setWallet(WalletDto wallet) {
        this.wallet = wallet;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}
