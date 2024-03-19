package com.example.basiccrudbe.repository;


import com.example.basiccrudbe.entity.Giaodich;
import com.example.basiccrudbe.entity.Loaidichvu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaidichvuRepository extends CrudRepository<Loaidichvu, Long> {
    List<Loaidichvu> findAll();
}
