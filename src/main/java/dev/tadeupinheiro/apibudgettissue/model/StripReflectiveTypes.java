package dev.tadeupinheiro.apibudgettissue.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_STRIP_REF_TYPES")
public class StripReflectiveTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //auto

    @NotBlank
    @Size(max = 30)
    private String name; //GloboMec

    @NotNull
    @Positive
    private BigDecimal price; //1.15

    @NotNull
    private Float width; //5

    @NotBlank
    @Size(max = 6)
    private String typeTreatment; //if flame retardant or normal

    @NotBlank
    @Size(max = 60)
    private String typeMaterial; //if gorgurao, sitellfill or other

    @ManyToMany(mappedBy = "stripReflectiveTypes", fetch = FetchType.LAZY)
    private List<CostBudget> costBudgets;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public String getTypeTreatment() {
        return typeTreatment;
    }

    public void setTypeTreatment(String typeTreatment) {
        this.typeTreatment = typeTreatment;
    }

    public String getTypeMaterial() {
        return typeMaterial;
    }

    public void setTypeMaterial(String typeMaterial) {
        this.typeMaterial = typeMaterial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StripReflectiveTypes stripReflectiveTypes)) return false; //Made the cast automatically

        if (this.name.equals(stripReflectiveTypes.getName()) && this.price.equals(stripReflectiveTypes.getPrice()) && this.width.equals(stripReflectiveTypes.getWidth()) && this.typeTreatment.equals(stripReflectiveTypes.getTypeTreatment()) && this.typeMaterial.equals(stripReflectiveTypes.getTypeMaterial())){
            return true;
        } else {
            return false;
        }
    }

}
