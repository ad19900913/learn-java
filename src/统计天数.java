import java.util.Scanner;

/**
 * <article>
 * <h1>统计天数</h1>
 *
 *
 *
 * <h2>题目描述</h2>
 *     <div>炎热的夏日，KC 非常的不爽。他宁可忍受北极的寒冷，也不愿忍受厦门的夏天。最近，他开始研究天气的变化。他希望用研究的结果预测未来的天气。
 * <p>
 * <p>
 * 经历千辛万苦，他收集了连续 N(1 < N < 10^6) 的最高气温数据。
 * <p>
 * 现在，他想知道最高气温一直上升的最长连续天数。
 * </div>
 *
 *     <h2>输入输出格式</h2>
 *     <h3>输入格式</h3>
 *     <br />
 *     <div>第 1 行：一个整数 N 。1 < N < 10^6
 * <p>
 * 第 2 行：N个空格隔开的整数，表示连续 N 天的最高气温。0 < 最高气温 < 10^9 。
 * </div>
 *     <h3>输出格式</h3>
 *     <br />
 *     <div>1 行：一个整数，表示最高气温一直上升的最长连续天数。
 * </div>
 */
public class 统计天数 {

    /**
     * 动态规划
     * f(i)表示以当前元素结尾的最长连续递增序列长度：如果当前元素大于上一元素f(i) = f(i-1) + 1；否则f(i) = 1；
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int last = Integer.MIN_VALUE;
        int [] result = new int[count];
        for (int i = 0; i < count; i++) {
            int current = scanner.nextInt();
            if (i == 0) {
                result[0] = 1;
                continue;
            }
            if (current > last) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = 1;
            }
            last = current;
        }
        int max = 0;
        for (int i : result) {
            max = Math.max(i, max);
        }
        System.out.println(max);
    }
}
