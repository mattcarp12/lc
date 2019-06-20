import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void testLengthOfLongestSubstring() {

        int test1 = Solution.lengthOfLongestSubstring("foo");
        assertEquals(2, test1);

        int test2 = Solution.lengthOfLongestSubstring("bbbbb");
        assertEquals(1, test2);

        int test3 = Solution.lengthOfLongestSubstring("abcabcbb");
        assertEquals(3, test3);

        int test4 = Solution.lengthOfLongestSubstring("pwwkew");
        assertEquals(3, test4);
    }

}
