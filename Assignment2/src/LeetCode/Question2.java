package LeetCode;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Question2 {
    public static void main(String[] args) {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        System.out.println(shortestDistance(wordsDict, word1, word2));

        String word3 = "makes";
        System.out.println(shortestDistance(wordsDict, word1, word3));
    }


    // assume m = word1.length(), n = word2.length(), z = wordDict.length
    // TC = O(z * (m + n))
    // SC = O(1)
    public static int shortestDistance(String[] wordDict, String word1, String word2) {
        // corner case check
        if (wordDict == null || wordDict.length <= 1) {
            return -1;
        }
        // define two pointers i and j
        // i point to position of word1
        int i = Integer.MAX_VALUE;
        // j point to position of word2
        int j = Integer.MIN_VALUE;
        // define min to record the minimum value
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < wordDict.length; k++) {
            if(wordDict[k] == word1) {
                i = k;
            }
            if(wordDict[k] == word2) {
                j = k;
            }
            min = Math.min(min, Math.abs(i - j));
        }
        return min;
    }
}
