package _examination.model;

public class SoDaiHan extends SoTietKiem {
    private String kyHan;
    private String uuDai;

    public SoDaiHan(String maSo, KhachHang khachHang, String ngayMoSo, String ngayBatDau, double tienGui,
                    double laiSuat, String kyHan, String uuDai) {
        super(maSo, khachHang, ngayMoSo, ngayBatDau, tienGui, laiSuat);
        this.kyHan = kyHan;
        this.uuDai = uuDai;
    }

    public SoDaiHan() {
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }

    @Override
    public String toString() {
        return "SoDaiHan{" +
                "kyHan='" + kyHan + '\'' +
                ", uuDai='" + uuDai + '\'' +
                "} " + super.toString();
    }
    public String getThongTinDaiHan() {
        return getMaSo() + "," + getKhachHang().getMaKhachHang() + "," + getNgayMoSo() + "," +
                getNgayBatDau() + "," + getTienGui() + "," + getLaiSuat()+ "," + kyHan+ "," + uuDai;
    }


}
