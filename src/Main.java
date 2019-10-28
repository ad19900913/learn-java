import java.util.*;

public class Main {

    private static int EMPTY = 0;
    private static int NUMBER = 1;
    private static int PLUS = 2;
    private static int MINUS = 3;
    private static int CHAR = 4;
    private static char a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String[] split = n.split("=");
        int aParam = 0;
        int bConst = 0;
        int [] array1 = process(split[0]);
        int [] array2 = process(split[1]);
        aParam += array1[0];
        aParam -= array2[0];
        bConst += array2[1];
        bConst -= array1[1];
        if (bConst == 0) {
            System.out.print(a + "=0.000");
        } else {
            System.out.printf(a + "=%.3f", Double.parseDouble(""+bConst)/Double.parseDouble(""+aParam));
        }
    }

    private static int[] process(String s) {
        int state = EMPTY;
        int t_aParam = 0;
        int t_bConst = 0;
        int flag = 1;
        int bConst = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if ('0' <= aChar && aChar <= '9') {
                aChar -= 48;
                if (state == EMPTY) {
                    bConst = aChar;
                }
                if (state == NUMBER) {
                    bConst *= 10;
                    bConst += (aChar * flag);
                }
                if (state == PLUS) {
                    bConst = aChar;
                }
                if (state == MINUS) {
                    flag = -1;
                    bConst = aChar * flag;
                }
                if (i == chars.length - 1) {
                    t_bConst += bConst;
                    break;
                }
                state = NUMBER;
            }
            if ('a' <= aChar && aChar <= 'z') {
                a = aChar;
                if (state == EMPTY) {
                    t_aParam += 1;
                }
                if (state == NUMBER) {
                    t_aParam += bConst;
                    flag = 1;
                    bConst = 0;
                }
                if (state == PLUS) {
                    t_aParam += 1;
                }
                if (state == MINUS) {
                    t_aParam -= 1;
                }
                if (i == chars.length - 1) {
                    t_aParam += bConst;
                    break;
                }
                state = CHAR;
            }
            if ('+' == aChar) {
                if (state == NUMBER) {
                    t_bConst += bConst;
                    flag = 1;
                    bConst = 0;
                }
                state = PLUS;
            }
            if ('-' == aChar) {
                if (state == NUMBER) {
                    t_bConst += bConst;
                    flag = 1;
                    bConst = 0;
                }
                state = MINUS;
            }
        }
        return new int[]{t_aParam, t_bConst};
    }
}
