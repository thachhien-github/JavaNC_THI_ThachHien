package dao;

import context.DbContext;
import model.TheLoai;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TheLoaiDAO {

    public List<TheLoai> getAll() throws Exception {
        List<TheLoai> list = new ArrayList<>();
        String sql = "SELECT * FROM TheLoai";
        try (Connection conn = new DbContext().getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TheLoai tl = new TheLoai();
                tl.setMaloai(rs.getInt("MaLoai"));
                tl.setTenloai(rs.getString("TenLoai"));
                list.add(tl);
            }
        }
        return list;
    }

    public TheLoai getById(int id) throws Exception {
        String sql = "SELECT * FROM TheLoai WHERE MaLoai = ?";
        try (Connection conn = new DbContext().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TheLoai tl = new TheLoai();
                    tl.setMaloai(rs.getInt("MaLoai"));
                    tl.setTenloai(rs.getString("TenLoai"));
                    return tl;
                }
            }
        }
        return null;
    }
}
