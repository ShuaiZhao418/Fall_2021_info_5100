import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Question2 {
    public static void main(String[] args) {
        // Example1
        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(sortWords(strs1));
        // Example2
        String[] strs2 = {""};
        System.out.println(sortWords(strs2));
        // Example3
        String[] strs3 = {"a"};
        System.out.println(sortWords(strs3));
    }
    // assume n = words.length
    // TC = O(n * nlogn)  assume TC of Arrays.sort is nlogn
    // SC = O(n)

    public static List<List<String>> sortWords (String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        if (words.length == 1 && words[0] == "") {
            List<String> cur = new ArrayList<>();
            cur.add("");
            result.add(cur);
            return result;
        }
        // simple String to Integer
        HashMap<String, Integer> stringToIndex = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char[] array = words[i].toCharArray();
            Arrays.sort(array);
            String simpleString = new String(array);
            if (stringToIndex.get(simpleString) != null) {
                int index = stringToIndex.get(simpleString);
                result.get(index).add(words[i]);
            } else {
                List<String> curWords = new ArrayList<>();
                curWords.add(words[i]);
                result.add(curWords);
                stringToIndex.put(simpleString, result.size() - 1);
            }
        }
        return result;
    }
}
