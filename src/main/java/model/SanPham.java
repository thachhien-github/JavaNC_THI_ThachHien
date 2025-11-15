package model;

import java.sql.Timestamp;

public class SanPham {

    private int masp;
    private String tensp;
    private double dongia;
    private String hinh;
    private int maloai;
    private Timestamp ngaycapnhat;
    private boolean khuyenmai;

    public SanPham() {
    }

    public SanPham(int masp, String tensp, double dongia, String hinh, int maloai, Timestamp ngaycapnhat, boolean khuyenmai) {
        this.masp = masp;
        this.tensp = tensp;
        this.dongia = dongia;
        this.hinh = hinh;
        this.maloai = maloai;
        this.ngaycapnhat = ngaycapnhat;
        this.khuyenmai = khuyenmai;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public Timestamp getNgaycapnhat() {
        return ngaycapnhat;
    }

    public void setNgaycapnhat(Timestamp ngaycapnhat) {
        this.ngaycapnhat = ngaycapnhat;
    }

    public boolean isKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(boolean khuyenmai) {
        this.khuyenmai = khuyenmai;
    }

    @Override
    public String toString() {
        return tensp + " - " + dongia;
    }
}
