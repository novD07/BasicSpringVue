package com.example.basiccrudbe.repository;

import com.example.basiccrudbe.entity.Giaodich;
import com.example.basiccrudbe.entity.Khachhang;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachhangRepository extends CrudRepository<Khachhang, Long>{
    List<Khachhang> findAll();
}
