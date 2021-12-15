import java.util.HashMap;

public class Question3 {
    public static void main(String[] args) {
        // Example1
        int[] num = {1, 1, 1};
        System.out.println(maxSumToK(num, 2));
        // Example2
        int[] num2 = {1, 2, 3};
        System.out.println(maxSumToK(num2, 3));
    }
    // assume n = nums.length
    // TC = O(n) SC = O(n)
    public static int maxSumToK(int[] nums, int k) {
        // corner case check
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int count = 0;
        // sum to times
        HashMap<Integer, Integer> sumToTimes = new HashMap<>();
        sumToTimes.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToTimes.containsKey(sum - k)) {
                count += sumToTimes.get(sum - k);
            }
            if (sumToTimes.containsKey(sum)) {
                sumToTimes.put(sum, sumToTimes.get(sum) + 1);
            } else {
                sumToTimes.put(sum, 1);
            }
        }
        return count;
    }
}
