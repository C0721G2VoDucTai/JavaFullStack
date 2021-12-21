package _examination.model;

public abstract class  SoTietKiem {
    private String maSo;
    private KhachHang khachHang;
    private String ngayMoSo;
    private String ngayBatDau;
    private double tienGui;
    private double laiSuat;

    public SoTietKiem() {
    }

    public SoTietKiem(String maSo, KhachHang khachHang, String ngayMoSo, String ngayBatDau,
                      double tienGui, double laiSuat) {
        this.maSo = maSo;
        this.khachHang = khachHang;
        this.ngayMoSo = ngayMoSo;
        this.ngayBatDau = ngayBatDau;
        this.tienGui = tienGui;
        this.laiSuat = laiSuat;

    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getNgayMoSo() {
        return ngayMoSo;
    }

    public void setNgayMoSo(String ngayMoSo) {
        this.ngayMoSo = ngayMoSo;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public double getTienGui() {
        return tienGui;
    }

    public void setTienGui(double tienGui) {
        this.tienGui = tienGui;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    @Override
    public String toString() {
        return "SoTietKiem{" +
                "maSo='" + maSo + '\'' +
                ", khachHang=" + khachHang +
                ", ngayMoSo='" + ngayMoSo + '\'' +
                ", ngayBatDau='" + ngayBatDau + '\'' +
                ", tienGui=" + tienGui +
                ", laiSuat=" + laiSuat +
                '}';
    }
}
