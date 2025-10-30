package randomset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	Random mRandom = new Random();

	Map<Integer, Integer> mMap;
	List<Integer> mList;

	public RandomizedSet() {
		mMap = new HashMap<>();
		mList = new ArrayList<>();
	}

	public boolean insert(int val) {
		boolean ok = false;
		if (null == mMap.get(val)) {
			ok = true;
			mMap.put(val, mList.size());
			mList.add(val);

		}

		return ok;
	}

	public boolean remove(int val) {
		boolean exists = true;
		Integer idx = mMap.get(val);
		if (idx == null) {
			exists = false;
		} else {
			int last = mList.size() - 1;
			if (idx != last) {
				int lastValue = mList.get(last);
				mList.set(idx, lastValue);
				mMap.put(lastValue, idx);
			}

			mList.remove(last);
			mMap.remove(val);
		}
		return exists;

	}

	public int getRandom() {
		int result;
		int size = mList.size();
		int idx = mRandom.nextInt(size);
		result = mList.get(idx);
		return result;

	}
}
