package 普及;

import java.util.*;

/**
 * <article>
 * <h1>排座椅</h1>
 *
 *
 *
 * <h2>题目描述</h2>
 *     <div>上课的时候总会有一些同学和前后左右的人交头接耳，这是令小学班主任十分头疼的一件事情。不过，班主任小雪发现了一些有趣的现象，当同学们的座次确定下来之后，只有有限的D对同学上课时会交头接耳。
 * <p>
 * 同学们在教室中坐成了M行N列，坐在第i行第j列的同学的位置是(i,j)，为了方便同学们进出，在教室中设置了K条横向的通道，L条纵向的通道。
 * <p>
 * 于是，聪明的小雪想到了一个办法，或许可以减少上课时学生交头接耳的问题：她打算重新摆放桌椅，改变同学们桌椅间通道的位置，因为如果一条通道隔开了2个会交头接耳的同学，那么他们就不会交头接耳了。
 * <p>
 * 请你帮忙给小雪编写一个程序，给出最好的通道划分方案。在该方案下，上课时交头接耳的学生的对数最少。
 * </div>
 *
 *     <h2>输入输出格式</h2>
 *     <h3>输入格式</h3>
 *     <br />
 *     <div>第一行，有5个用空格隔开的整数，分别是M,N,K,L,D(2 \le N,M \le 1000,0 \le K<M,0 \le L<N,D \le 2000)
 * <p>
 * 接下来的D行，每行有4个用空格隔开的整数。第i行的4个整数X_i,Y_i,P_i,Q_i，表示坐在位置(X_i,Y_i)与(P_i,Q_i)的两个同学会交头接耳（输入保证他们前后相邻或者左右相邻）。
 * <p>
 * 输入数据保证最优方案的唯一性。
 * </div>
 *     <h3>输出格式</h3>
 *     <br />
 *     <div>共两行。
 * 第一行包含K个整数a_1,a_2,…,a_K，表示第a_1行和a_1+1行之间、第a_2行和a_2+1行之间、…、第a_K行和第a_K+1行之间要开辟通道，其中a_i< a_i+1，每两个整数之间用空格隔开（行尾没有空格）。
 * <p>
 * 第二行包含L个整数b_1,b_2,…,b_L，表示第b_1列和b_1+1列之间、第b_2列和b_2+1列之间、…、第b_L列和第b_L+1列之间要开辟通道，其中b_i< b_i+1，每两个整数之间用空格隔开（列尾没有空格）。
 * </div>
 *
 *     <h2>输入输出样例</h2>
 *                         <h3>输入样例 #1</h3>
 *             <pre><code>4 5 1 2 3
 * 4 2 4 3
 * 2 3 3 3
 * 2 5 2 4
 * </code></pre>
 *             <h3>输出样例 #1</h3>
 *             <pre><code>2
 * 2 4
 * </code></pre>
 *
 *             <h2>说明</h2>
 *         <div> ![](https://cdn.luogu.com.cn/upload/pic/20.png)
 * <p>
 * 上图中用符号\*、※、+标出了3对会交头接耳的学生的位置，图中3条粗线的位置表示通道，图示的通道划分方案是唯一的最佳方案。
 * <p>
 * 2008年普及组第二题
 * </div>
 *     </article>
 */
public class 排座椅 {

    private static class Item {
        private int number;
        private int count;
        private static final Comparator COMPARATOR = Comparator.comparingInt(Item::getCount).reversed();

        public Item() {
        }

        public Item(int number, int count) {
            this.number = number;
            this.count = count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        private int getCount() {
            return count;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Item) {
                Item item = (Item) obj;
                return this.number == item.number;
            } else {
                return false;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int l = scanner.nextInt();
        int d = scanner.nextInt();
        Map<Integer, Item> xMap = new HashMap<>();
        Map<Integer, Item> yMap = new HashMap<>();
        for (int i = 0; i < d; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (x == p) {
                int min = Math.min(y, q);
                if (yMap.containsKey(min)) {
                    yMap.get(min).setCount(yMap.get(min).getCount() + 1);
                } else {
                    yMap.put(min, new Item(min, 1));
                }
            } else {
                int min = Math.min(x, p);
                if (xMap.containsKey(min)) {
                    xMap.get(min).setCount(xMap.get(min).getCount() + 1);
                } else {
                    xMap.put(min, new Item(min, 1));
                }
            }
        }
        List<Item> yList = new ArrayList<>(yMap.values());
        yList.sort(Item.COMPARATOR);
        yList = yList.subList(0, l);
        List<Integer> yResult = new ArrayList<>();
        for (Item item : yList) {
            yResult.add(item.number);
        }

        List<Item> xList = new ArrayList<>(xMap.values());
        xList.sort(Item.COMPARATOR);
        xList = xList.subList(0, k);
        List<Integer> xResult = new ArrayList<>();
        for (Item item : xList) {
            xResult.add(item.number);
        }
        Collections.sort(xResult);
        xResult.forEach(e -> System.out.print(e + " "));
        System.out.println("");
        Collections.sort(yResult);
        yResult.forEach(e -> System.out.print(e + " "));
    }

}
