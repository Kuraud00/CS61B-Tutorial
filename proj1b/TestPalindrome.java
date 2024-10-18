import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /* You must use this palindrome, and not instantiate
     new Palindromes, or the autograder might be upset.*/
    static Palindrome palindrome = new Palindrome();
    static OffByOne offbyone = new OffByOne();
    static OffByN offbyn = new OffByN(3);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("after"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testOffByOnePalindrome(){
        assertFalse(palindrome.isPalindrome("horse",offbyone));
        assertTrue(palindrome.isPalindrome("flake",offbyone));
    }

    @Test
    public void testOffByNPalindrome(){
        assertTrue(palindrome.isPalindrome("abhed",offbyn));
        assertFalse(palindrome.isPalindrome("flake",offbyn));
    }
}
