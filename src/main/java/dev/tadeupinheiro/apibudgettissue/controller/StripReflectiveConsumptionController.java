package dev.tadeupinheiro.apibudgettissue.controller;

import dev.tadeupinheiro.apibudgettissue.dto.StripRecordDto;
import dev.tadeupinheiro.apibudgettissue.model.StripReflectiveConsumption;
import dev.tadeupinheiro.apibudgettissue.service.StripReflectiveConsumptionService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stripreflectiveconsumption")
public class StripReflectiveConsumptionController {

    @Autowired
    StripReflectiveConsumptionService stripReflectiveConsumptionService;

    @PostMapping
    public ResponseEntity saveStripReflectiveConsumption (@RequestBody @Valid StripRecordDto stripRecordDto){
        var stripReflectiveConsumption = new StripReflectiveConsumption();
        if (stripReflectiveConsumptionService.existsByIdStripReflective(stripRecordDto.idStripConfiguration())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("StripReflectiveConsumption already exists!");
        }
        BeanUtils.copyProperties(stripRecordDto, stripReflectiveConsumption);
        return ResponseEntity.status(HttpStatus.CREATED).body(stripReflectiveConsumptionService.saveStripReflectiveConsumption(stripReflectiveConsumption));
    }

    @GetMapping("/{idStripConsumption}")
    public ResponseEntity<Object> getOneStripConsumption(@PathVariable(value = "idStripConsumption") Integer idStripConsumption) {
        Optional<StripReflectiveConsumption> stripReflectiveConsumptionOptional = stripReflectiveConsumptionService.getOneStripReflectiveConsumption(idStripConsumption);
        if (stripReflectiveConsumptionOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Get the product not is possible, because it no exist.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(stripReflectiveConsumptionOptional.get());
    }

    @GetMapping
    public ResponseEntity<List<StripReflectiveConsumption>> getAllStripReflectiveConsumption (){
        return ResponseEntity.status(HttpStatus.OK).body(stripReflectiveConsumptionService.getAllStripReflectiveConsumption());
    }
}
