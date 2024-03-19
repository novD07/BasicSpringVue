package com.example.basiccrudbe.service;
import com.example.basiccrudbe.entity.Loaidichvu;
import com.example.basiccrudbe.repository.LoaidichvuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaidichvuService {
    @Autowired
    private LoaidichvuRepository loaidichvuRepository;
    public List<Loaidichvu> getAllServices(){
        return loaidichvuRepository.findAll();
    }
}
