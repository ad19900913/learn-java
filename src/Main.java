import java.util.Scanner;

public class Main {

    private static int temp [] = new int []{6,2,5,5,4,5,6,3,7,6};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (stick(i) + stick(j) + stick(i + j) + 4 == n) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }

    /**
     * 返回需要多少火柴
     * @param i
     * @return
     */
    private static int stick(int i) {
        if (i == 0) {
            return 6;
        }
        int sum = 0;
        while (i > 0) {
            sum += temp[i % 10];
            i /= 10;
        }
        return sum;
    }

}
