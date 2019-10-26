import java.util.*;

public class Main {
    private static int[][][] array = new int[22][22][22];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a, b, c;
        List<long[]> list = new ArrayList<>();
        while (true) {
            a = scanner.nextLong();
            b = scanner.nextLong();
            c = scanner.nextLong();
            if (a != -1 || b != -1 || c != -1) {
                list.add(new long[]{a, b, c});
            } else {
                break;
            }
        }
        for (long[] ints : list) {
            System.out.println("w(" + ints[0] + ", " + ints[1] + ", " + ints[2] + ") = " + w(ints[0], ints[1], ints[2]));
        }
    }

    private static int w(long a, long b, long c) {
        int aIndex = a > 20 ? 21 : (int) a;
        int bIndex = b > 20 ? 21 : (int) b;
        int cIndex = c > 20 ? 21 : (int) c;
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (array[aIndex][bIndex][cIndex] != 0) {
            return array[aIndex][bIndex][cIndex];
        } else if (a > 20 || b > 20 || c > 20) {
            int result = array[20][20][20];
            if (result == 0) {
                array[20][20][20] = w(20, 20, 20);
            }
            return array[20][20][20];
        } else if (a < b && b < c) {
            array[aIndex][bIndex][cIndex] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            array[aIndex][bIndex][cIndex] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
        return array[aIndex][bIndex][cIndex];
    }
}
