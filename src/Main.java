import java.util.*;

public class Main {

    private static class Point {
        private int price;
        private int sales;
        private static final Comparator<Point> COMPARATOR = Comparator.comparingInt(Point::getPrice);

        public Point(int price, int sales) {
            this.price = price;
            this.sales = sales;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSales() {
            return sales;
        }

        public void setSales(int sales) {
            this.sales = sales;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int expectedPrice = scanner.nextInt();
        int cost = scanner.nextInt();
        int sales = scanner.nextInt();
        List<Point> _list = new ArrayList<>();
        _list.add(new Point(cost, sales));
        while (true) {
            int _cost = scanner.nextInt();
            int _sales = scanner.nextInt();
            if (_cost == -1 && _sales == -1) {
                break;
            }
            _list.add(new Point(_cost, _sales));
        }
        _list.sort(Point.COMPARATOR);
        int minus = scanner.nextInt();
        List<Point> list = processList(minus, _list);
        int tax = 0;
        getBestPrice(list, tax);
    }

    private static int getBestPrice(List<Point> list, int tax) {
        return 0;
    }

    /**
     * 计算各价位下的销量
     *
     * @param minus
     * @param _list
     * @return
     */
    private static List<Point> processList(int minus, List<Point> _list) {
        List<Point> list = new ArrayList<>();
        Point o_point, n_point = null;
        for (Point point : _list) {
            o_point = n_point;
            n_point = point;
            if (o_point != null && n_point.price - o_point.price > 1) {
                int step = (n_point.sales - o_point.sales) / (n_point.price - o_point.price);
                for (int i = o_point.price + 1; i < n_point.price; i++) {
                    list.add(new Point(i, o_point.price + (i - o_point.price) * step));
                }
            }
            list.add(point);
        }
        //已知最高价位下销量大于0,继续填充列表,直到销量<=0
        if (n_point.sales > 0) {
            int price = n_point.price;
            int sales = n_point.sales;
            while (true) {
                price++;
                sales-=minus;
                if (sales > 0) {
                    list.add(new Point(price, sales));
                } else {
                    break;
                }
            }
        }
        return list;
    }

}
