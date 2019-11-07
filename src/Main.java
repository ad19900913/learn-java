import java.util.*;

public class Main {

    private static class Node {
        private int flag;
        private String name;

        public Node(int flag, String name) {
            this.flag = flag;
            this.name = name;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        Node [] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] strings = line.split(" ");
            nodes[i] = new Node(Integer.parseInt(strings[0]), strings[1]);
        }
        int index = 0;
        for (int i = 0; i < m; i++) {
            int direction = scanner.nextInt();
            int count = scanner.nextInt();
            count %= n;
            if ((direction ^ nodes[index].flag) == 0) {
                index -= count;
                if (index < 0) {
                    index += n;
                }
            } else {
                index+=count;
                if (index >= n) {
                    index %= n;
                }
            }
        }
        System.out.println(nodes[index].name);
    }

}
