package dev.tadeupinheiro.apibudgettissue.controller;

import dev.tadeupinheiro.apibudgettissue.dto.ThreadRollRecordDto;
import dev.tadeupinheiro.apibudgettissue.model.ThreadRoll;
import dev.tadeupinheiro.apibudgettissue.service.ThreadRollService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thread")
public class ThreadRollController {

    @Autowired
    ThreadRollService threadRollService;

    @PostMapping
    public ResponseEntity<Object> saveThreadRoll (@RequestBody @Valid ThreadRollRecordDto threadRollRecordDto) {
        var threadRoll = new ThreadRoll();
        BeanUtils.copyProperties(threadRollRecordDto, threadRoll);

        if (threadRollService.existsByAll(threadRoll)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("ThreadRoll already exists!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(threadRollService.saveThreaRoll(threadRoll));
    }

    @GetMapping
    public ResponseEntity<List<ThreadRoll>> getAllThreadRolls () {
        return ResponseEntity.status(HttpStatus.OK).body(this.threadRollService.getAllThreadRolls());
    }
}
