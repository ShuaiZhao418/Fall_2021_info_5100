package LeetCode;

public class Question8 {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(checkPalindrome("race a car"));
    }
    // assume n = str.length
    // TC = O(n)
    // SC = O(1)
    public static boolean checkPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
}
