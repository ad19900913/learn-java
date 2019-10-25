package 入门;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *     <h2>题目描述</h2>
 *     <div>现在请你编一个程序验证哥德巴赫猜想。
 *
 * 先给出一个奇数n，要求输出3个质数，这3个质数之和等于输入的奇数。
 * </div>
 *
 *     <h2>输入输出格式</h2>
 *     <h3>输入格式</h3>
 *     <br />
 *     <div>仅有一行，包含一个正奇数n，其中9<n<20000
 * </div>
 *     <h3>输出格式</h3>
 *     <br />
 *     <div>仅有一行，输出3个质数，这3个质数之和等于输入的奇数。相邻两个质数之间用一个空格隔开，最后一个质数后面没有空格。如果表示方法不唯一，请输出第一个质数最小的方案，如果第一个质数最小的方案不唯一，请输出第一个质数最小的同时，第二个质数最小的方案。
 * </div>
 *
 *     <h2>输入输出样例</h2>
 *                         <h3>输入样例 #1</h3>
 *             <pre><code>2009</code></pre>
 *             <h3>输出样例 #1</h3>
 *             <pre><code>3 3 2003</code></pre>
 *
 *     </article>
 *     </div>
 * </div>
 */
public class 哥德巴赫猜想 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int first = list.get(i);
            for (int i1 = 0; i1 < list.size(); i1++) {
                int second = list.get(i1);
                if (list.contains(n-first-second)) {
                    System.out.println(first + " " + second + " " + (n-first-second));
                    return;
                }
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

}
