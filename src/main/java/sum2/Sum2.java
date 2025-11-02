package sum2;

import java.util.HashMap;
import java.util.Map;

public class Sum2 {

	public int[] solveSum2(int[] nums, int target) {
		int[] result = new int[] {};
		Map<Integer, Integer> seen = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			int delta = target - x;
			Integer otherIdx = seen.get(delta);
			if (otherIdx == null) {
				seen.put(x, i);
			} else {
				result = new int[] { i, otherIdx };
				break;
			}
		}

		return result;
	}

}
