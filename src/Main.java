import java.util.*;

public class Main {

    private static class Point {
        private int price;
        private int sale;

        public int getPrice() {
            return price;
        }

        private static final Comparator COMPARATOR = Comparator.comparingInt(Point::getPrice);
        public Point(int price, int sale) {
            this.price = price;
            this.sale = sale;
        }
    }

    private static List<Point> points = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int expectPrice = scanner.nextInt();
        int cost = scanner.nextInt();
        int sales = scanner.nextInt();
        points.add(new Point(cost, sales));
        while (true) {
            int price = scanner.nextInt();
            int sale = scanner.nextInt();
            if (price == -1 && sale == -1) {
                break;
            }
            points.add(new Point(price, cost));
        }
        points.sort(Point.COMPARATOR);
        int minus = scanner.nextInt();
        int start_price = cost;
        int start_sale = sales;
        while (true) {

        }
    }

    private static int calculate(int subsidy, int start_price, int start_sale, int minus) {
        int total_profit = 0;
        int best_price = 0;
        for (int i = start_price; ; i++) {
            int sale = 0;

            if (sale <= 0) {
                break;
            }
            int profit = (i - start_price + subsidy) * sale;
            if (profit > total_profit) {
                best_price = i;
            }
        }
        return -1;
    }

    private static int getSale(int price) {
        int ceiling = 0, floor = 0, ceiling_sale = 0, floor_sale = 0;
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            if (point.price == price) {
                return point.sale;
            }
            if (point.price > price) {
                ceiling = point.price;
                ceiling_sale = point.sale;
                floor = points.get(i - 1).price;
                floor_sale = points.get(i - 1).sale;
            }
            break;
        }
        return floor_sale + (ceiling_sale - floor_sale) / (ceiling - floor) * (price - floor);
    }

}
