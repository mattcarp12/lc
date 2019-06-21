import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {

    @Test
    public void testLongestPalindromicSubstringBF() {
        String test1 = Solution.longestPalindromicSubstringBF("babad");
        assertEquals("bab", test1);
    }
}
