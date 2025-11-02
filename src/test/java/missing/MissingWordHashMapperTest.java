package missing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class MissingWordHashMapperTest {

	private void test_pair(String sent, String received, String[] expected) {
		var finder = new MissingWordHashMapper();
		List<String> result = finder.findMissingWords(sent, received);
		System.out.println("\n---\n");
		System.out.println("SENT:     " + sent);
		System.out.println("RECEIVED: " + received);
		System.out.println("MISSING:");
		for (String s : result) {
			System.out.println('"' + s + '"');
		}
		assertArrayEquals(expected, result.toArray(new String[] {}));
	}

	@Test
	void test1() {
		String sent = "a b a b  c";
		String received = "b c";
		// Expected: 'b' from sent (second occurrence) matches 'b' from received,
		// and 'c' matches. The missing words are 'a', 'a', and the last 'b'.
		test_pair(sent, received, new String[] { "a", "b", "a" });
	}

	@Test
	void test2() {
		String sent = "The Python is a programming lang to create programs quickly";
		String received = "Python is lang to";
		// Matched words: "Python", "is", "lang", "to"
		// Missing words: "The", "a", "programming", "create", "programs", "quickly"
		test_pair(sent, received, new String[] { //
				"The", "a", "programming", "create", "programs", "quickly" //
		});
	}

	@Test
	void test3() {
		String sent = "I like blue dogs and I like blue cats";
		String received = "like dogs and blue";

		test_pair(sent, received, new String[] { "I", "like", "blue", "I", "cats" });
	}
}
