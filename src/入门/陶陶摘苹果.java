package 入门;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>陶陶摘苹果（升级版）</h1>
 *
 *
 *
 * <h2>题目描述</h2>
 *     <div>又是一年秋季时，陶陶家的苹果树结了n个果子。陶陶又跑去摘苹果，这次她有一个a公分的椅子。当他手够不着时，他会站到椅子上再试试。
 * <p>
 * 这次与NOIp2005普及组第一题不同的是：陶陶之前搬凳子，力气只剩下s了。当然，每次摘苹果时都要用一定的力气。陶陶想知道在s<0之前最多能摘到多少个苹果。
 * <p>
 * 现在已知n个苹果到达地上的高度xi，椅子的高度a，陶陶手伸直的最大长度b，陶陶所剩的力气s，陶陶摘一个苹果需要的力气yi，求陶陶最多能摘到多少个苹果。
 * </div>
 *
 *     <h2>输入输出格式</h2>
 *     <h3>输入格式</h3>
 *     <br />
 *     <div>第1行：两个数 苹果数n，力气s。
 * <p>
 * 第2行：两个数 椅子的高度a，陶陶手伸直的最大长度b。
 * <p>
 * 第3行~第3+n-1行：每行两个数 苹果高度xi，摘这个苹果需要的力气yi。
 * </div>
 *     <h3>输出格式</h3>
 *     <br />
 *     <div>只有一个整数，表示陶陶最多能摘到的苹果数。
 * </div>
 */
public class 陶陶摘苹果 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int apples = scanner.nextInt();
        int remain = scanner.nextInt();
        int chair = scanner.nextInt();
        int hand = scanner.nextInt();
        List<陶陶摘苹果.Apple> appleList = new ArrayList<>();
        for (int i = 0; i < apples; i++) {
            int height = scanner.nextInt();
            int cost = scanner.nextInt();
            if (height <= chair + hand) {
                appleList.add(new 陶陶摘苹果.Apple(height, cost));
            }
        }
        appleList.sort(陶陶摘苹果.Apple.comparator);
        int count = 0;
        int index = 0;
        while (remain > 0) {
            remain -= appleList.get(index++).getCost();
            if (remain >= 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static class Apple {
        private static Comparator<陶陶摘苹果.Apple> comparator = Comparator.comparingInt(陶陶摘苹果.Apple::getCost);
        public int height;
        public int cost;

        public int getCost() {
            return cost;
        }

        public Apple(int height, int cost) {
            this.height = height;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "height=" + height +
                    ", cost=" + cost +
                    '}';
        }
    }

}
