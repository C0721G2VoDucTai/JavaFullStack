package management;

import _examination.model.*;
import _examination.util.NotFoundSavingException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static _examination.util.CheckRegex.*;
import static _examination.util.DocGhiFile.*;
import static _examination.util.ReadAndWriteFile.readFile;

public class QuanLySoTietKiem implements Management {
    public static final String KH_PATH = "src\\_examination\\data\\kh_data.csv";
    public static final String DAI_HAN_PATH = "src\\_examination\\data\\sodaihan.csv";
    public static final String NGAN_HAN_PATH = "src\\_examination\\data\\songanhan.csv";
    Scanner sc = new Scanner(System.in);
    File fileDaiHan = new File(DAI_HAN_PATH);
    File fileNganHan = new File(NGAN_HAN_PATH);
    List< KhachHang > danhSachKhachHang = docFileKhachHang(KH_PATH);
    List< SoDaiHan > danhSachDaiHan = docDaiHan(DAI_HAN_PATH);
    List< SoVoHan > danhSachNganHan = docNganHan(NGAN_HAN_PATH);
    @Override
    public void them() {
        System.out.println("Chọn loai sổ tiết kiệm: \n" +
                " 1: Dài Hạn: \n" +
                " 2: Ngắn Hạn: \n");
        String choice = nhapLuaChon();
        switch (choice) {
            case "1":
                SoDaiHan soDaiHan = new SoDaiHan(nhapMaSo(), nhapMaKhach(), nhapNgayMo(),
                        nhapThoiGian(), Double.parseDouble(nhapTienGui()),
                        Double.parseDouble(nhapLai()), nhapKyDaiHan(), nhapUuDai());

                danhSachDaiHan.add(soDaiHan);
                fileDaiHan.delete();
                ghiDaiHan(danhSachDaiHan, DAI_HAN_PATH, true);
                break;
            case "2":
                System.out.println("Chọn loai sổ tiết kiệm: \n" +
                        " 1: Ngắn hạn: \n" +
                        " 2: Vô thời hạn: \n");
                choice = nhapLuaChon();
                switch (choice) {
                    case "1":
                        SoVoHan soNgaHan = new SoNganHan(nhapMaSo(), nhapMaKhach(), nhapNgayMo(),
                                nhapThoiGian(), Double.parseDouble(nhapTienGui()),
                                Double.parseDouble(nhapLai()), nhapKyNganHan());
                        danhSachNganHan.add(soNgaHan);
                        fileNganHan.delete();
                        ghiFileNganHan(danhSachNganHan, NGAN_HAN_PATH
                                , true);
                        break;
                    case "2":
                        SoVoHan soNgaHan1 = new SoVoHan(nhapMaSo(), nhapMaKhach(), nhapNgayMo(),
                                nhapThoiGian(), Double.parseDouble(nhapTienGui()),
                                Double.parseDouble(nhapLai()));
                        danhSachNganHan.add(soNgaHan1);
                        fileNganHan.delete();
                        ghiFileNganHan(danhSachNganHan, NGAN_HAN_PATH, true);
                        break;
                }
                break;
        }
    }

    @Override
    public void hienThi() {
        System.out.println("********DANH SÁCH SỔ*********");
        String choice;
        System.out.println("Chọn danh sách hiển thị : \n" +
                " 1: Sổ ngắn hạn: \n" +
                " 2: Sổ dài hạn: \n");
        choice = sc.nextLine();
        switch (choice) {
            case "1":
                hienthNganHan();
                break;
            case "2":
                hienThiDaiHan();
                break;
            default:
                break;
        }
    }

    public void hienThiDaiHan() {
        for (SoDaiHan ds : danhSachDaiHan) {
            System.out.println(ds.toString());
        }
    }

