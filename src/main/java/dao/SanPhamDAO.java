package dao;

import context.DbContext;
import model.SanPham;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {

    // 6 sản phẩm khuyến mãi theo DonGia giảm dần
    public List<SanPham> get6KhuyenMai() throws Exception {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT TOP 6 * FROM SanPham WHERE KhuyenMai = 1 ORDER BY DonGia DESC";

        try (Connection conn = new DbContext().getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMasp(rs.getInt("MaSP"));
                sp.setTensp(rs.getString("TenSP"));
                sp.setDongia(rs.getDouble("DonGia"));
                sp.setHinh(rs.getString("Hinh"));
                sp.setMaloai(rs.getInt("MaLoai"));
                sp.setNgaycapnhat(rs.getTimestamp("NgayCapNhat"));
                sp.setKhuyenmai(rs.getBoolean("KhuyenMai"));
                list.add(sp);
            }
        }
        return list;
    }

    public List<SanPham> getByMaLoai(int maloai) throws Exception {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham WHERE MaLoai = ? ORDER BY MaSP";
        try (Connection conn = new DbContext().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maloai);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setMasp(rs.getInt("MaSP"));
                    sp.setTensp(rs.getString("TenSP"));
                    sp.setDongia(rs.getDouble("DonGia"));
                    sp.setHinh(rs.getString("Hinh"));
                    sp.setMaloai(rs.getInt("MaLoai"));
                    sp.setNgaycapnhat(rs.getTimestamp("NgayCapNhat"));
                    sp.setKhuyenmai(rs.getBoolean("KhuyenMai"));
                    list.add(sp);
                }
            }
        }
        return list;
    }
}
