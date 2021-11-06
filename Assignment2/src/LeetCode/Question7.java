package LeetCode;


import java.util.ArrayList;
import java.util.List;

public class Question7 {
    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
        System.out.println(addStrings("77", "456"));
    }

    // assume n = num1.length, m = num2.length (n >= m)
    // TC = O(m)
    // SC = O(m)
    public static String addStrings(String num1, String num2) {
        // corner case check
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }

        List<Integer> result = new ArrayList<>();
        int val = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0 || val != 0) {
            if (i >= 0) {
                val += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                val += num2.charAt(j) - '0';
                j--;
            }
            result.add(val % 10);
            val = val / 10;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int z = result.size() - 1; z >= 0; z--) {
            sb.append(result.get(z));
        }
        return new String(sb);
    }

}
