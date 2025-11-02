package sum2;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class TestSum2 {

	@Test
	void test() {
		Sum2 tester = new Sum2();
		int[] result = tester.solveSum2( //
				new int[] { 1, 4, 3, 6, 5, 8 }, //
				8 //
		);
		assertNotNull(result);
		assertEquals( //
				stream(result).boxed().collect(Collectors.toSet()), //
				Set.of(2, 4) //
		);
	}

}
