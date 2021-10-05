package LeetCode;

public class Question10 {
    public static void main(String[] args) {
        char[] array1 = {'a','a','b','b','c','c','c'};
        char[] array2 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compressString(array1));
        System.out.println(compressString(array2));
    }
    // assume n = input.length
    // TC = O(n)
    // SC = O(1)
    public static int compressString(char[] input) {
        // corner case check
        if (input == null || input.length <= 0) {
            return 0;
        }
        int index = 0;
        int i = 0;
        while (i < input.length) {
            int j = i;
            while (j < input.length && input[j] == input[i]) {
                j++;
            }
            input[index] = input[i];
            index++;
            if (j - i > 1) {
                String count = j - i + "";
                for (char c : count.toCharArray()) {
                    input[index] = c;
                    index++;
                }
            }
            i = j;
        }
        return index;
    }
}
