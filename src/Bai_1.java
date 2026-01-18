import java.util.Scanner;

public class Bai_1 {
    public static boolean checkNguyenTo(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            while (n <= 0) {
                n = sc.nextInt();
            }
            // 1. So le
            for (int i = 1; i <= n; i++) {
                if (i % 2 != 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();

            // 2. So chan
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();

            // 3. In ra day so nguyen to co trong day tu 1 den n
            for (int i = 1; i <= n; i++) {
                if (checkNguyenTo(i)) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();

            // 4. In ra day so fibonacci co trong day so tu 1 den n
            int f0 = 0;
            int f1 = 1;
            if (n >= 1) System.out.print("1 ");
            int next = f0 + f1;
            while (next <= n) {
                System.out.print(next + " ");
                f0 = f1;
                f1 = next;
                next = f0 + f1;
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
