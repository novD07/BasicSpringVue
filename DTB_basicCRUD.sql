CREATE DATABASE IF NOT EXISTS BasicCRUD;
USE BasicCRUD;

CREATE TABLE IF NOT EXISTS khachhang (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ten_khach_hang NVARCHAR(250) NOT NULL,
    sdt NVARCHAR(250) NOT NULL,
    email NVARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS loaidichvu (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ten_dich_vu NVARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS giaodich (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ma_giao_dich NVARCHAR(250) NOT NULL, 
    loai_dich_vu_id BIGINT,
    ngay_giao_dich DATE NOT NULL,
    don_gia INTEGER NOT NULL,
    dien_tich INT NOT NULL, 
    khach_hang_id BIGINT,
	FOREIGN KEY (khach_hang_id) REFERENCES khachhang(id),
    FOREIGN KEY (loai_dich_vu_id) REFERENCES loaidichvu(id)
);

SELECT * FROM basiccrud.khachhang;
SELECT * FROM basiccrud.giaodich;
SELECT * FROM basiccrud.loaidichvu;