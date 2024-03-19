package com.example.basiccrudbe.dto;

import com.example.basiccrudbe.entity.Khachhang;
import com.example.basiccrudbe.entity.Loaidichvu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddGiaoDich {
    private Long id;
    private String ma_giao_dich;
    private Loaidichvu loai_dich_vu_id;
    private LocalDate ngay_giao_dich;
    private Integer don_gia;
    private Integer dien_tich;
    private Khachhang khach_hang_id;
}
