package com.example.basiccrudbe.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "khachhang")
public class Khachhang {

    @Id
    private Long id;

    @Column(nullable = false)
    private String tenkhachhang;

    @Column(nullable = false)
    private String sdt;

    @Column(nullable = false)
    private String email;
}
