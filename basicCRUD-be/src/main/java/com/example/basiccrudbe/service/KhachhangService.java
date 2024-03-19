package com.example.basiccrudbe.service;

import com.example.basiccrudbe.entity.Khachhang;
import com.example.basiccrudbe.repository.KhachhangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachhangService {
    @Autowired
    private KhachhangRepository khachhangRepository;
    public List<Khachhang> getAllCustomers(){
        return khachhangRepository.findAll();
    }
}
