package dev.tadeupinheiro.apibudgettissue.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class CostBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //AUTO

    @NotNull
    private BigDecimal otherCosts;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    //Ver se a anotação abaixo serve
    //@JoinTable(name = "costbudget_product", joinColumns = @JoinColumn(name = "costbudget_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Product product;

    @NotNull
    private BigDecimal tax;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    private StripReflectiveTypes stripReflectiveTypes;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY)
    private List<Painting> paintings; //It is a list because it will have more than one per product


}
