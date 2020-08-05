CREATE DATABASE QLPhanMemTiKi

GO
USE QLPhanMemTiKi
GO

CREATE TABLE DanhGia(
	MaDanhGia VARCHAR(4) NOT NULL PRIMARY KEY,
	MaLoaiSanPham VARCHAR(4) NOT NULL,
	Sao INT NOT NULL,
	NoiDung NVARCHAR(200) NULL DEFAULT N''
)

CREATE TABLE SanPham(
	MaSanPham VARCHAR(4) NOT NULL PRIMARY KEY,
	TenSanPham NVARCHAR(70) NOT NULL,
	PhanTramGiamGia TINYINT NOT NULL,
	GiaGoc FLOAT NOT NULL,
	GiaSauKhiGiam FLOAT NOT NULL,
	MaDanhGia VARCHAR(4) NOT NULL,
	PhanTramTraGop TINYINT NOT NULL,
	NgayNhap DATE NOT NULL,
	MaLoaiSanPham NVARCHAR(4)
)

CREATE TABLE LoaiSanPham(
	MaLoaiSanPham VARCHAR(4) NOT NULL PRIMARY KEY,
	TenLoaiSanPham NVARCHAR(70) NOT NULL,
	MoTa NVARCHAR(200) DEFAULT N''
)

CREATE TABLE ThongTinSP(
	MaThongTin VARCHAR(4) NOT NULL PRIMARY KEY,
	MaSanPham VARCHAR(4) NOT NULL,
    XuatSu NVARCHAR(30) NOT NULL,
	NgayHetHan DATE NOT NULL,
	CongDung NVARCHAR(100) NULL DEFAULT N''
)

CREATE TABLE GioHang(
	MaGioHang INT NOT NULL PRIMARY KEY
	,MaSanPham VARCHAR(4) NOT NULL
	,TenSanPham NVARCHAR(70) NOT NULL
	,PhanTramGiamGia TINYINT NOT NULL
	,GiaGoc FLOAT NOT NULL
	,GiaSauKhiGiam FLOAT NOT NULL
	,SoLuong INT NOT NULL
	,TongTien FLOAT NOT NULL
)

-------------------------------
-------------------------------

ALTER TABLE SanPham
ADD CONSTRAINT FK_SanPham_DanhGia FOREIGN KEY (MaDanhGia) REFERENCES DanhGia(MaDanhGia)

ALTER TABLE SanPham
ADD CONSTRAINT CK_GiaGoc_LonHon0 CHECK (GiaGoc > 0)

ALTER TABLE SanPham
ADD CONSTRAINT CK_PhanTramGiamGia_LonHon_0_NhoHon_101 CHECK (PhanTramGiamGia > 0 OR PhanTramGiamGia < 101 )

ALTER TABLE SanPham
ADD CONSTRAINT CK_GiaSauKhiGiam_LonHon_0 CHECK (GiaSauKhiGiam > 0)

ALTER TABLE SanPham
ADD CONSTRAINT CK_PhamTramTraGop_LonHon_0_NhoHon_101 CHECK (PhanTramTraGop > 0 OR PhanTramTraGop < 101)

-----------------------
-----------------------

ALTER TABLE GioHang
ADD CONSTRAINT CK_SoLuong_LonHon_0 CHECK (SoLuong > 0)

ALTER TABLE GioHang 
ADD CONSTRAINT CK_TongTien_LonHon_0 CHECK (TongTien > 0)

ALTER TABLE GioHang
ADD CONSTRAINT FK_GioHang_SanPham FOREIGN KEY (MaSanPham) REFERENCES SanPham(MaSanPham)

------------------------
------------------------

ALTER TABLE ThongTinSP
ADD CONSTRAINT CK_NgayHetHan_NhoHon_NgayHienTai CHECK (NgayHetHan < GETDATE())

ALTER TABLE ThongTinSP
ADD CONSTRAINT FK_ThongTinSP_SanPham FOREIGN KEY (MaSanPham) REFERENCES SanPham(MaSanPham)

------------------------
------------------------

ALTER TABLE DanhGia
ADD CONSTRAINT CK_Sao_LonHon0_NhoHon_6 CHECK (Sao > 0 OR Sao < 6)

ALTER TABLE DanhGia
ADD CONSTRAINT FK_DanhGia_LoaiSanPham FOREIGN KEY (MaLoaiSanPham) REFERENCES LoaiSanPham(MaLoaiSanPham)

------------------------
------------------------




