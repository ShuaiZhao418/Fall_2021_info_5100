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

    // assume m = s.length
    // TC = O(m)
    // SC = O(1)

    public static boolean checkIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
