import java.util.HashMap;

public class Assignment1 {
    public static void main(String[] args) {
        // Question 1:
        int[] array1 = {1, 2, 3, 2};
        int[] array2 = {1, 1, 1, 1};
        System.out.println(findUniqueElements(array1));
        System.out.println(findUniqueElements(array2));

        // Question 2:
        int[] array3 = {-4, -1, 0, 3, 10};
        int[] array4 = {-7, -3, 2, 3, 11};
        System.out.println(makeSquares(array3));
        System.out.println(makeSquares(array4));

        // Question 3:
        int[] array5 = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6};
        int[] array6 = {2 ,3, 4, 2, 2, 3, 5, 7};
        System.out.println(findFirstUnrepeat(array5));
        System.out.println(findFirstUnrepeat(array6));

        // Question 4:
        String ransomNote1 = "aab";
        String magazine1 = "abbc";
        System.out.println(constructString(ransomNote1, magazine1));
        String ransomNote2 = "aaabb";
        String magazine2 = "aaba";
        System.out.println(constructString(ransomNote2, magazine2));

//      Question 5:
        String s1 = "1A3d4s5t";
        String s2 = "A2bb2d4";
        System.out.println(checkDigitAndLetter(s1));
        System.out.println(checkDigitAndLetter(s2));
    }

//    Question 1: You are given an integer array nums. The unique elements of an array are the elements that
//    appear exactly once in the array. Return the sum of all the unique elements of nums.

    // 1. we sort it into ascending order
    // 2. we use two pointers i and j, [0, i) are the unique elements, [j -> ~) are the elements to be checked
    // 3. we add the elements in range [0, i)
    //  2 1 2 3 4 5 6
    //    i
    //      j
    // case 1: if array[j] == array[i - 1], j++ until array[j] != array[i - 1], i--
    // case 2: else, array[i] == array[j], i++, j++

    // assume n is the length of array
    // TC = O(nlogn) + O(n) = O(nlogn)   SC = O(logn)
    public static int findUniqueElements(int[] array) {
        // corner case check
        if (array == null || array.length == 0) {
            return 0;
        }
        // sort the array
        quickSort(array, 0, array.length - 1);
        // set two pointers
        int i = 1;
        int j = 1;
        while (j < array.length) {
            if (i != 0 && array[j] == array[i - 1]) {
                while(j < array.length && array[j] == array[i - 1]) {
                    j++;
                }
                i--;
            } else {
                array[i] = array[j];
                i++;
                j++;
            }
        }
        // sum all the element from index 0 to i - 1
        int count = 0;
        for (int k = 0; k < i; k++) {
            count += array[k];
        }
        return count;
    }
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pos = partition(array, low, high);
            quickSort(array, low, pos - 1);
            quickSort(array, pos + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int wall = low - 1;
        for (int i = low; i < high; i++) {
            if (array[i] < pivot) {
                wall++;
                swap(array, i, wall);
            }
        }
        wall++;
        swap(array, high, wall);
        return wall;
    }
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

//  Question 2: Given an integer array nums sorted in non-decreasing order, return an array of the squares of
//  each number sorted in non-decreasing order.

    // 1, we make a square of every negative number
    // 2. use quick to sort it

    // assume n is the length of array
    // TC = O(n) + O(nlogn) = O(nlogn)    SC = O(logn)
    public static int[] makeSquares(int[] array) {
        // corner case check
        if (array == null || array.length <= 1) {
            return array;
        }
        // traverse the array make squares to every negative numbers
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = array[i] * array[i];
            } else {
                break;
            }
        }
        // use quick sort to sort the array
        quickSort(array, 0, array.length - 1);

        return array;
    }

//    Question 3: Find first non repeated integer in an array. (similar to question 1)

    // 1. we use quick sort to sort it into ascending order
    // 2. we use two pointers i and j, [0, i) are the unique elements, [j -> ~) are the elements to be checked
    // 3. we add the elements in range [0, i)
    //  1 1 2 3 4 5 6
    //    i
    //    j
    // case 1: if array[j] == array[i - 1], j++ until array[j] != array[i - 1], i--
    // case 2: else, array[i] == array[j], i++, j++

    public static int findFirstUnrepeat(int[] array) {
        // corner case check
        if (array == null || array.length == 0) {
            return 0;
        }
        // sort the array
        quickSort(array, 0, array.length - 1);
        // set two pointers
        int i = 1;
        int j = 1;
        while (j < array.length && i <= 2) {
            if (i != 0 && array[j] == array[i - 1]) {
                while(j < array.length && array[j] == array[i - 1]) {
                    j++;
                }
                i--;
            } else {
                array[i] = array[j];
                i++;
                j++;
            }
        }
        return array[0];
    }

//    Question 4: Given two stings ransomNote and magazine, return true if ransomNote can be constructed
//    from magazine and false otherwise. Each letter in magazine can only be used once in ransomNote.

      // 1. use two HashMap<Character, Integer> to store two String separately
      // 2. traverse the hashmap of ransomNote and compare the Integer of each words with magazine's

    // assume ransomNote.length() = m, magazine.length() = n
    // TC = O(2m + n)       SC = O(m + n)
    public static boolean constructString(String ransomNote, String magazine) {
        // corner case check
        if (magazine == null || magazine.length() < ransomNote.length()) {
            return false;
        }
        if (ransomNote == null) {
            return true;
        }
        // define two HashMaps and store two Strings into HashMaps
        HashMap<Character, Integer> ran = storeString(ransomNote);
        HashMap<Character, Integer> mag = storeString(magazine);
        // traverse hashmap of ransomNote
        for (Character key : ran.keySet()) {
            Integer ranNum = ran.get(key);
            Integer magNum = mag.get(key);
            if (magNum == null || ranNum > magNum) {
                return false;
            }
        }
        return true;
    }
    private static HashMap<Character, Integer> storeString(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashmap.get(s.charAt(i)) == null) {
                hashmap.put(s.charAt(i), 1);
            } else {
                hashmap.put(s.charAt(i), hashmap.get(s.charAt(i)) + 1);
            }
        }
        return hashmap;
    }

//    Question 5: Letter followed by Digit: Given a string str write a function which will check if the string no
//    letter followed by another letter, and no digit followed by another digit.

    // 1. if the first word is a letter, elements at all even indexs is a letter, elements at all odd indexs is a digit
    // 2. if the first is a digit

    // we need to check by judging index is odd or even to check it is a digit or letter

    // assume n is the length of s
    // TC = O(n) SC = O(1)
    public static boolean checkDigitAndLetter(String s) {
        // corner case check
        if (s == null || s.length() == 0) {
            return true;
        }
        // check the element at index 0
        // first element is a number
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
            for (int i = 1; i < s.length(); i++) {
                if ((i % 2 == 0 && (s.charAt(i) < '0' || s.charAt(i) > '9'))
                || (i % 2 == 1 && (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
                    return false;
                }
            }
        } else if ((s.charAt(0) >= 'a' && s.charAt(0) <= 'z')
        || (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') ){  // first element is a letter
            for (int i = 1; i < s.length(); i++) {
                if ((i % 2 == 0 && (s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                        || (i % 2 == 1 && (s.charAt(i) < '0' || s.charAt(i) > '9'))) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }


}
