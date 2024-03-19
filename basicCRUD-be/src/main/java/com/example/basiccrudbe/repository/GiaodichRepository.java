package com.example.basiccrudbe.repository;

import com.example.basiccrudbe.entity.Giaodich;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GiaodichRepository extends CrudRepository<Giaodich, Long> {
    List<Giaodich> findAll();
    Optional<Giaodich> findById(Long id);

    void deleteById(Long id);
}
