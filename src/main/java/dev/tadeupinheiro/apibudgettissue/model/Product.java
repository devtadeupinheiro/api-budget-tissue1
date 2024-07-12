package dev.tadeupinheiro.apibudgettissue.model;

import dev.tadeupinheiro.apibudgettissue.repository.ThreadRollRepository;
import dev.tadeupinheiro.apibudgettissue.service.ThreadRollService;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Entity
@Table(name = "TB_PRODUCT_MODEL")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    @NotBlank
    private String name; //BT ABERTA ML SIMPLES
    @NotNull
    private List<Float> tissueConsumption; //1.35
    @NotNull
    private Float threadConsumption; //100
    @NotNull
    private Float elasticConsumption; //0.9
    @NotNull
    private BigDecimal costThread; //RESULT OF  calculateThreadCost METHOD
    @NotNull
    private BigDecimal costTissue; //RESULT OF calculateTissueCost METHOD
    @NotNull
    private BigDecimal costElastic; //RESULT OF calculateElasticCost METHOD
    @NotNull
    private BigDecimal buttonCost;
    @NotNull
    private BigDecimal sewingCost;
    @NotNull
    private BigDecimal finishingCost;
    @NotNull
    private BigDecimal interliningCost;
    @NotBlank
    @ManyToOne
    private ThreadRoll idThread; //BIG50
    @ManyToOne
    @JoinColumn(name = "stripconfig", nullable = false)
    private StripReflectiveConsumption stripReflectiveConsumption; //1 (id of configuration or models)
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "striptypes", nullable = false)
    private StripReflectiveTypes stripReflectiveTypes; //1 (id of types)

    @ManyToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<CostBudget> costBudgets;


    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Float> getTissueConsumption() {
        return tissueConsumption;
    }

    public void setTissueConsumption(List<Float> tissueConsumption) {
        this.tissueConsumption = tissueConsumption;
    }

    public Float getThreadConsumption() {
        return threadConsumption;
    }

    public void setThreadConsumption(Float threadConsumption) {
        this.threadConsumption = threadConsumption;
    }

    public Float getElasticConsumption() {
        return elasticConsumption;
    }

    public void setElasticConsumption(Float elasticConsumption) {
        this.elasticConsumption = elasticConsumption;
    }

    public ThreadRoll getIdThread() {
        return idThread;
    }

    public void setIdThread(ThreadRoll idThread) {
        this.idThread = idThread;
    }

    public BigDecimal getCostThread() {
        return costThread;
    }

    public void setCostThread(BigDecimal costThread) {
        this.costThread = costThread;
    }

    public BigDecimal getCostTissue() {
        return costTissue;
    }

    public void setCostTissue(BigDecimal costTissue) {
        this.costTissue = costTissue;
    }

    public BigDecimal getCostElastic() {
        return costElastic;
    }

    public void setCostElastic(BigDecimal costElastic) {
        this.costElastic = costElastic;
    }

    public BigDecimal getButtonCost() {
        return buttonCost;
    }

    public void setButtonCost(BigDecimal buttonCost) {
        this.buttonCost = buttonCost;
    }

    public BigDecimal getSewingCost() {
        return sewingCost;
    }

    public void setSewingCost(BigDecimal sewingCost) {
        this.sewingCost = sewingCost;
    }

    public BigDecimal getFinishingCost() {
        return finishingCost;
    }

    public void setFinishingCost(BigDecimal finishingCost) {
        this.finishingCost = finishingCost;
    }

    public BigDecimal getInterliningCost() {
        return interliningCost;
    }

    public void setInterliningCost(BigDecimal interliningCost) {
        this.interliningCost = interliningCost;
    }

    public List<CostBudget> getCostBudgets() {
        return costBudgets;
    }

    public void setCostBudgets(List<CostBudget> costBudgets) {
        this.costBudgets = costBudgets;
    }

    public StripReflectiveConsumption getStripReflectiveConsumption() {
        return stripReflectiveConsumption;
    }

    public void setStripReflectiveConsumption(StripReflectiveConsumption stripReflectiveConsumption) {
        this.stripReflectiveConsumption = stripReflectiveConsumption;
    }

    public StripReflectiveTypes getStripReflectiveTypes() {
        return stripReflectiveTypes;
    }

    public void setStripReflectiveTypes(StripReflectiveTypes stripReflectiveTypes) {
        this.stripReflectiveTypes = stripReflectiveTypes;
    }

    public BigDecimal calculateThreadCost (BigDecimal costPricePerMeter){
        return costPricePerMeter.multiply(new BigDecimal(this.threadConsumption)).setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal calculateTissueCost (BigDecimal tissueCost, Float tissueConsumption) {
        return tissueCost.multiply(new BigDecimal(tissueConsumption)).setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal calculateElasticCost (BigDecimal elasticCost, Float elasticConsumption) {
        return elasticCost.multiply(new BigDecimal(elasticConsumption)).setScale(2, RoundingMode.CEILING);
    }

}
