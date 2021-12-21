package _examination.model;

public class SoNganHan extends SoVoHan {
    private String kyHan;

    public SoNganHan() {
    }

    public SoNganHan(String maSo, KhachHang khachHang, String ngayMoSo, String ngayBatDau, double tienGui,
                     double laiSuat, String kyHan) {
        super(maSo, khachHang, ngayMoSo, ngayBatDau, tienGui, laiSuat);
        this.kyHan = kyHan;
    }

    @Override
    public String toString() {
        return "SoNganHan{" +
                "kyHan='" + kyHan + '\'' +
                "} " + super.toString();
    }

    public String getThongTinNganHan() {
        return getMaSo() + "," + getKhachHang().getMaKhachHang() + "," + getNgayMoSo() + "," +
                getNgayBatDau() + "," + getTienGui() + "," + getLaiSuat() + "," + kyHan;
    }
}
