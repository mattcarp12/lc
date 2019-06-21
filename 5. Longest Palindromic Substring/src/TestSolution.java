import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {

    @Test
    public void testLongestPalindromicSubstringBF() {
        String test1 = Solution.longestPalindromicSubstringBF("babad");
        assertEquals("bab", test1);

        String test2 = Solution.longestPalindromicSubstringBF("");
        assertEquals("", test2);

        String test3 = Solution.longestPalindromicSubstringBF("a");
        assertEquals("a", test3);

        String test4 = Solution.longestPalindromicSubstringBF("tacocat");
        assertEquals("tacocat", test4);
    }

    @Test
    public void testLongestPalindromicSubstringDP() {
        String test1 = Solution.longestPalindromicSubstringDP("babad");
        assertEquals("bab", test1);

        String test2 = Solution.longestPalindromicSubstringDP("");
        assertEquals("", test2);

        String test3 = Solution.longestPalindromicSubstringDP("a");
        assertEquals("a", test3);

        String test4 = Solution.longestPalindromicSubstringDP("tacocat");
        assertEquals("tacocat", test4);
    }
}
