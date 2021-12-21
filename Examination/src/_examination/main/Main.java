package _examination.main;

import _examination.util.NotFoundSavingException;
import management.QuanLySoTietKiem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLySoTietKiem quanLy = new QuanLySoTietKiem();
        Scanner scr = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Danh sach lựa chọn\n" +
                    "1. Thêm \n" +
                    "2. Hiển thị \n" +
                    "3. Xóa \n" +
                    "4. Thoát");
            try {
                System.out.println("nhập lựa chọn");
                int selection = Integer.parseInt(scr.nextLine());
                switch (selection) {
                    case 1:
                        quanLy.them();
                        break;
                    case 2:
                        quanLy.hienThi();

                        break;
                    case 3:
                        quanLy.xoa();

                        break;
                    case 4:
                        flag = false;
                        break;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }catch (NotFoundSavingException e) {
                System.out.println("Không tìm thấy mã xóa");
            }
        }
    }
}
