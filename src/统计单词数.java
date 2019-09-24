import java.util.Scanner;

/**
 * <article>
 * <h1>统计单词数</h1>
 *
 *
 *
 * <h2>题目描述</h2>
 *     <div>一般的文本编辑器都有查找单词的功能，该功能可以快速定位特定单词在文章中的位置，有的还能统计出特定单词在文章中出现的次数。
 * <p>
 * 现在，请你编程实现这一功能，具体要求是：给定一个单词，请你输出它在给定的文章中出现的次数和第一次出现的位置。注意：匹配单词时，不区分大小写，但要求完全匹配，即给定单词必须与文章中的某一独立单词在不区分大小写的情况下完全相同（参见样例1 ），如果给定单词仅是文章中某一单词的一部分则不算匹配（参见样例2 ）。
 * </div>
 *
 *     <h2>输入输出格式</h2>
 *     <h3>输入格式</h3>
 *     <br />
 *     <div>共2行。
 * <p>
 * 第1行为一个字符串，其中只含字母，表示给定单词；
 * <p>
 * 第2行为一个字符串，其中只可能包含字母和空格，表示给定的文章。
 * </div>
 *     <h3>输出格式</h3>
 *     <br />
 *     <div>一行，如果在文章中找到给定单词则输出两个整数，两个整数之间用一个空格隔开，分别是单词在文章中出现的次数和第一次出现的位置（即在文章中第一次出现时，单词首字母在文章中的位置，位置从0 开始）；如果单词在文章中没有出现，则直接输出一个整数-1。
 * </div>
 */
public class 统计单词数 {

    enum State {SPACE, LETTER, WORD}

    /**
     * 状态机？
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] word = scanner.nextLine().toLowerCase().toCharArray();
        char[] article = scanner.nextLine().toLowerCase().toCharArray();

        int w = 0;//匹配字母，代表下一个要查找的字母下标
        State state = State.SPACE;//从空格状态开始
        int firstIndex = -1;//第一次出现的下标
        int count = 0;//出现的次数
        for (int i = 0; i < article.length; i++) {
            char c = article[i];
            switch (state) {
                case SPACE:
                    if (c == ' ') {
                        state = State.SPACE;
                        w = 0;
                    }
                    if (c == word[0]) {
                        state = State.WORD;
                        w++;
                    } else {
                        state = State.LETTER;
                        w = 0;
                    }
                    break;
                case LETTER:
                    if (c == ' ') {
                        state = State.SPACE;
                    }
                    break;
                default:
                    if (w == word.length) {
                        if (c == ' ') {
                            state = State.SPACE;
                            count++;
                            if (firstIndex == -1) {
                                firstIndex = i - word.length;
                            }
                            w = 0;
                        } else {
                            state = State.LETTER;
                        }
                    } else if (w < word.length) {
                        if (c == ' ') {
                            state = State.SPACE;
                            w = 0;
                        } else if (c == word[w]) {
                            w++;
                        } else {
                            state = State.LETTER;
                            w = 0;
                        }
                    }
                    break;
            }
        }
        if (count == 0) {
            System.out.println(-1);
        } else {
            System.out.println(count + " " + firstIndex);
        }
    }
}
