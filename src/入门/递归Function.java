package 入门;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Function</h1>
 *
 *
 *
 * <h2>题目描述</h2>
 *     <div>对于一个递归函数w(a,b,c)
 * <p>
 * <p>
 * - 如果a < 0 or b < 0 or c < 0就返回值1.
 * - 如果a>20 or b>20 or c>20就返回w(20,20,20)
 * - 如果a<b并且b<c 就返回w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c)
 * - 其它的情况就返回w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1)
 * <p>
 * 这是个简单的递归函数，但实现起来可能会有些问题。当a,b,c均为15时，调用的次数将非常的多。你要想个办法才行.
 * <p>
 * absi2011 : 比如 w(30,-1,0)既满足条件1又满足条件2
 * <p>
 * 这种时候我们就按最上面的条件来算
 * <p>
 * 所以答案为1
 */
public class 递归Function {
    private static int[][][] array = new int[22][22][22];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a, b, c;
        List<long[]> list = new ArrayList<>();
        while (true) {
            a = scanner.nextLong();
            b = scanner.nextLong();
            c = scanner.nextLong();
            if (a != -1 || b != -1 || c != -1) {
                list.add(new long[]{a, b, c});
            } else {
                break;
            }
        }
        for (long[] ints : list) {
            System.out.println("w(" + ints[0] + ", " + ints[1] + ", " + ints[2] + ") = " + w(ints[0], ints[1], ints[2]));
        }
    }

    private static int w(long a, long b, long c) {
        int aIndex = a > 20 ? 21 : (int) a;
        int bIndex = b > 20 ? 21 : (int) b;
        int cIndex = c > 20 ? 21 : (int) c;
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (array[aIndex][bIndex][cIndex] != 0) {
            return array[aIndex][bIndex][cIndex];
        } else if (a > 20 || b > 20 || c > 20) {
            int result = array[20][20][20];
            if (result == 0) {
                array[20][20][20] = w(20, 20, 20);
            }
            return array[20][20][20];
        } else if (a < b && b < c) {
            array[aIndex][bIndex][cIndex] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            array[aIndex][bIndex][cIndex] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
        return array[aIndex][bIndex][cIndex];
    }
}
