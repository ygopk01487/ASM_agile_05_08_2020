/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.bll;

import fpoly.tn.dal.dal_NhanVien;
import fpoly.tn.dto.NhanVien;
import fpoly.tn.helper.ThongBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TRINH THE NAM
 */
public class bll_NhanVien {

    public static Boolean KiemTraThongTin(String TenDangNhap, String MatKhau) {
        if (TenDangNhap.isBlank() || MatKhau.isBlank()) {
            ThongBao.ThpngBaoDonGian("Lỗi đăng nhập", "Chưa nhập thành công");
            return false;
        }
        if (TenDangNhap.length() < 5) {
            ThongBao.ThpngBaoDonGian("Lỗi đăng nhập", "Tên đăng nhập ít nhất phải 6 ký tự");
            return false;
        }
        if (MatKhau.length() < 5) {
            ThongBao.ThpngBaoDonGian("Lỗi đăng nhập", "Mật khẩu ít phải 6 ký tự");
            return false;
        }
        return true; //Nếu không bị lỗi ở trên thì trẩ về true

    }

    public static String LoGin(String TenDangNhap, String MatKhau) {
        try {
            ResultSet rs = dal_NhanVien.login2(TenDangNhap, MatKhau);
            if (rs.next()) {
                return TenDangNhap;
            }
        } catch (SQLException ex) {
            Logger.getLogger(bll_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            ThongBao.ThpngBaoDonGian("Thông báo", "Lỗi đăng nhập");
        }
        return "";
    }

    public static Boolean KiemTranv(NhanVien nv) {
        if (nv.getTenNhanVien().isBlank()) {
            ThongBao.ThpngBaoDonGian("Thông Báo", "Bạn chưa Nhập Tên nhân Viên  ");
        }
        if (nv.getTenNhanVien().length() < 6) {
            ThongBao.ThpngBaoDonGian("!!!", "Tên nhân Viên Tối THiểu 6 ký tự ");
            return false;
        }
        return true;
    }

    public static void Them(NhanVien nv) {
        // Gọi Hàm Kiểm tra Nv 

        Boolean KiemTranv = KiemTranv(nv);

        if (KiemTranv) {
            dal_NhanVien.Them(nv);
        }

        // nếu thành cppng thì thực hiện thêm nv 
    }

}
