package dev.tadeupinheiro.apibudgettissue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class Tissue { //Está sem o entity porque não será administrado pelo spring, servirá somente pra receber uns dados, e depois é esquecido

    @NotNull
    private String color;

    @NotNull
    private BigDecimal costPrice;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
}
