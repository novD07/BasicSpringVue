package com.example.basiccrudbe.controller;

import com.example.basiccrudbe.entity.Loaidichvu;
import com.example.basiccrudbe.service.LoaidichvuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/loaidichvu")
public class LoaidichvuController {
    @Autowired
    private LoaidichvuService loaidichvuService;

    @GetMapping("")
    public ResponseEntity<List<Loaidichvu>> getAllServices(){
        try{
            List<Loaidichvu> addServices = loaidichvuService.getAllServices();
            if(!addServices.isEmpty()){
                return ResponseEntity.ok(addServices);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
 }
