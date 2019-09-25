package 入门;

/**
 * Integer.numberOfLeadingZeros()方法返回一个非零整数用二进制表示时，从左边开始数连续的0的个数，应用了位运算和二分查找
 * 从网上找到两种实现，一种是从高位开始二分，一种是从低位开始二分
 * jdk为什么使用从低位开始算，个人猜测大部分Map的size都很小，低位开始可以减少运算量
 */
public class 位运算 {
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    // 首先在jvm中一个int类型的数据占4个字节，共32位，其实就相当于一个长度为32的数组。
    // 那我们要计算首部0的个数，就是从左边第一个位开始累加0的个数，直到遇到一个非零值。
    public static int numberOfLeadingZeros1(int i) {
        if (i == 0)
            return 32;
        int n = 1;
        // 下面的代码就是定位从左边开始第一个非零值的位置，在定位过程中顺便累加从左边开始0的个数
        // 将i无符号右移16位后，有二种情况；
        //   情况1.i=0,则第一个非零值位于低16位，i至少有16个0，同时将i左移16位（把低16位移到原高16位的位置，这样情况1和情况2就能统一后续的判断方式）
        //   情况2.i!=0,则第一个非零值位于高16位，后续在高16位中继续判断
        // 这个思路就是二分查找，首先把32位的数分为高低16位，如果非零值位于高16位，后续再将高16位继续二分为高低8位，一直二分到集合中只有1个元素
        if (i >>> 16 == 0) { n += 16; i <<= 16; }
        // 判断第一个非零值是否位于高8位
        if (i >>> 24 == 0) { n +=  8; i <<=  8; }
        // 判断第一个非零值是否位于高4位
        if (i >>> 28 == 0) { n +=  4; i <<=  4; }
        // 判断第一个非零值是否位于高2位
        if (i >>> 30 == 0) { n +=  2; i <<=  2; }
        // 判断第一个非零值是否位于左边第一位
        n -= i >>> 31;
        return n;
    }

    public static int numberOfLeadingZeros2(int i) {
        // HD, Count leading 0's
        if (i <= 0)
            return i == 0 ? 32 : 0;
        int n = 31;
        if (i >= 1 << 16) { n -= 16; i >>>= 16; }
        if (i >= 1 <<  8) { n -=  8; i >>>=  8; }
        if (i >= 1 <<  4) { n -=  4; i >>>=  4; }
        if (i >= 1 <<  2) { n -=  2; i >>>=  2; }
        return n - (i >>> 1);
    }

    static int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
        System.out.println(tableSizeFor(0));
        System.out.println(tableSizeFor(1));
        System.out.println(tableSizeFor(2));
        System.out.println(tableSizeFor(3));
        System.out.println(tableSizeFor(4));
        System.out.println(tableSizeFor(5));
        System.out.println(tableSizeFor(6));
    }
}
