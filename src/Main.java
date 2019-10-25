import java.util.*;

public class Main {
    private static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        List<int[]> list = new ArrayList<>();
        while (true) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            if (a != -1 || b != -1 || c != -1) {
                list.add(new int[]{a, b, c});
            } else {
                break;
            }
        }
        for (int[] ints : list) {
            System.out.println("w(" + ints[0] + ", " + ints[1] + ", " + ints[2] + ") = " + w(ints[0], ints[1], ints[2]));
        }
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            Result result = search(20, 20, 20);
            if (result.exist) {
                return result.value;
            } else {
                int w = w(20, 20, 20);
                cached(20, 20, 20, w);
                return w;
            }
        }
        if (a < b && b < c) {
            Result result = search(a, b, c);
            if (result.exist) {
                return result.value;
            } else {
                int i = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
                cached(a, b, c, i);
                return i;
            }
        } else {
            int i = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
            cached(a, b, c, i);
            return i;
        }
    }

    private static class Result {
        public boolean exist;
        public int value;

        public Result(boolean exist, int value) {
            this.exist = exist;
            this.value = value;
        }
    }

    private static Result search(int a, int b, int c) {
        Integer integer = map.get(a + "-" + b + "-" + c);
        if (integer == null) {
            return new Result(false, 0);
        } else {
            return new Result(true, integer);
        }
    }

    private static void cached(int a, int b, int c, int value) {
        map.put(a + "-" + b + "-" + c, value);
    }
}
