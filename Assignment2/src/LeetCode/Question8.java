package LeetCode;

public class Question8 {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(checkPalindrome("race a car"));
    }
    // assume n = str.length
    // TC = O(n)
    // SC = O(n)
    public static boolean checkPalindrome(String str) {
        // corner case check
        if (str == null || str.length() <= 1) {
            return true;
        }
        // store all the valid character into a char[]
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                sb.append(str.charAt(i));
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sb.append((char) (str.charAt(i) - 'A' + 'a'));
            }
        }
        // check Palindrome
        int i = 0;
        int j = sb.length() - 1;
        while(i < j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
