package LongestSubstringWithoutRepeatingCharacters;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        Map<Character, Integer> characterToOccurrences = new HashMap<>();
        characterToOccurrences.put(s.charAt(0), 1);
        int maxSize = 0;

        while (true) {
            if (Collections.max(characterToOccurrences.values()) > 1) {
                int characterOccurrences = characterToOccurrences.get(s.charAt(left));
                characterToOccurrences.put(s.charAt(left), characterOccurrences - 1);
                left++;
            } else {
                maxSize = Math.max(maxSize, (right - left) + 1);
                right++;
                if (right == s.length()) {
                    break;
                }
                int characterOccurrences = characterToOccurrences.getOrDefault(s.charAt(right), 0);
                characterToOccurrences.put(s.charAt(right), characterOccurrences + 1);
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        String a = "abcabcbb"; //-> 3
        System.out.println(lengthOfLongestSubstring(a));
        // String b = "bbbbb";  // -> 1
        // String c = "pwwkew";  //-> 3
    }
}