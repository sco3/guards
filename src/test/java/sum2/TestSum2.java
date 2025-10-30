package sum2;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class TestSum2 {

	@Test
	void test() {
		Sum2 tester = new Sum2();
		Optional<int[]> result = tester.solveSum2( //
				new int[] { 1, 4, 3, 6, 5, 8 }, //
				8 //
		);
		assertTrue(result.isPresent());
		assertEquals( //
				stream(result.get()).boxed().collect(Collectors.toSet()), //
				Set.of(2, 4) //
		);
	}

}
