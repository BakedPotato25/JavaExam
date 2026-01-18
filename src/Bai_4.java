
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Bai_4 {
    private static void cach1 (String s) {
        boolean[] daDuyet = new boolean[65536];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!daDuyet[c] && c != ' ') {
                List<Integer> pos = new ArrayList<>();
                pos.add(i);
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == c) {
                        pos.add(j);
                    }
                }
                if (pos.size() > 1) {
                    System.out.println(c + ": " + pos.toString());
                }
                daDuyet[c] = true;
            }
        }
    }
    private static void cach2 (String s) {
        Map<Character, List<Integer>> mapKyTu = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (!mapKyTu.containsKey(c)) {
                mapKyTu.put(c, new ArrayList<>());
            }
            mapKyTu.get(c).add(i);
        }
        for (Map.Entry<Character, List<Integer>> entry : mapKyTu.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue().toString());
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        while (true) {
            input = sc.nextLine();
            if (input.length() >= 100 && input.length() <= 1000) {
                break;
            } else {
                System.out.println("Do dai chuoi phai nam trong khoang 100 den 1000!");
                System.out.println("Do dai chuoi hien tai la: " + input.length());
                System.out.println("Hay nhap lai chuoi");
            }
        }
        System.out.println("Cach 1: ");
        cach1(input);
        System.out.println("Cach 2: ");
        cach2(input);
    }
}
