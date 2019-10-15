package 入门;

import java.util.Scanner;

/**
 * <h1>火柴棒等式</h1>
 *
 *
 *
 * <h2>题目描述</h2>
 *     <div>给你n根火柴棍，你可以拼出多少个形如“A+B=C”的等式？等式中的A、B、C是用火柴棍拼出的整数（若该数非零，则最高位不能是0）。用火柴棍拼数字0-9的拼法如图所示：
 * <p>
 *  ![](https://cdn.luogu.com.cn/upload/pic/49.png)
 * <p>
 * 注意：
 * <p>
 * 1. 加号与等号各自需要两根火柴棍
 * <p>
 * 2. 如果A≠B，则A+B=C与B+A=C视为不同的等式(A,B,C>=0)
 * <p>
 * 3. n根火柴棍必须全部用上
 * </div>
 *
 *     <h2>输入输出格式</h2>
 *     <h3>输入格式</h3>
 *     <br />
 *     <div>一个整数n(n<=24)。
 * </div>
 *     <h3>输出格式</h3>
 *     <br />
 *     <div>一个整数，能拼成的不同等式的数目。
 * </div>
 */
public class 火柴棒等式 {

    private static int temp[] = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (stick(i) + stick(j) + stick(i + j) + 4 == n) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }

    /**
     * 返回需要多少火柴
     *
     * @param i
     * @return
     */
    private static int stick(int i) {
        if (i == 0) {
            return 6;
        }
        int sum = 0;
        while (i > 0) {
            sum += temp[i % 10];
            i /= 10;
        }
        return sum;
    }

}
