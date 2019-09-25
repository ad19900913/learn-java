package 入门;

import java.util.Scanner;

/**
 * 整数、小鼠、分数、百分数的反转，去除前缀无用的0，去除小数部分后缀无用的0
 */
public class 数字反转 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.contains(".")) {
            String[] strings = s.split("\\.");
            char[] chars = strings[1].toCharArray();
            int length = chars.length;
            String fractional = "";
            if (length > 1) {
                int index = 0;
                for (int i = 0; i < length; i++) {
                    if (chars[i] != '0') {
                        break;
                    }
                    index++;
                }
                if (index >= 0) {
                    fractional = new StringBuilder(strings[1].substring(index)).reverse().toString();
                    fractional = "".equals(fractional) ? "0" : fractional;
                }
            } else {
                fractional = strings[1];
            }
            System.out.println(Long.parseLong(new StringBuilder(strings[0]).reverse().toString()) + "." + fractional);
        } else if (s.contains("%")) {
            String[] strings = s.split("%");
            System.out.println(Long.parseLong(new StringBuilder(strings[0]).reverse().toString()) + "%");
        } else if (s.contains("/")) {
            String[] strings = s.split("/");
            System.out.println(Long.parseLong(new StringBuilder(strings[0]).reverse().toString()) + "/" + Long.parseLong(new StringBuilder(strings[1]).reverse().toString()));
        } else {
            System.out.println(Long.parseLong(new StringBuilder(s).reverse().toString()));
        }

    }

}
