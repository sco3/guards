package missing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;



class MissingWordFinderTest {

	private void test_pair(String sent, String received, String[] expected) {
		MissingWordFinder finder = new MissingWordFinder();
		List<String> result = finder.findMissingWords(sent, received);
		System.out.println("\n---\n");
		System.out.println("SENT:     " + sent);
		System.out.println("RECEIVED: " + received);
		System.out.println("MISSING:");
		for (String s : result) {
			System.out.println('"' + s + '"');
		}
		assertArrayEquals(expected, result.toArray());
	}

	@Test
	void test1() {
		String sent = "a b a b  c";
		String received = "b c";
		// Expected: 'b' from sent (second occurrence) matches 'b' from received, 
		// and 'c' matches. The missing words are 'a', 'a', and the last 'b'.
		test_pair(sent, received, new String[] { "a", "a", "b" });
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
	void test3_repeatingWords() {
		String sent = "I like blue dogs and I like blue cats";
		String received = "like dogs and blue";
		
		// Sequential matching logic:
		// 1. Sent 'I' does not match Received 'like' -> MISSING: I
		// 2. Sent 'like' matches Received 'like' (Received pointer shifts to 'dogs')
		// 3. Sent 'blue' does not match Received 'dogs' -> MISSING: blue
		// 4. Sent 'dogs' matches Received 'dogs' (Received pointer shifts to 'and')
		// 5. Sent 'and' matches Received 'and' (Received pointer shifts to 'blue')
		// 6. Sent 'I' does not match Received 'blue' -> MISSING: I
		// 7. Sent 'like' does not match Received 'blue' -> MISSING: like
		// 8. Sent 'blue' matches Received 'blue' (Received is now empty)
		// 9. Sent 'cats' (Received is empty) -> MISSING: cats
		test_pair(sent, received, new String[] { "I", "blue", "I", "like", "cats" });
	}
}
