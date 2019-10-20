package 入门;

import java.util.Scanner;

/**
 * 回文质数 Prime Palindromes
 */
public class 回文质数 {

    /**
     * 程序加速依赖以下结论：
     * 偶数位回文数都可以被11整除
     * 偶数都不是质数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        a = (a % 2 == 0) ? a + 1 : a;
        b = Math.min(b, 10000000);
        for (int i = a; i < b; i += 2) {
            if (1000 < i && i < 10000) {
                i = 10001;
                continue;
            }
            if (100000 < i && i < 1000000) {
                i = 1000001;
                continue;
            }
            if (i != 2 && i != 3 && i != 5 && (i % 2 == 0 || i % 3 == 0 || i % 5 == 0)) {
                continue;
            }
            if (isPalindrome(i) && isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * 判断某数是否为素数
     *
     * @param n
     * @return
     */
    private static boolean isPrime(int n) {
        int max = (int) Math.sqrt(n);
        for (int i = 2; i <= max; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断某数是否是回文数
     *
     * @param i
     * @return
     */
    public static boolean isPalindrome(int i) {
        int x = i;
        int y = 0;
        boolean ret = false;
        while (x != 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }

        if (y == i) {
            ret = true;
        }
        return ret;
    }

}
