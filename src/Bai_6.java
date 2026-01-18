import Bai6.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai_6 {
    private static void nhapDuLieuSinhVien() {
        System.out.println("Hay nhap so luong sinh vien: ");
        int n = 0;
        try {
            n = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            n = 0;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin ung vien thu " + (i + 1));
            try {
                String fullName = "";
                while (true) {
                    System.out.println("Ho ten: (10 - 50 ky tu): ");
                    fullName = sc.nextLine();
                    if (fullName.length() >= 10 && fullName.length() <= 50) break;
                    System.out.println("Ten qua ngan hoac qua dai. Nhap lai!");
                }

                String phone = "";
                while (true) {
                    System.out.println("So dien thoai: ");
                    phone = sc.nextLine();
                    if (Pattern.matches("^(090|098|091|031|035|038)\\d{7}$", phone)) break;
                    System.out.println("SDT phai bat dau bang 090, 098, 091, 031, 035 hoac 038 va du 10 so!");
                }

                System.out.println("Ngay sinh (dd/MM/yyyy): ");
                String dob = sc.nextLine();
                System.out.println("Gioi tinh: " );
                String sex = sc.nextLine();
                System.out.println("Truong Dai hoc: ");
                String uni = sc.nextLine();
                System.out.println("Xep loai to nghiep (Gioi/Kha/TB): ");
                String grade = sc.nextLine();

                if (grade.equalsIgnoreCase("Gioi") || grade.equalsIgnoreCase("Kha")) {
                    System.out.println("Nhap GPA (thang 10): ");
                    double gpa = Double.parseDouble(sc.nextLine());
                    System.out.println("Ten giai thuong/Hoc bong: ");
                    String reward = sc.nextLine();
                    listCandidates.add(new GoodStudent(fullName, dob, sex, phone, uni, grade, gpa, reward));
                } else {
                    System.out.println("Nhap diem TOEIC: ");
                    int toeic = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhap diem thi dau vao (Entry Score): ");
                    double entry = Double.parseDouble(sc.nextLine());
                    listCandidates.add(new NormalStudent(fullName, dob, sex, phone, uni, grade, toeic, entry));
                }
            } catch (Exception e) {
                System.out.println("Loi nhap lieu: " + e.getMessage());
                System.out.println("Bo qua ung vien nay.");
            }
        }
    }
    private static void xuLyTuyenSinh(int count) {
        List<GoodStudent> goodStudents = new ArrayList<>();
        List<NormalStudent> normalStudents = new ArrayList<>();

        for (Student s : listCandidates) {
            if (s instanceof GoodStudent) goodStudents.add((GoodStudent) s);
            else if (s instanceof NormalStudent) normalStudents.add((NormalStudent) s);
        }
        
        Collections.sort(goodStudents, new Comparator<GoodStudent>() {
            @Override
            public int compare(GoodStudent o1, GoodStudent o2) {
                int compareGPA = Double.compare(o2.getGpa(), o1.getGpa());
                if (compareGPA != 0) return compareGPA;
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });

        Collections.sort(normalStudents, new Comparator<NormalStudent>() {
            @Override
            public int compare(NormalStudent o1, NormalStudent o2) {
                int cEntry = Double.compare(o2.getEntryTestScore(), o1.getEntryTestScore());
                if (cEntry != 0) return cEntry;

                int cEnglish = Integer.compare(o2.getEnglishScore(), o1.getEnglishScore());
                if (cEnglish != 0) return cEnglish;

                return o1.getFullName().compareTo(o2.getFullName());
            }
        });
        List<Student> selected = new ArrayList<>();
        for (GoodStudent gs : goodStudents) {
            if (selected.size() < count) selected.add(gs);
        }
        for (NormalStudent ns : normalStudents) {
            if (selected.size() < count) selected.add(ns);
        }
        System.out.println("\nDanh sach trung tuyen (" + selected.size() + "/" +  count + ")");
        for (Student s : selected) {
            s.showMyInfo();
        }
    }
    static Scanner sc = new Scanner(System.in);
    static List<Student> listCandidates = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("CHUONG TRINH QUAN LY VIEC TUYEN SINH");
        nhapDuLieuSinhVien();
        System.out.println("BAT DAU TUYEN SINH");
        int soLuongCanTuyen = 0;
        while (true) {
            System.out.println("Nhap so luong can tuyen (11 - 15): ");
            try {
                soLuongCanTuyen = Integer.parseInt(sc.nextLine().trim());
                if (soLuongCanTuyen >= 11 && soLuongCanTuyen <= 15) break;
                System.out.println("Vui long nhap tu 11 den 15!");
            } catch (Exception e) {
                System.out.println("Nhap so nguyen hop le!");
            }
        }
        xuLyTuyenSinh(soLuongCanTuyen);
    }   
}
