/**
 * LongestSubstringWithoutRepeatingChars.java
 * 
 * A simple open-source Java program to find the length of the longest substring
 * without repeating characters in a given string.
 **/

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * @param s the input string
     * @return the length of the longest substring without repeating characters
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;

        while (right < s.length()) {
            char current = s.charAt(right);
            if (!seen.contains(current)) {
                seen.add(current);
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                seen.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", "", "dvdf"};

        for (String test : testCases) {
            System.out.printf(
                "Input: \"%s\" → Longest Substring Length: %d%n",
                test,
                lengthOfLongestSubstring(test)
            );
        }
    }
}
