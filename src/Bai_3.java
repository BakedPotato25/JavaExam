
import java.util.Scanner;

public class Bai_3 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String isbn = sc.nextLine();
            if (isbn.length() != 10) {
                return;
            }
            long sum = 0;
            int w = 10;
            for (int i = 0; i < 10; i++) {
                char c = isbn.charAt(i);
                int digit = Integer.parseInt(String.valueOf(c));
                sum += digit * w;
                w--;
            }
            System.out.println("Tong cua so ISBN: " + sum);
            if (sum % 11 == 0) {
                System.out.println("So " + isbn + " la so ISBN");
            } else {
                System.out.println("So " + isbn + " khong phai la so ISBN");
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
