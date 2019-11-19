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

    }

    /**
     * 计算各价位下的销量
     * @param minus
     * @param _list
     * @return
     */
    private static List<Point> processList(int minus, List<Point> _list) {
        List<Point> list = new ArrayList<>();
        int o_price = 0;
        int n_price = 0;
        for (Point point : _list) {
            n_price = point.getPrice();
            o_price = n_price;
            if (o_price > 0 && n_price - o_price > 1) {
                for (int i = o_price + 1; i < n_price; i++) {

                }
            }
            list.add(point);
        }

        return list;
    }

}
