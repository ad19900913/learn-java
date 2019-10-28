package 入门;

import java.util.Scanner;

/**
 * <article>
 * <h1>计算器的改良  </h1>
 *
 *
 * <h2>题目背景</h2>
 *         <div>NCL是一家专门从事计算器改良与升级的实验室，最近该实验室收到了某公司所委托的一个任务：需要在该公司某型号的计算器上加上解一元一次方程的功能。实验室将这个任务交给了一个刚进入的新手ZL先生。
 * </div>
 *
 *     <h2>题目描述</h2>
 *     <div>为了很好的完成这个任务，ZL先生首先研究了一些一元一次方程的实例：
 * <p>
 * 4+3x=8
 * <p>
 * 6a-5+1=2-2a
 * <p>
 * -5+12y=0
 * <p>
 * ZL先生被主管告之，在计算器上键入的一个一元一次方程中，只包含整数、小写字母及+、-、=这三个数学符号（当然，符号“-”既可作减号，也可作负号）。方程中并没有括号，也没有除号，方程中的字母表示未知数。
 * <p>
 * 你可假设对键入的方程的正确性的判断是由另一个程序员在做，或者说可认为键入的一元一次方程均为合法的，且有唯一实数解。
 * </div>
 *
 *     <h2>输入输出格式</h2>
 *     <h3>输入格式</h3>
 *     <br />
 *     <div>一个一元一次方程。
 * </div>
 *     <h3>输出格式</h3>
 *     <br />
 *     <div>解方程的结果(精确至小数点后三位)。
 * </div>
 *
 *     <h2>输入输出样例</h2>
 *                         <h3>输入样例 #1</h3>
 *             <pre><code>6a-5+1=2-2a
 * </code></pre>
 *             <h3>输出样例 #1</h3>
 *             <pre><code>a=0.750</code></pre>
 *
 *     </article>
 */
public class 计算器的改良 {

    private static int EMPTY = 0;
    private static int NUMBER = 1;
    private static int PLUS = 2;
    private static int MINUS = 3;
    private static int CHAR = 4;
    private static char a;

    /**
     * 状态机
     * 获取常数项系数和一元系数
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String[] split = n.split("=");
        int aParam = 0;
        int bConst = 0;
        int [] array1 = process(split[0]);
        int [] array2 = process(split[1]);
        aParam += array1[0];
        aParam -= array2[0];
        bConst += array2[1];
        bConst -= array1[1];
        if (bConst == 0) {
            System.out.print(a + "=0.000");
        } else {
            System.out.printf(a + "=%.3f", Double.parseDouble(""+bConst)/Double.parseDouble(""+aParam));
        }
    }

    private static int[] process(String s) {
        int state = EMPTY;
        int t_aParam = 0;
        int t_bConst = 0;
        int flag = 1;
        int bConst = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if ('0' <= aChar && aChar <= '9') {
                aChar -= 48;
                if (state == EMPTY) {
                    bConst = aChar;
                }
                if (state == NUMBER) {
                    bConst *= 10;
                    bConst += (aChar * flag);
                }
                if (state == PLUS) {
                    bConst = aChar;
                }
                if (state == MINUS) {
                    flag = -1;
                    bConst = aChar * flag;
                }
                if (i == chars.length - 1) {
                    t_bConst += bConst;
                    break;
                }
                state = NUMBER;
            }
            if ('a' <= aChar && aChar <= 'z') {
                a = aChar;
                if (state == EMPTY) {
                    t_aParam += 1;
                }
                if (state == NUMBER) {
                    t_aParam += bConst;
                    flag = 1;
                    bConst = 0;
                }
                if (state == PLUS) {
                    t_aParam += 1;
                }
                if (state == MINUS) {
                    t_aParam -= 1;
                }
                if (i == chars.length - 1) {
                    t_aParam += bConst;
                    break;
                }
                state = CHAR;
            }
            if ('+' == aChar) {
                if (state == NUMBER) {
                    t_bConst += bConst;
                    flag = 1;
                    bConst = 0;
                }
                state = PLUS;
            }
            if ('-' == aChar) {
                if (state == NUMBER) {
                    t_bConst += bConst;
                    flag = 1;
                    bConst = 0;
                }
                state = MINUS;
            }
        }
        return new int[]{t_aParam, t_bConst};
    }
}
