package dev.tadeupinheiro.apibudgettissue.model.model.output;

import java.math.BigDecimal;

public class StripReflectiveTypesOutPut {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Long width;
    private String typeTreatment;
    private String typeMaterial;

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

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
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
}
