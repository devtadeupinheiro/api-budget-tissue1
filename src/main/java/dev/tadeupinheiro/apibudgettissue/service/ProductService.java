package dev.tadeupinheiro.apibudgettissue.service;

import dev.tadeupinheiro.apibudgettissue.model.Product;
import dev.tadeupinheiro.apibudgettissue.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<BigDecimal> paintingCalculation (int quantityColorsSmallPainting, int quantityColorsBigPainting, BigDecimal costColorBigPainting, BigDecimal costColorSmallPainting){

        BigDecimal costSmallPainting = costColorSmallPainting.multiply(BigDecimal.valueOf(quantityColorsSmallPainting));
        BigDecimal costBigPainting = costColorBigPainting.multiply(BigDecimal.valueOf(quantityColorsBigPainting));

        List<BigDecimal> total = new ArrayList<BigDecimal>();
        total.add(costBigPainting);
        total.add(costSmallPainting);
        return total;
    }

    public BigDecimal calculateThreadCost (Product product) {
        return new BigDecimal(0); //TERMINAR DEPOIS, FEITO SÓ PRA RODAR TESTE
    }

    public boolean existsByIdProduct (Integer idProduct){
        return this.productRepository.existsById(idProduct);
    }

    @Transactional
    public Product saveProduct (Product product){
        this.productRepository.save(product);
        return product;
    }

    public List<Product> findAllProducts () {
        List<Product> productList = this.productRepository.findAll();
        return  productList;
    }

    public Optional<Product> getOneProduct (Integer idProduct) {
        return this.productRepository.findById(idProduct);
    }

}
