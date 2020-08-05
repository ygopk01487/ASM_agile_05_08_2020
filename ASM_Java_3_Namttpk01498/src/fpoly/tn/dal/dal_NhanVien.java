/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.dal;

import fpoly.tn.dto.NhanVien;
import fpoly.tn.helper.ChuyenDoi;
import fpoly.tn.helper.dbconnection;
import fpoly.tn.helper.sql_helper;
import java.sql.ResultSet;

/**
 *
 * @author TRINH THE NAM
 */
public class dal_NhanVien {

    //Lấy toàn bộ nhân viên
    public static ResultSet GetAllNhanVien() {
        String sql = "Select * from NhanVien";
        return dbconnection.ExecuteQuerySelect(sql);
    }

    public static ResultSet loadDaTaSach() {
        String sql = "Select * from NhanVien";
        return dbconnection.ExecuteQuerySelect(sql);
    }

    public static int ThemNVMoi(String TenNV, String DiaChi, int GioiTinh, String SDT, String ChucVu, String NgaySinh, String NgayVaoLam, String TenDangNhap, String MatKhau) {
        String sql = "INSERT INTO [dbo].[NhanVien] "
                + "           ([TenNhanVien] "
                + "           ,[DiaChi] "
                + "           ,[SoDienThoai] "
                + "           ,[GioiTinh] "
                + "           ,[ChucVu] "
                + "           ,[NgaySinh] "
                + "           ,[NgayVaoLam] "
                + "           ,[TenDangNhap] "
                + "           ,[MatKhau]) "
                + "     VALUES "
                + "           ( N'" + TenNV + "' "
                + "           ,N'" + DiaChi + "' "
                + "           ," + SDT + ""
                + "           ," + GioiTinh + ""
                + "           ,N'" + ChucVu + "' "
                + "           ,'" + NgaySinh + "'"
                + "           ,'" + NgayVaoLam + "'"
                + "           ," + TenDangNhap + ""
                + "            ," + MatKhau + ")";

        return dbconnection.ExecuteQueryUpdate(sql);
    }

    public static int xoasach(String MaNhanVien) {
        String sql = "delete from NhanVien where MaNhanVien = '" + MaNhanVien + "'";

        return dbconnection.ExecuteQueryUpdate(sql);
    }

    public static int SuaNV(String TenNV, String DiaChi, int GioiTinh, String SDT, String MaNhanVien) {
        String sql = "set dateformat dmy "
                + "UPDATE [dbo].[NhanVien] "
                + "   SET "
                + "[TenNhanVien] = N'" + TenNV + "' "
                + "      ,[DiaChi] = N'" + DiaChi + "' "
                + "      ,[SoDienThoai] =    " + SDT
                + "      ,[GioiTinh] = '0' "
                + "      ,[ChucVu] = N'Nhân Viên' "
                + "      ,[NgaySinh] = '02/07/2000' "
                + "      ,[NgayVaoLam] ='02/01/2019' "
                + "      ,[TenDangNhap] = 'Null' "
                + "      ,[MatKhau] =  'Null' "
                + "WHERE MaNhanVien = '" + MaNhanVien + "' ";
        return dbconnection.ExecuteQueryUpdate(sql);
    }

    public static ResultSet login2(String TenDangNhap, String Matkhau) {
        String sql = "Select * from NhanVien "
                + "Where TenDangNhap = ? and Matkhau= ? ";
        return sql_helper.executeQuery(sql, TenDangNhap, Matkhau);
    }

    public static void Them(NhanVien nv) {
        String sql = "Set dateformat DMY "
                + "INSERT INTO [dbo].[NhanVien] "
                + "           ([TenNhanVien] "
                + "           ,[DiaChi] "
                + "           ,[SoDienThoai] "
                + "           ,[GioiTinh] "
                + "           ,[ChucVu] "
                + "           ,[NgaySinh] "
                + "           ,[NgayVaoLam] "
                + "           ,[TenDangNhap] "
                + "           ,[MatKhau]) "
                + "     VALUES "
                + "           (?,?,?,?,?,?,?,?,?)";

        sql_helper.executeUpdate(sql,
                nv.getTenNhanVien(),
                nv.getDiaChi(),
                nv.getSoDienThoai(),
                nv.isGioiTinh(),
                nv.getChucVu(), 
                ChuyenDoi.LayNgayString(nv.getNgaySinh()), 
                ChuyenDoi.LayNgayString(nv.getNgayVaoLam()), 
                nv.getTenDangNhap(), 
                nv.getMatKhau());
    }

}
