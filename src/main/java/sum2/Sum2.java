package sum2;

import static java.util.Optional.empty;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Sum2 {

	public Optional<int[]> solveSum2(int[] nums, int target) {
		Optional<int[]> result = empty();
		Map<Integer, Integer> seen = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			int delta = target - x;
			Integer otherIdx = seen.get(delta);
			if (otherIdx == null) {
				seen.put(x, i);
			} else {
				result = Optional.of(new int[] { i, otherIdx });
				break;
			}
		}

		return result;
	}

}
