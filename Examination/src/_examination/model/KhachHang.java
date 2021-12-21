package _examination.model;

public class KhachHang {
    private String maKhachHang;
    private String ten;
    private String ngaySinh;
    private String gioiTinh;
    private String dienThoai;
    private String diaChi;

    public KhachHang(String maKhachHang, String ten, String ngaySinh, String gioiTinh, String dienThoai,
                     String diaChi) {
        this.maKhachHang = maKhachHang;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.diaChi = diaChi;
    }

    public KhachHang() {
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKhachHang='" + maKhachHang + '\'' +
                ", ten='" + ten + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", dienThoai='" + dienThoai + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }

    public String getThongTinKhach() {
        return maKhachHang + "," + ten + "," + ngaySinh + "," + gioiTinh + "," + dienThoai + "," + diaChi;
    }
}
