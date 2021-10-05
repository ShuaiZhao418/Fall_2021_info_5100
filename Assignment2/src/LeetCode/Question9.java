package LeetCode;

public class Question9 {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords(" hello world "));
    }
    // assume n = str.length()
    // TC = O(n)
    // SC = O(1)
    public static String reverseWords(String str) {
        // corner case check
        if (str == null || str.length() <= 1) {
            return str;
        }
        // convert the whole string to char[]
        char[] array = str.toCharArray();
        // reverse the whole string
        reverse(array, 0, array.length - 1);
        // reverse word one by one
        int i = 0;
        int j = 0;
        while (j < array.length) {
            if (array[j] != ' ' && (j == 0 || array[j - 1] == ' ')) {
                i = j;
            }
            if (array[j] !=' ' && (j == array.length - 1 || array[j + 1] == ' ')) {
                reverse(array, i, j);
            }
            j++;
        }
        // find the position of the begin and end of the string
        int beg = 0;
        int end = array.length - 1;
        while (beg < array.length) {
            if (array[beg] != ' ') {
                break;
            }
            beg++;
        }
        while (end >= 0) {
            if (array[end] != ' ') {
                break;
            }
            end--;
        }
        return new String(array, beg, end);
    }
    public static void reverse(char[] array, int i, int j) {
        while (i <= j) {
            char cur = array[i];
            array[i] = array[j];
            array[j] = cur;
            i++;
            j--;
        }
    }
}
