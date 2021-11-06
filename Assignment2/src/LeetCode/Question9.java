package LeetCode;

public class Question9 {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords(" hello world "));
    }
    // assume n = str.length()
    // TC = O(n)
    // SC = O(1)
    public static String reverseWords(String input) {
        // corner case check
        if (input == null || input.length() <= 1) {
            return input;
        }
        // convert input to array
        char[] array = input.toCharArray();
        // reverse the whole string
        reverse (array, 0, array.length - 1);
        // reverse each single word
        // set two pointers
        int i = 0;
        int j = 0;

        while (j < array.length) {
            if (array[j] != ' ' && (j == 0 || array[j - 1] == ' ')) {
                i = j;
            } else if (array[j] != ' ' && (j == array.length - 1 || array[j + 1] == ' ')) {
                reverse(array, i, j);
            }
            j++;
        }
        return cleanSpaces(array);
    }
    private static void reverse(char[] array, int left, int right) {
        if(array == null || array.length == 0) {
            return ;
        }
        while (left <= right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }
    private static void swap(char[] array, int i, int j) {
        char num = array[i];
        array[i] = array[j];
        array[j] = num;
    }
    public static String cleanSpaces(char[] a) {
        int i = 0, j = 0;
        int n = a.length;
        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }
}
