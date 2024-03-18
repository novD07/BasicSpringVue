package com.example.basiccrudbe.entity;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "giaodich")
public class Giaodich {

    @Id
    private Long id;

    @Column(nullable = false)
    private String idgiaodich;

    @Column(nullable = false)
    private String idloaidichvu;

    @Column(nullable = false)
    private LocalDate ngaygiaodich;

    @Column(nullable = false)
    private Integer dongia;

    @Column(nullable = false)
    private Integer dientich;

    @Column(nullable = false)
    private Long idkhachhang;

}
