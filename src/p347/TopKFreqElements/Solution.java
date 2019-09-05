package p347.TopKFreqElements;

import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // First make a hashmap where keys are the num and value is the frequency
        Map<Integer, Integer> freq = makeFreqHashMap(nums);

        // Next convert map to list of lists
        List<List<Integer>> list = makeListOfLists(freq);

        // Sort the list based on value (i.e. second entry in each pair)
        sortListOfPairs(list);

        // Finally put first k keys in a new list and return that
        return getFirstKKeys(list, k);
    }

    Map<Integer, Integer> makeFreqHashMap(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer i : nums) {
            if (freq.containsKey(i)) freq.put(i, freq.get(i) + 1);
            else freq.put(i, 1);
        }
        return freq;
    }

    List<List<Integer>> makeListOfLists(Map<Integer, Integer> map) {
        List<List<Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> pair = new ArrayList<>();
            pair.add(entry.getKey());
            pair.add(entry.getValue());
            list.add(pair);
        }
        return list;
    }

    void sortListOfPairs(List<List<Integer>> list) {
        Collections.sort(list, (l1, l2) -> l1.get(1) < l2.get(1) ? 1 : l1.get(1) > l2.get(1) ? -1 : 0);
    }

    List<Integer> getFirstKKeys(List<List<Integer>> list, int k) {
        List<Integer> returnList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            returnList.add(list.get(i).get(0));
        }
        return returnList;
    }
}
