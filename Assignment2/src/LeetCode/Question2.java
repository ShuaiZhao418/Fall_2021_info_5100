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


    // assume n = words.length
    // TC = O(n^2)
    // SC = O(1)
    public static int shortestDistance(String[] words, String word1, String word2) {
        int minDistance = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2)) {
                        minDistance = Math.min(minDistance, Math.abs(i - j));
                    }
                }
            }
        }
        return minDistance;
    }
}
