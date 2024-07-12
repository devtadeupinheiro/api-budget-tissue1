package dev.tadeupinheiro.apibudgettissue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Painting {

    @Id
    @NotNull
    private Integer id; //Quantity of colors

    @NotBlank
    private String size; //P

    @NotNull
    @Positive
    private BigDecimal price; //0.70

    @ManyToMany(mappedBy = "paintings", fetch = FetchType.LAZY)
    private List<CostBudget> costBudgets;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<CostBudget> getCostBudgets() {
        return costBudgets;
    }

    public void setCostBudgets(List<CostBudget> costBudgets) {
        this.costBudgets = costBudgets;
    }
}
