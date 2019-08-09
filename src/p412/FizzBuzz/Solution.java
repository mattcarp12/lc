package p412.FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        int i = 1;
        List<String> list = new ArrayList();
        while (i <= n) {
            if (i % 15 == 0) list.add("FizzBuzz");
            else if (i % 5 == 0) list.add("Buzz");
            else if (i % 3 == 0) list.add("Fizz");
            else list.add(Integer.toString(i));
            i++;
        }
        return list;
    }
}