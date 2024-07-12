package dev.tadeupinheiro.apibudgettissue.controller;

import dev.tadeupinheiro.apibudgettissue.dto.StripRecordDto;
import dev.tadeupinheiro.apibudgettissue.dto.StripReflectiveTypesDto;
import dev.tadeupinheiro.apibudgettissue.model.StripReflectiveConsumption;
import dev.tadeupinheiro.apibudgettissue.model.StripReflectiveTypes;
import dev.tadeupinheiro.apibudgettissue.repository.StripReflectiveTypesRepository;
import dev.tadeupinheiro.apibudgettissue.service.StripReflectiveConsumptionService;
import dev.tadeupinheiro.apibudgettissue.service.StripReflectiveTypesService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stripreflectivetypes")
public class StripReflectiveTypesController {


    @Autowired
    StripReflectiveTypesService stripReflectiveTypesService;

    @PostMapping
    public ResponseEntity<Object> saveStripReflectiveTypes (@RequestBody @Valid StripReflectiveTypesDto stripReflectiveTypesDto){
        var stripReflectiveTypes = new StripReflectiveTypes();
        BeanUtils.copyProperties(stripReflectiveTypesDto, stripReflectiveTypes);
        if (stripReflectiveTypesService.existsByAll(stripReflectiveTypes)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("StripReflectiveTypes already exists!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(stripReflectiveTypesService.saveStripReflectiveTypes(stripReflectiveTypes));
    }

    @GetMapping
    public ResponseEntity<List<StripReflectiveTypes>> getAllStripReflectiveTypes(){
        return ResponseEntity.status(HttpStatus.OK).body(stripReflectiveTypesService.findAllStripReflectiveTypes());
    }

    @GetMapping("/{idStripReflectiveTypes}")
    public ResponseEntity<Object> getOneStripReflectiveTypes (@PathVariable(value = "idStripReflectiveTypes") Integer idStripReflectiveTypes) {
        Optional<StripReflectiveTypes> stripReflectiveTypesOptional = stripReflectiveTypesService.getOneStripReflectiveTypes(idStripReflectiveTypes);
        /*if (stripReflectiveTypesOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Get the strip reflective types not is possible, because it no exist.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(stripReflectiveTypesOptional.get());*/
        //Usando map
        return stripReflectiveTypesOptional.<ResponseEntity<Object>>map(stripReflectiveTypes -> ResponseEntity.status(HttpStatus.FOUND).body(stripReflectiveTypes)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Get the strip reflective types not is possible, because it not exist."));
    }
}
