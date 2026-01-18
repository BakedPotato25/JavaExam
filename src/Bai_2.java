
import java.util.Arrays;

public class Bai_2 {
    public static void main(String[] args) {
        try {
            int[] a = {2, 7, 6, 8, 9, 21, 34, 56, 32, 12, 37};

            // 1. Tim phan tu lon nhat trong mang
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println("Phan tu lon nhat: " + max);

            // 2. Tinh tong so dau tien va so cuoi cung
            int sum1 = a[0] + a[a.length - 1];
            System.out.println("Tong so dau va so cuoi: " + sum1);

            // 3. Tinh tong cac so chan trong mang
            int sum2 = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 2 == 0) {
                    sum2 += a[i];
                }
            }
            System.out.println("Tong cac so chan: " + sum2);

            // 4. Sap xep mang va ra danh sach sau khi xep
            Arrays.sort(a);
            System.out.println("Mang sau khi sap xep: " + Arrays.toString(a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
