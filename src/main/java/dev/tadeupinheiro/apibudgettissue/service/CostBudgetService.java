package dev.tadeupinheiro.apibudgettissue.service;

import dev.tadeupinheiro.apibudgettissue.model.Product;
import dev.tadeupinheiro.apibudgettissue.repository.CostBudgetRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CostBudgetService {

    final CostBudgetRepository costBudgetRepository;

    public CostBudgetService(CostBudgetRepository costBudgetRepository) {
        this.costBudgetRepository = costBudgetRepository;
    }

    public BigDecimal itemTotalCost (Product product) {
        var totalCost = new BigDecimal(0);
        totalCost.add(product.getButtonCost());
        totalCost.add(product.getFinishingCost());
        totalCost.add(product.getSewingCost());
        totalCost.add(product.getInterliningCost());
        totalCost.add(product.getCostThread());

        return totalCost;
    }
}
