package com.example.basiccrudbe.service;

import com.example.basiccrudbe.dto.ThemGiaoDich;
import com.example.basiccrudbe.entity.*;
import com.example.basiccrudbe.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiaodichService {

    @Autowired
    private GiaodichRepository giaodichRepository;

    @Autowired
    private LoaidichvuRepository loaidichvuRepository;

    @Autowired
    private KhachhangRepository khachhangRepository;

    public List<Giaodich> getAllTrans(){
        return giaodichRepository.findAll();
    }

    public void deleteById(Long id){
        giaodichRepository.deleteById(id);
    }

    public void addNewTransaction (ThemGiaoDich themGiaoDich){
        Giaodich giaodich = new Giaodich();
        giaodich.setMa_giao_dich(themGiaoDich.getMa_giao_dich());
        giaodich.setLoai_dich_vu_id(themGiaoDich.getLoai_dich_vu_id());
        giaodich.setNgay_giao_dich(themGiaoDich.getNgay_giao_dich());
        giaodich.setDon_gia(themGiaoDich.getDon_gia());
        giaodich.setDien_tich(themGiaoDich.getDien_tich());
        giaodich.setKhach_hang_id(themGiaoDich.getKhach_hang_id());

        giaodichRepository.save(giaodich);
    }
}
