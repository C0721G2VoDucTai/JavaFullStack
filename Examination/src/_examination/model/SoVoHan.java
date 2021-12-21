package _examination.model;

public class SoVoHan extends SoTietKiem{
    public SoVoHan() {
    }

    public SoVoHan(String maSo, KhachHang khachHang, String ngayMoSo, String ngayBatDau,
                   double tienGui, double laiSuat) {
        super(maSo, khachHang, ngayMoSo, ngayBatDau, tienGui, laiSuat);
    }

    @Override
    public String toString() {
        return "SoVoHan{} " + super.toString();
    }
    public String getThongTinVoHan() {
        return getMaSo() + "," + getKhachHang().getMaKhachHang() + "," + getNgayMoSo() + "," +
                getNgayBatDau() + "," + getTienGui() + "," + getLaiSuat();
    }
}
