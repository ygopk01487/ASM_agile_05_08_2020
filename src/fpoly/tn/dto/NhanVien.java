/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.dto;

import java.util.Date;

/**
 *
 * @author TRINH THE NAM
 */
public class NhanVien {
 int MaNhanVien;
    String TenNhanVien;
    String DiaChi;
    String SoDienThoai;
    boolean GioiTinh;
    String ChucVu;
    Date NgaySinh;
    Date NgayVaoLam;
    String TenDangNhap;
    String MatKhau;

    public NhanVien() {
        
    }

    public NhanVien(int MaNhanVien, String TenNhanVien, String DiaChi, String SoDienThoai, boolean GioiTinh, String ChucVu, Date NgaySinh, Date NgayVaoLam, String TenDangNhap, String MatKhau) {
        this.MaNhanVien = MaNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.GioiTinh = GioiTinh;
        this.ChucVu = ChucVu;
        this.NgaySinh = NgaySinh;
        this.NgayVaoLam = NgayVaoLam;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public Date getNgayVaoLam() {
        return NgayVaoLam;
    }

    public void setNgayVaoLam(Date NgayVaoLam) {
        this.NgayVaoLam = NgayVaoLam;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public NhanVien(String TenNhanVien, String DiaChi, String SoDienThoai, boolean GioiTinh, String ChucVu, Date NgaySinh, Date NgayVaoLam, String TenDangNhap, String MatKhau) {
        this.TenNhanVien = TenNhanVien;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.GioiTinh = GioiTinh;
        this.ChucVu = ChucVu;
        this.NgaySinh = NgaySinh;
        this.NgayVaoLam = NgayVaoLam;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
    }

    
    
}
