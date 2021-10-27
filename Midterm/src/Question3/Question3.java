package Question3;

import java.util.HashSet;

public class Question3 {
    public static void main(String[] args) {
        int[] array = {1,3,-1,3,4,-1};
        System.out.println(findRepeatElements(array));
    }

//    Question 3) For the given array, return the sum of all the numbers which are repeated.
//
//    Ex: Input : array = {1,3,-1,3,4,-1}
//    Output : 3 + (-1) = 2

    // assume n = array.length
    // TC = O(n)
    // SC = O(n)
    public static int findRepeatElements(int[] array) {
        // corner case check
        if (array == null || array.length == 0) {
            return 0;
        }
        // set a hashset to check the repeat elements
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                sum += array[i];
            }
            set.add(array[i]);
        }
        return sum;
    }
}
