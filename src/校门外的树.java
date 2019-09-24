import java.util.Scanner;

/**
 * <article>
 * <h1>校门外的树</h1>
 *
 *
 *
 * <h2>题目描述</h2>
 *     <div>某校大门外长度为L的马路上有一排树，每两棵相邻的树之间的间隔都是$1$米。我们可以把马路看成一个数轴，马路的一端在数轴$0$的位置，另一端在$L$的位置；数轴上的每个整数点，即$0,1,2,…,L$，都种有一棵树。
 * <p>
 * <p>
 * 由于马路上有一些区域要用来建地铁。这些区域用它们在数轴上的起始点和终止点表示。已知任一区域的起始点和终止点的坐标都是整数，区域之间可能有重合的部分。现在要把这些区域中的树（包括区域端点处的两棵树）移走。你的任务是计算将这些树都移走后，马路上还有多少棵树。
 * </div>
 *
 *     <h2>输入输出格式</h2>
 *     <h3>输入格式</h3>
 *     <br />
 *     <div>第一行有$2$个整数$L(1  \le  L \le  10000)$和$ M(1 \le  M \le  100)$，$L$代表马路的长度，$M$代表区域的数目，$L$和$M$之间用一个空格隔开。
 * 接下来的$M$行每行包含$2$个不同的整数，用一个空格隔开，表示一个区域的起始点和终止点的坐标。
 *
 * </div>
 *     <h3>输出格式</h3>
 *     <br />
 *     <div>$1$个整数，表示马路上剩余的树的数目。
 *
 * </div>
 */
public class 校门外的树 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        boolean[] array = new boolean[total+1];
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int begin = scanner.nextInt();
            int end = scanner.nextInt();
            for (int j = begin; j <= end; j++) {
                array[j] = true;
            }
        }
        int count= 0;
        for (boolean b : array) {
            if (!b) {
                count++;
            }
        }
        System.out.println(count);
    }
}
