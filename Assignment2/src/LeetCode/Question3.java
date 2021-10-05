package LeetCode;

public class Question3 {
    public static void main(String[] args) {
        int[] array1 = {0,1,0,3,12};
        remove(array1);
        int[] array2 = {0};
        remove(array2);
    }
    // count the number of 0
    // put non-zero number to front part, sign in 0 to back part

    // assume n = array.length
    // TC = O(n)
    // SC = O(1)
    public static int[] remove(int[] array) {
        // corner case check
        if (array == null || array.length == 0) {
            return array;
        }
        //
        int i = 0;
        int count = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == 0) {
                count++;
            } else {
                array[i] = array[j];
                i++;
            }
        }
        while (count > 0) {
            array[i] = 0;
            i++;
            count--;
        }
        return array;
    }
    private static void swap(int[] array, int i, int j) {
        int num = array[i];
        array[i] = array[j];
        array[j] = num;
    }
}
