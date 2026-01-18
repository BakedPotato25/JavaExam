
import java.util.Scanner;

public class Bai_5 {
    private static void giaiPT (double a, double b, double c) {
        // a = 0
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phuong trinh vo so nghiem!");
                } else {
                    System.out.println("Phuong trinh vo nghiem!");
                }
            } else {
                System.out.println("Phuong trinh co 1 nghiem duy nhat x = " + (-c / b));
            }
            return;
        }
        // a != 0
        double delta = b * b - 4 * a * c;
        System.out.println("Delta = " + delta);
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Phuong trinh co 2 nghiem phan biet:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("Phuong trinh co nghiem kep: x1 = x2 = " + x);
        } else {
            System.out.println("Phuong trinh vo nghiem (Delta < 0)");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        giaiPT(a, b, c);
    }
}
