package p7.ReverseInteger;

class Solution {
    public int reverse(int x) {
        int y = 0;
        int temp = 0;
        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        while (x != 0) {
            temp = x % 10;
            x /= 10;
            if (y > max / 10 || (y == max / 10 && temp > max % 10)) return 0;
            if (y < min / 10 || (y == min / 10 && temp < min % 10)) return 0;
            y = y * 10 + temp;
        }
        return y;
    }
}
