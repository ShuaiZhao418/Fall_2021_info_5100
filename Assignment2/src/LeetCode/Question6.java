package LeetCode;

import java.util.HashMap;

public class Question6 {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(checkIsomorphic(s, t));
        s = "foo";
        t = "bac";
        System.out.println(checkIsomorphic(s, t));
    }

    // replace character in the position of word1 by character in two
    // and store the change into a hashmap, when finish, compare two strings
    // assume m = s.length, n = t.length
    // TC = O(m)
    // SC = O(m)

    public static boolean checkIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        // convert s and t to array
        char[] string = s.toCharArray();
        char[] target = t.toCharArray();
        // define a hashmap<s's character, t's character> to store change relationship
        HashMap<Character, Character> hashmap = new HashMap<>();
        // traverse string s, and change characters in t to characters in s
        for (int i = 0; i < target.length; i++) {
            if (target[i] == string[i]) {
                continue;
            }
            if (hashmap.containsKey(string[i])) {
                string[i] = hashmap.get(string[i]);
            } else {
                hashmap.put(string[i], target[i]);
                string[i] = target[i];
            }
        }
        for (int i = 0; i < target.length; i++) {
            if (string[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
