package 入门;

import java.util.Scanner;

/**
 * <h1>选数</h1>
 *
 *
 *
 * <h2>题目描述</h2>
 * 已知 n 个整数 x_1,x_2,…,x_n，以及1个整数k
 * <p>
 * 从n个整数中任选k个整数相加，可分别得到一系列的和。例如当n=4,k=3,4个整数分别为3,7,12,19时，可得全部的组合与它们的和为：
 * <p>
 * 3+7+12=22
 * <p>
 * 3+7+19=29
 * <p>
 * 7+12+19=38
 * <p>
 * 3+12+19=34。
 * <p>
 * 现在，要求你计算出和为素数共有多少种。
 * <p>
 * 例如上例，只有一种的和为素数：3+7+19=29。
 */
public class 选数 {
    private static int[] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        array = new int[n];
        int k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            array[i] = num;
        }
        //选数
        System.out.println(selectNumber(k, 0, 0, n - 1));
    }

    /**
     * 选数
     *
     * @param remain 还剩几个数没选
     * @param sum    当前选的所有数之和
     * @param start  可以选择的数字起始下标
     * @return 质数返回1，否则返回0
     */
    private static int selectNumber(int remain, int sum, int start, int end) {
        if (remain == 0) {
            if (isPrime(sum)) {
                System.out.println(sum);
                return 1;
            }
            return 0;
        }
        int result = 0;
        for (int i = start; i <= end; i++) {
            result += selectNumber(remain - 1, sum + array[i], i + 1, end);
        }
        return result;
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
}
