
import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class TestSolution {
	private void testWithParams(int elemCount, final int swapCount, int[] swaps, int[] expected) {
		Solution solution = new Solution();
		int[] result = solution.solve(elemCount, swapCount, swaps);
		for (int i : result) {
			out.print(i + " ");
		}
		out.println();

		assertArrayEquals(expected, result);
	}

	@Test
	void test1() {
		int elemCount = 5;
		final int swapCount = 6;

		//@formatter:off
		int[] swaps = { 
				2, 6, 
				4, 7, 
				1, 3, 
				7, 2, 
				7, 9, 
				3, 9 
		};
		//@formatter:on
		int[] expected = { 4, 3, 3, 4, 4, 3 };

		testWithParams(elemCount, swapCount, swaps, expected);
	}

	@Test
	void test2() {
		int elemCount = 3;
		final int swapCount = 3;

		//@formatter:off
		int[] swaps = { 
				3, 4, 
				4, 5, 
				5, 3, 
		};
		//@formatter:on
		int[] expected = { 2, 2, 3 };

		testWithParams(elemCount, swapCount, swaps, expected);
	}

}