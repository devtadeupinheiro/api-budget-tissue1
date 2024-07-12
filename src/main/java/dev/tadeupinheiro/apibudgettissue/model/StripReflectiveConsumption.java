package dev.tadeupinheiro.apibudgettissue.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "TB_STRIP_MODEL")
public class StripReflectiveConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStripConfiguration; //1
    @NotNull
    private double sleeve; //1
    @NotNull
    private double abdomenHorizontal; //2
    @NotNull
    private double abdomenUprightDual; //2
    @OneToMany(mappedBy = "stripReflectiveConsumption")
    private List<Product> productList;

    public Integer getIdStripConfiguration() {
        return idStripConfiguration;
    }

    public void setIdStripConfiguration(Integer idStripConfiguration) {
        this.idStripConfiguration = idStripConfiguration;
    }

    public double getSleeve() {
        return sleeve;
    }

    public void setSleeve(double sleeve) {
        this.sleeve = sleeve;
    }

    public double getAbdomenHorizontal() {
        return abdomenHorizontal;
    }

    public void setAbdomenHorizontal(double abdomenHorizontal) {
        this.abdomenHorizontal = abdomenHorizontal;
    }

    public double getAbdomenUprightDual() {
        return abdomenUprightDual;
    }

    public void setAbdomenUprightDual(double abdomenUprightDual) {
        this.abdomenUprightDual = abdomenUprightDual;
    }
}
