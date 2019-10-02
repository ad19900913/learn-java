import java.util.Scanner;

public class Main {
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
        int total = 0;
        for (int i = 0; i <= n - k; i++) {
            total += selectNumber(k, 0, i, n - 1);
        }
        System.out.println(total);
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
        for (int i = 2; i < max; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
