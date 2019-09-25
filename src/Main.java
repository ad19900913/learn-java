import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] array = new int [26];
        for (int i = 0; i < 4; i++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (char aChar : chars) {
                if (aChar >= 65 && aChar <= 90) {
                    array[aChar - 65] += 1;
                }
            }
        }
        int max = 0;
        for (int i : array) {
            max = Math.max(i, max);
        }

        List<String> list = new ArrayList<>();
        for (int i = max; i > 0; i--) {
            StringBuilder builder = new StringBuilder();
            for (int i1 : array) {
                if (i1 >= i) {
                    builder.append("* ");
                } else {
                    builder.append("  ");
                }
            }
            list.add(builder.toString());
        }
        for (String s : list) {
            String substring = s.substring(0, s.lastIndexOf("*") + 1);
            System.out.println(substring);
        }
        System.out.println("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
    }
}
