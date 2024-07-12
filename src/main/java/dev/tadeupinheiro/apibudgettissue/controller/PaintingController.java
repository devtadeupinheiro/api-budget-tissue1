package dev.tadeupinheiro.apibudgettissue.controller;

import dev.tadeupinheiro.apibudgettissue.dto.PaintingRecordDto;
import dev.tadeupinheiro.apibudgettissue.model.Painting;
import dev.tadeupinheiro.apibudgettissue.model.model.output.PaintingOutPut;
import dev.tadeupinheiro.apibudgettissue.service.PaintingService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paintings")
public class PaintingController {

    @Autowired
    PaintingService paintingService;

    @PostMapping
    public ResponseEntity savePainting (@RequestBody @Valid PaintingRecordDto paintingRecordDto){
        var painting = new Painting();
        if (paintingService.existsByIdPainting(paintingRecordDto.id())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Painting already exists!");
        }
        BeanUtils.copyProperties(paintingRecordDto, painting);
        var paintingOutPut = new PaintingOutPut();
        BeanUtils.copyProperties(paintingRecordDto, paintingOutPut); //Show only painting information, without the relationship
        paintingService.savePainting(painting);
        return ResponseEntity.status(HttpStatus.CREATED).body(paintingOutPut);
    }

    @GetMapping
    public ResponseEntity<List<Painting>> findAllPaintings () {
        var paintingList = this.paintingService.findAllPaintings();
        return ResponseEntity.status(HttpStatus.OK).body(paintingList);
    }
}
