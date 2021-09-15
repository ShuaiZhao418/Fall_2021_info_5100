package src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class Class1 {

    public static void main(String[] args) {
        int[] arr = {6,5,3,1,8,7,2,4};
//        bubbleSort(arr);
//        selectionSort(arr);
//        mergeSort(arr, 0, arr.length - 1);
//        quickSort(arr, 0, arr.length - 1);
//        countSort(arr, 9);
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(-5, 0));
        intervals.add(new Interval(-2, 1));
        intervals.add(new Interval(10, 11));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(9, 13));
        intervals.add(new Interval(3, 6));
        ArrayList<Interval> merged = mergeIntervals(intervals);
//        printArray(arr);

    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        // corner case check
        if (arr == null || i < 0 || i > arr.length - 1 || j < 0 || j > arr.length - 1) {
            return ;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // BubbleSort
    // TC = O(n^2)
    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    // Selection Sort
    // TC = O(n^2)
    // SC = O(1)
    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(array, i, min);
            }
        }
    }

    // Merge Sort   TC = O(n) + O(n * logn) = O(nlogn) / SC = O(logn + n) = O(n)
    private static void mergeSort(int[] array, int low, int high) {
        // base case
        if (low >= high) {
            return;
        }
        // recursion rule
        int mid = low + (high - low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);

        merge(array, low, high);
    }
    private static void merge(int[] array, int low, int high) {
        int mid = low + (high - low) / 2;
        int[] result = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // merge
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                result[k] = array[i];
                i++;
            } else {
                result[k] = array[j];
                j++;
            }
            k++;
        }
        // post processing
        while (i <= mid) {
            result[k] = array[i];
            i++;
            k++;
        }
        while (j <= high) {
            result[k] = array[j];
            j++;
            k++;
        }
        i = low;
        for (int value : result) {
            array[i] = value;
            i++;
        }
    }
    // quick sort  -->  TC = O(nlogn)
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

    // quick sort --> find the second largest question
    private static void findKthLargest(int[] array, int k, int low, int high) {
        if (low < high) {
            int pos = partition(array, low, high);
            if (pos == array.length - k) {
                System.out.println("Value = " + array[pos]);
                return ;
            }
            findKthLargest(array, k, low, pos - 1);
            findKthLargest(array, k, pos + 1, high);
        }
    }
    // count Sort   TC = O(n)  SC = O(n)
    private static void countSort(int[] array, int RANGE) {
        int[] countArr = new int[RANGE];
        for (int j : array) {
            countArr[j]++;
        }
        int index = 0;
        for (int i = 0; i < RANGE; i++) {
            while(countArr[i] > 0) {
                array[index] = i;
                index++;
                countArr[i]--;
            }
        }
    }

    // rainbow sort / DutchFlag Problem  TC = O(n)
    private void dutchFlagProblems(int[] array, int pivot) {
        int i = 0;
        int j = 0;
        int k = array.length - 1;
        while (j <= k) {
            if (array[j] < pivot) {
                swap(array, j, i);
                i++;
                j++;
            } else if (array[j] > pivot) {
                swap(array, j, k);
                k--;
            } else {
                j++;
            }
        }
    }

    // merge interval  TC = O(n + nlogn) = O(nlogn)
    private static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        // we need to sort all the intervals first TC = O(n*logn)
        intervals.sort(new Comparator<Interval>() {
               @Override
               public int compare(Interval x, Interval y) {
                   return Integer.compare(x.start, y.start);
               }
           }

        );

        Stack<Interval> stack = new Stack<>();
        stack.push(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval top = stack.peek();
            Interval current = intervals.get(i);
            if (top.end < current.start) {
                stack.push(intervals.get(i));
            } else if (top.end < current.end) {
                top.end = current.end;
                stack.pop();
                stack.push(top);
            }
        }
        ArrayList<Interval> merged = new ArrayList<>();

        while(stack.size() != 0) {
            merged.add(stack.pop());
        }
        return merged;
    }

    // Arrays.sort(array);
}
class Interval {
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