    public void hienthNganHan() {
        for (SoVoHan ds : danhSachNganHan) {
            System.out.println(ds.toString());
        }
    }
    @Override
    public void xoa() throws NotFoundSavingException {
        System.out.println("Nhập id cần xóa:");
        String choice;
        String id = sc.nextLine();
        for (int i = 0; i < (danhSachNganHan.size() + danhSachDaiHan.size()); i++) {
            if (id.equals(danhSachNganHan.get(i).getMaSo())) {
                System.out.println("Bạn có chắc muốn xóa : \n" +
                        " 1: Xóa: \n" +
                        " 2: Thoát: \n");
                choice = nhapLuaChon();
                switch (choice) {
                    case "1":
                        danhSachNganHan.remove(danhSachNganHan.get(i));
                        fileNganHan.delete();
                        ghiFileNganHan(danhSachNganHan, NGAN_HAN_PATH, true);
                        hienthNganHan();
                        break;
                    case "2":
                        break;
                }
            } else if (id.equals(danhSachDaiHan.get(i).getMaSo())) {
                System.out.println("Bạn có chắc muốn xóa : \n" +
                        " 1: Xóa: \n" +
                        " 2: Thoát: \n");
                choice = nhapLuaChon();
                switch (choice) {
                    case "1":
                        danhSachDaiHan.remove(danhSachDaiHan.get(i));
                        fileDaiHan.delete();
                        ghiDaiHan(danhSachDaiHan, DAI_HAN_PATH, true);
                        hienThiDaiHan();
                        break;
                    case "2":
                        break;
                }

            } else {
                throw new NotFoundSavingException("Không tìm thấy mã khách hàng:");
            }
        }
    }

    private String nhapLuaChon() {
        System.out.println("Nhập lựa chọn: ");
        String chon = sc.nextLine();
        return checkRegex(chon, CHOICE, "Lỗi nhập liệu Chọn 1 or 2");
    }

    private String nhapMaSo() {
        List<String> stringList = new ArrayList<>();
        stringList.addAll(readFile(NGAN_HAN_PATH));
        stringList.addAll(readFile(DAI_HAN_PATH));
        boolean check = true;
        String id;
        do {
            System.out.println("Enter id: ");
            id = sc.nextLine();
            id = checkRegex(id, ID_REGEX, "Wrong format," +
                    "please input like form: CI-1000");
            for (String list : stringList) {
                String [] temp = list.split(",") ;
                if (!id.equals(temp[0])) {
                    check = false;
                } else {
                    check = true;
                    System.out.println("Id is duplicate, please input other id: ");
                    break;
                }
            }
        } while (check);
        return id;
    }

    private KhachHang nhapMaKhach() {
        System.out.println("*********Danh Sach Khach Hang*******");
        for (int i = 0; i < danhSachKhachHang.size(); i++) {
            System.out.println((i + 1) + "," + danhSachKhachHang.get(i).toString());
        }
        System.out.println("Nhập thứ tự khách hàng muốn thêm");
        int index = Integer.parseInt(sc.nextLine());
        KhachHang khachHang = new KhachHang();
        khachHang = danhSachKhachHang.get(index - 1);
        return khachHang;
    }

    private String nhapNgayMo() {
        System.out.println("Nhập ngay mở sổ: ");
        String ngay = sc.nextLine();
        return checkRegex(ngay, DAY_REGEX, "Sai định dạng dd/MM/yyyy");
    }
    private String nhapThoiGian() {
        System.out.println("Nhập thời gian ");
        String thoiGian = sc.nextLine();
        return checkRegex(thoiGian, DAY_REGEX, "Sai định dạng dd/MM/yyyy");
    }

    private String nhapKyNganHan() {
        System.out.println("Nhap kỳ hạn: ");
        String kyHan = sc.nextLine();
        return checkRegex(kyHan, NGAN_HAN, "Kỳ hạn từ 3-6 tháng ví dụ: 6 Tháng");
    }

    private String nhapKyDaiHan() {
        System.out.println("Nhap kỳ hạn: ");
        String kyHan = sc.nextLine();
        return checkRegex(kyHan, DAI_HAN, "Kỳ hạn từ 3-6 tháng ví dụ: 6 Tháng");
    }

    private String nhapTienGui() {
        boolean check = true;
        String tienGui ="";
        while (check) {
            System.out.println("Enter tiền gửi: ");
            tienGui = sc.nextLine();
            if (Integer.parseInt(tienGui) > 1000000) {
                check = false;
            }
        }
        return tienGui;
    }

    private String nhapLai() {
        System.out.println("Nhâp lãi: ");
        String lai = sc.nextLine();
        return checkRegex(lai, INT_REGEX, "Tiền phải là số dương");
    }

    private String nhapUuDai() {
        System.out.println("Nhâp ưu đãi: ");
        String uuDai = sc.nextLine();
        return checkRegex(uuDai, NAME_REGEX, "Tên viết hoa chữ đầu");
    }
}

