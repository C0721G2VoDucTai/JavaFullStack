package _examination.util;

import _examination.model.KhachHang;
import _examination.model.SoDaiHan;
import _examination.model.SoNganHan;
import _examination.model.SoVoHan;

import java.util.ArrayList;
import java.util.List;

import static _examination.util.ReadAndWriteFile.readFile;
import static _examination.util.ReadAndWriteFile.writeFile;
import static management.QuanLySoTietKiem.KH_PATH;

public class DocGhiFile {
    public static List< SoVoHan > docNganHan(String path) {
        List< String > stringList = readFile(path);
        List< SoVoHan > soVoHanList = new ArrayList<>();
        List< KhachHang > khachHangList = docFileKhachHang(KH_PATH);
        for (String string : stringList) {
            String[] temp = string.split(",");
            KhachHang khachHang1 = new KhachHang();
            for (KhachHang khachHang : khachHangList) {
                if (khachHang.getMaKhachHang().equals(temp[1])) {
                    khachHang1 = khachHang;
                }
            }
            if (soVoHanList.size() == 6) {
                SoVoHan soVoHan = new SoVoHan(temp[0], khachHang1, temp[2], temp[3],
                        Double.parseDouble(temp[4]), Double.parseDouble(temp[5]));
                soVoHanList.add(soVoHan);
            } else {
                SoVoHan receipt = new SoNganHan(temp[0], khachHang1, temp[2], temp[3],
                        Double.parseDouble(temp[4]), Double.parseDouble(temp[5]), temp[6]);
                soVoHanList.add(receipt);
            }
        }
        return soVoHanList;
    }

    public static List< SoDaiHan > docDaiHan(String path) {
        List< String > stringList = readFile(path);
        List< SoDaiHan > soDaiHanList = new ArrayList<>();
        List< KhachHang > khachHangList = docFileKhachHang(KH_PATH);
        for (String string : stringList) {
            String[] temp = string.split(",");
            KhachHang khachHang1 = new KhachHang();
            for (KhachHang khachHang : khachHangList) {
                if (khachHang.getMaKhachHang().equals(temp[1])) {
                    khachHang1 = khachHang;
                }
            }
            SoDaiHan soDaiHan = new SoDaiHan(temp[0], khachHang1, temp[2], temp[3],
                    Double.parseDouble(temp[4]), Double.parseDouble(temp[5]), temp[6], temp[7]);
            soDaiHanList.add(soDaiHan);
        }
        return soDaiHanList;
    }

    public static List< KhachHang > docFileKhachHang(String path) {
        List< String > stringList = readFile(path);
        List< KhachHang > khachHangList = new ArrayList<>();
        for (String string : stringList) {
            String[] temp = string.split(",");
            KhachHang khachHang = new KhachHang(temp[0], temp[1], temp[2], temp[3],
                    temp[4], temp[5]);
            khachHangList.add(khachHang);
        }
        return khachHangList;
    }
    public static void ghiFileNganHan(List< SoVoHan > soVoHanList, String path, boolean append) {
        List< String > stringList = new ArrayList<>();
        for (SoVoHan soVoHan : soVoHanList) {
            if (soVoHan instanceof SoNganHan) {
                stringList.add(((SoNganHan) soVoHan).getThongTinNganHan());
            } else {
                stringList.add(soVoHan.getThongTinVoHan());
            }
        }
        writeFile(stringList, path, append);
    }

    public static void ghiDaiHan(List< SoDaiHan > daiHanList, String path, boolean append) {
        List< String > stringList = new ArrayList<>();
        for (SoDaiHan soDaiHan : daiHanList) {
            stringList.add(soDaiHan.getThongTinDaiHan());
        }
        writeFile(stringList, path, append);
    }

}
