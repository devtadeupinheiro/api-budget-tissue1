package dev.tadeupinheiro.apibudgettissue.controller;

import dev.tadeupinheiro.apibudgettissue.dto.ElasticRecordDto;
import dev.tadeupinheiro.apibudgettissue.dto.ProductRecordDto;
import dev.tadeupinheiro.apibudgettissue.dto.TissueRecordDto;
import dev.tadeupinheiro.apibudgettissue.model.Product;
import dev.tadeupinheiro.apibudgettissue.model.ThreadRoll;
import dev.tadeupinheiro.apibudgettissue.service.ProductService;
import dev.tadeupinheiro.apibudgettissue.service.ThreadRollService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ThreadRollService threadRollService;

    @PostMapping
    public ResponseEntity<Product> saveProduct (@RequestBody @Valid ProductRecordDto productRecordDto, @RequestBody @Valid TissueRecordDto tissueRecordDto, @RequestBody @Valid ElasticRecordDto elasticRecordDto){
        var product = new Product();
        if (productService.existsByIdProduct(productRecordDto.idProduct())){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        else if (!threadRollService.existsByIdThread(productRecordDto.idThread())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        BeanUtils.copyProperties(productRecordDto, product); //EXCLUIR LINHA, DTO VAI TRAZER PRODUCT, TISSUE E ELASTIC JUNTO

        product.setIdProduct(productRecordDto.idProduct());
        product.setName(productRecordDto.name());
        product.setTissueConsumption(productRecordDto.tissueConsumption());

        //Calculation threadCost
        var threadRoll = threadRollService.findByIdThread(productRecordDto.idThread()).get();
        var threadCost = product.calculateThreadCost(threadRollService.costMetersCalculation(threadRoll.getCostPriceRoll(), threadRoll.getSize()));
        product.setCostThread(threadCost);

        //Calculation tissueCost
        var tissueCost = product.calculateTissueCost(tissueRecordDto.costPrice(), productRecordDto.tissueConsumption());
        product.setCostTissue(tissueCost);

        //Calculation elasticCost
        var elasticCost = product.calculateElasticCost(elasticRecordDto.costPrice(), productRecordDto.elasticConsumption());
        product.setCostElastic(elasticCost);

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts () {
        var productList = productService.findAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<Object> getOneProduct (@PathVariable(value = "idProduct") Integer idProduct) {
        Optional<Product> productOptional = this.productService.getOneProduct(idProduct);
        return productOptional.<ResponseEntity<Object>>map(product -> ResponseEntity.status(HttpStatus.FOUND).body(productOptional)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Get this product not is possible, because it not exist."));
    }
}
