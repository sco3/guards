package missing;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.List;
import java.util.Set;

public class MissingWordHashMapper {
	public List<String> findMissingWords(String sent, String received) {
		var sentWords = sent.split("\\s+");
		var recvWords = received.split("\\s+");
		var sentMap = new HashMap<String, TreeSet<Integer>>();

		for (int i = 0; i < sentWords.length; i++) {
			var word = sentWords[i];
			var idxs = sentMap.getOrDefault(word, new TreeSet<Integer>());
			idxs.add(i);
			sentMap.put(word, idxs);
		}

		for (var word : recvWords) {
			TreeSet<Integer> idxs = sentMap.get(word);
			if (idxs != null) {
				idxs.removeFirst();
				if (idxs.size() == 0) {
					sentMap.remove(word);
				}
			}
		}
		out.println(sentMap);
		var result = new ArrayList<String>();
		for (int i = 0; i < sentWords.length; i++) {
			var word = sentWords[i];
			var idxs = sentMap.get(word);
			if (idxs != null) {
				if (idxs.size() > 0) {
					result.add(word);
				}

				idxs.remove(i);
				if (idxs.size() == 0) {
					sentMap.remove(word);
				}
			}
		}

		return result;
	}
}