package dev.tadeupinheiro.apibudgettissue.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_THREADROLL_MODEL")
public class ThreadRoll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    private BigDecimal costPriceRoll;
    @NotNull
    private double size;
    @NotBlank
    private String type;
    @OneToMany
    private List<Product> product;

    public ThreadRoll(String name, String costPriceRoll, double size, String type) {
        this.name = name;
        this.costPriceRoll = new BigDecimal(costPriceRoll);
        this.size = size;
        this.type = type;
    }

    public ThreadRoll(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCostPriceRoll() {
        return costPriceRoll;
    }

    public void setCostPriceRoll(BigDecimal costPriceRoll) {
        this.costPriceRoll = costPriceRoll;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ThreadRoll threadRoll)) return false;

        //This "if" can be trade for logic be gived at the "return"
        if (this.name.equals(threadRoll.getName()) && this.type.equals(threadRoll.getType()) && this.costPriceRoll.equals(threadRoll.getCostPriceRoll())) {
            return true;
        } else {
            return false;
        }
    }
}
