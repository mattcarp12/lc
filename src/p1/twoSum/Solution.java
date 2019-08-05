/**
 * 
 */
package p1.twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mcarpenter
 *
 */

public class Solution {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]))
				return new int[] { map.get(nums[i]), i };
			map.put(target - nums[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		int[] nums = {100, 50, 99, 20, 30, 48, 77};
		int target = 127;
		System.out.println(twoSum(nums, target)[1]);
	}
}

