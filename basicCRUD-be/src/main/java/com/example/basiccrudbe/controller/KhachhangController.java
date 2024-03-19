package com.example.basiccrudbe.controller;
import com.example.basiccrudbe.entity.Khachhang;
import com.example.basiccrudbe.service.KhachhangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/khachhang")
public class KhachhangController {

    @Autowired
    private KhachhangService khachhangService;

    @GetMapping("")
    public ResponseEntity<List<Khachhang>> getAllCustomers(){
        try {
            List<Khachhang> allKhachhang = khachhangService.getAllCustomers();

            if(!allKhachhang.isEmpty()){
                return ResponseEntity.ok(allKhachhang);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
