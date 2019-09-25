package 入门;

import java.util.Scanner;

/**
 * 题目描述
 * <p>
 * 试计算在区间 1 到 n的所有整数中，数字x(0≤x≤9)共出现了多少次？例如，在 1到11中，即在 1,2,3,4,5,6,7,8,9,10,11中，数字 1 出现了 4 次。
 * <p>
 * 输入格式
 * 2个整数n,x，之间用一个空格隔开。
 * <p>
 * 输出格式
 * 1个整数，表示x出现的次数。
 */
public class 计数问题 {

    /**
     * 此题的暴力枚举解法是显而易见的，下面尝试另一种思路
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 求1~735中的4出现的次数
         * 问题分解成
         *  求4在个位、十位、百位的次数
         *
         */
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int x = scanner.nextInt();
        int count = 0;
        int pow = 1;
        while (pow <= num) {
            int left = num / (pow * 10);//左边的数
            int middle = num / pow % 10;//中间的数
            int right = num % pow;//右边的数
            if (x == 0) {
                if (middle != 0) {
                    count += left * pow;
                } else {
                    count += (left - 1) * pow + right + 1;
                }
            } else {
                if (middle > x) {
                    count += (left + 1) * pow;
                }
                if (middle == x) {
                    count += left * pow + right + 1;
                }
                if (middle < x) {
                    count += left * pow;
                }
            }
            pow *= 10;
        }

        System.out.println(count);
    }

}
