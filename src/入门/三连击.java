package 入门;

import java.util.Scanner;

/**
 * 将1,2,⋯,9共9个数分成3组，分别组成3个三位数，且使这3个三位数构成1:2:3的比例，试求出所有满足条件的3个三位数。
 */
public class 三连击 {

    public static void main(String[] args) {
        for (int i = 123; i <= 329; i++) {
            int [] arrays = new int [10];
            if (verify(i, arrays) && verify(2 * i, arrays) && verify(3 * i, arrays)) {
                System.out.println(i + " " + 2 * i + " " + 3 * i);
            }
        }
    }

    private static boolean verify(int i, int[] arrays) {
        int 百位 = i / 100;
        if (arrays[百位] == 0) {
            arrays[百位] = 百位;
        } else {
            return false;
        }
        int 十位 = (i / 10) % 10;
        if (arrays[十位] == 0 && 十位 != 0) {
            arrays[十位] = 十位;
        } else {
            return false;
        }

        int 个位 = i % 10;
        if (arrays[个位] == 0 && 个位 != 0) {
            arrays[个位] = 个位;
        } else {
            return false;
        }
        return true;
    }
}
