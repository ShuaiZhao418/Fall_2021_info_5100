package src.assignment1;

import java.util.*;

public class Assignment1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
//        Question 1:
//        sortColor(array);

//        Question 2:
//        ArrayList<interval> intervals = new ArrayList<>();
//        intervals.add(new interval(-5,0));
//        intervals.add(new interval(-2,1));
//        intervals.add(new interval(10,11));
//        intervals.add(new interval(5,7));
//        intervals.add(new interval(9,13));
//        intervals.add(new interval(3,6));
//        System.out.println(mergeInterval(intervals));

//        Question 3:
//        System.out.println(findAllMins(array));

//        Question 4:
//        sortArray(array);

//        Question 5:
//        System.out.println(checkAnagram("abcd", "dabc"));

//        Question 6:
//        sortEvenAndOdd(array);

        printArray(array);

    }
    private static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print( i + ", ");
        }
        System.out.println();
    }

//     Question 1: Given an array nums with n objects colored red, white, or blue,
//     sort them in-place so that objects of the same color are adjacent, with the
//     colors in the order red, white, and blue.
//
//     0-red / 1-white / 2-blue
//
//     assume n is the length of nums
//     TC = O(n) SC = O(1)
    public static void sortColor(int[] nums) {
        // corner case check
        if (nums == null || nums.length <= 1) {
            return ;
        }
        // set three pointers
        // 0 - (i-1) red, i - (j-1) white, (k+1) - (nums.length-1) blue
        // j - k are the elements that we need to judge
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        while (j <= k) {
            if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] == 1) {
                j++;
            } else {
                swap(nums, j, k);
                k--;
            }
        }
    }
    public static void swap(int[] array, int i, int j) {
        int k = array[i];
        array[i] = array[j];
        array[j] = k;
    }

//    Question 2: Given an array of meeting time intervals where intervals[i] = [starti, endi],
//    determine if a person could attend all meetings.

//    assume n is number of pairs of the intervals
//    TC = sort: O(nlogn) + merge O(n) = O(nlogn)   SC = at most O(n)
    public static boolean mergeInterval(ArrayList<interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return true;
        }
        // 1. sort the intervals by interval.start
        intervals.sort(new Comparator<interval>() {
            @Override
            public int compare(interval x, interval y) {
                return Integer.compare(x.start, y.start);
            }
        });

        Stack<interval> stack = new Stack<>();
        stack.push(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            interval top = stack.peek();
            interval current = intervals.get(i);
            if (top.end < current.start) {
                stack.push(current);
            } else if (top.end < current.end) {
                top.end = current.end;
                stack.pop();
                stack.push(top);
            }
        }
        if (stack.size() == 1) {
            return true;
        } else {
            return false;
        }
    }
//    Question 3: Given an integer array nums of 2n integers, group these
//    integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi)
//    for all i is maximized. Return the maximized sum.

    // 1. sort the given array
    // 2. make n pairs to make the number (ai - bi) smaller
    // 3. add all min(ai, bi)

    // assume n is the length of array
    // TC = O(n/2), SC = O(1)
    public static int findAllMins(int[] array) {
        if (array == null || array.length <= 1) {
            return -1;
        }
        quickSort(array, 0, array.length - 1);

        int sum = 0;

        for (int i = 0; i < array.length; i += 2) {
            sum += array[i];
        }
        return sum;
    }



//    Question 4: Given an integer array nums sorted in non-decreasing order,
//    return an array of the squares of each number sorted in non-decreasing order.
//    1. make a square to every negative number
//    2. quick sort

//    assume n is the length of array
//    TC = O(n + nlogn) = O(nlogn)  SC = O(logn)
    public static void sortArray(int[] array) {
        // corner case check
        if (array == null || array.length <= 1) {
            return ;
        }
        // 1. make a square to every negative numbers
        int k = 0;
        while (array[k] < 0) {
            array[k] = array[k] * array[k];
            k++;
        }
        quickSort(array, 0, array.length - 1);
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

//    Question 5: Given two strings s and t, return true if t is an anagram of s,and false otherwise.
//    store two string into maps, and compare the two map

//    assume the length of string s is x, string t is y
//    TC = O(2x + y) SC = O(x + y)
    public static boolean checkAnagram(String s, String t) {
        // store two strings into two maps
        Map<Character, Integer> map1 = storeString(s);
        Map<Character, Integer> map2 = storeString(t);
        // compare two maps
        if (map1.equals(map2)) {
            return true;
        } else {
            return false;
        }
    }
    private static Map<Character, Integer> storeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        return map;
    }


//    Question 6: Given an integer array nums, move all the even integers at the
//    beginning of the array followed by all the odd integers.
//    Return any array that satisfies this condition.

//    assume n is the length of array
//    TC = O(n)  SC = O(1)
    public static void sortEvenAndOdd(int[] array) {
        // corner case check
        if (array == null || array.length <= 1) {
            return ;
        }
        // set two pointers, i at 0 and j at end of the array
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] % 2 == 0) {
                i++;
            } else {
                swap(array, i, j);
                j--;
            }
        }
    }
}

class interval {
    int start;
    int end;

    public interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}