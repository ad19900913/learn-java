package 入门;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <article>
 *     <h1>垂直柱状图</h1>
 *
 *
 *
 *     <h2>题目描述</h2>
 *     <div>写一个程序从输入文件中去读取四行大写字母（全都是大写的，每行不超过100个字符），然后用柱状图输出每个字符在输入文件中出现的次数。严格地按照输出样例来安排你的输出格式。
 * </div>
 *
 *     <h2>输入输出格式</h2>
 *     <h3>输入格式</h3>
 *     <br />
 *     <div>四行字符，由大写字母组成，每行不超过100个字符
 * </div>
 *     <h3>输出格式</h3>
 *     <br />
 *     <div>由若干行组成，前几行由空格和星号组成，最后一行则是由空格和字母组成的。在任何一行末尾不要打印不需要的多余空格。不要打印任何空行。
 * </div>
 *
 *     <h2>输入输出样例</h2>
 *                         <h3>输入样例 #1</h3>
 * <pre><code>
 * THE QUICK BROWN FOX JUMPED OVER THE LAZY DOG.
 * THIS IS AN EXAMPLE TO TEST FOR YOUR
 * HISTOGRAM PROGRAM.
 * HELLO!
 * </code></pre>
 *             <h3>输出样例 #1</h3>
 *             <pre><code>
 *                             *
 *                             *
 *         *                   *
 *         *                   *     *   *
 *         *                   *     *   *
 * *       *     *             *     *   *
 * *       *     * *     * *   *     * * *
 * *       *   * * *     * *   * *   * * * *
 * *     * * * * * *     * * * * *   * * * *     * *
 * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * </code></pre>
 */
public class 垂直柱状图 {
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
