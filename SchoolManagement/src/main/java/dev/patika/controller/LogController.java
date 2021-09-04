package dev.patika.controller;


import dev.patika.entity.Log;
import dev.patika.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LogController {

    LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/logs/{id}")
    public ResponseEntity<Log> findById(@PathVariable int id){
        return new ResponseEntity<>(logService.findById(id), HttpStatus.OK);
    }
}
