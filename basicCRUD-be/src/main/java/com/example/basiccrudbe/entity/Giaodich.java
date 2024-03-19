package com.example.basiccrudbe.entity;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "giaodich")
public class Giaodich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String ma_giao_dich;

    @ManyToOne
    @JoinColumn(name = "loai_dich_vu_id")
    private Loaidichvu loai_dich_vu_id;

    @Column(nullable = false)
    private LocalDate ngay_giao_dich;

    @Column(nullable = false)
    private Integer don_gia;

    @Column(nullable = false)
    private Integer dien_tich;

    @ManyToOne
    @JoinColumn(name = "khach_hang_id")
    private Khachhang khach_hang_id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMa_giao_dich() {
        return ma_giao_dich;
    }

    public void setMa_giao_dich(String ma_giao_dich) {
        this.ma_giao_dich = ma_giao_dich;
    }

    public Loaidichvu getLoai_dich_vu_id() {
        return loai_dich_vu_id;
    }

    public void setLoai_dich_vu_id(Loaidichvu loai_dich_vu_id) {
        this.loai_dich_vu_id = loai_dich_vu_id;
    }

    public LocalDate getNgay_giao_dich() {
        return ngay_giao_dich;
    }

    public void setNgay_giao_dich(LocalDate ngay_giao_dich) {
        this.ngay_giao_dich = ngay_giao_dich;
    }

    public Integer getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(Integer don_gia) {
        this.don_gia = don_gia;
    }

    public Integer getDien_tich() {
        return dien_tich;
    }

    public void setDien_tich(Integer dien_tich) {
        this.dien_tich = dien_tich;
    }

    public Khachhang getKhach_hang_id() {
        return khach_hang_id;
    }

    public void setKhach_hang_id(Khachhang khach_hang_id) {
        this.khach_hang_id = khach_hang_id;
    }
}
