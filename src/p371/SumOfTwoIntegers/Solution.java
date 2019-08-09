package p371.SumOfTwoIntegers;

public class Solution {
    public int getSum2(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public int getSum(int a, int b) {
        return ((a&b)<<1) + (a^b);
    }
}