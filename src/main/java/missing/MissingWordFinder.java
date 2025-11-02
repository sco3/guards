package missing;

import java.util.List;
import java.util.ArrayList;

public class MissingWordFinder {
	public static final char EOF = (char) -1;

	public char getc(String s, int pos) {
		if (pos < s.length()) {
			return s.charAt(pos);
		}
		return (char) EOF;
	}

	public List<String> findMissingWords(String sent, String received) {
		List<String> result = new ArrayList<>();
		int pos_s = 0;
		int pos_r = 0;
		StringBuilder wordBuilder = new StringBuilder();

		while (pos_s < sent.length()) {
			String word = null;
			char cs = getc(sent, pos_s);

			char cr = getc(received, pos_r);
			System.out.print(cs);

			if (cs != ' ') {
				wordBuilder.append(cs);
			}

			if (cs == ' ' || pos_s == sent.length()) {
				word = wordBuilder.toString();
				wordBuilder.setLength(0);
			}

			if (pos_r > received.length() && word != null) {
				result.add(word);
			} else if (cs == cr || cr == EOF) {
				pos_r++;
			} else {
				if (word != null && word.length() > 0) {
					result.add(word);
				}
			}

			pos_s++;
		}

		if (wordBuilder.length() > 0 && pos_r > received.length()) {
			result.add(wordBuilder.toString());
		}

		return result;
	}

}