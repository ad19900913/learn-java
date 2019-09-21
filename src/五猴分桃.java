/**
 * 5只猴子分一堆桃子，怎么也分不成5等分，只好先去睡觉，准备第二天分。
 * 夜里1只猴子偷偷爬起来，先吃掉一个桃子，然后将其分为5等份，藏起自己的一份就去睡觉了；
 * 第二只猴子又爬起来，吃掉一个桃子后，也将桃子分成5等份，藏起自己的一份睡觉去了；
 * 以后的3只猴子都先后照此办理。
 * 问最初有多少个桃子？
 */
public class 五猴分桃 {

    public static void main(String[] args) {
        int count = 5;
        int num = 0;
        while (num < 10000) {
            if (consume(count, num)) {
                System.out.println("最初有" + num + "个桃子");
            }
            num++;
        }
    }

    /**
     * @param count     第几只猴子
     * @param num       多少个桃子
     * @return          是否符合要求
     */
    private static boolean consume(int count, int num) {
        if ((num - 1) % 5 != 0) {
            return false;
        }
        if (count == 1) {
            return true;
        }
        return consume(--count, (num - 1) * 4 / 5);
    }

}
