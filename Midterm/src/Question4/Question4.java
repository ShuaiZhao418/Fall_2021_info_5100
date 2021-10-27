package Question4;

import java.util.HashSet;

public class Question4 {
    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(findLongestString(s));
    }
//    Question 4) Given a string s, find the longest substring without repeating characters.
//
//    Ex: Input: s = "abcabcbb"
//    Output: abc
//    Explanation: The answer is "abc", with the length of 3.

    // assume n is the length of input
    // TC = O(n)
    // SC = O(n)
    public static String findLongestString(String input) {
        // corner case check
        if (input == null || input.length() == 0) {
            return "";
        }
        char[] array = input.toCharArray();
        // set a HashSet to check the repeat elements
        // and set two pointers to note the longest substring without repeating characters
        HashSet<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int i = 0;
        int max = 0;
        int maxLeft = 0;
        int maxRight = 0;
        while (i < array.length) {
            if (set.contains(array[i])) {
                set.remove(array[i]);
                slow++;
            } else {
                set.add(array[i]);
                fast++;
                i++;
            }
            if (fast - slow > max) {
                max = fast - slow;
                maxLeft = slow;
                maxRight = fast;
            }
        }
        return input.substring(maxLeft, maxRight);
    }

}
