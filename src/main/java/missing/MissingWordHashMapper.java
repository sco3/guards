package missing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MissingWordHashMapper {
	public List<String> findMissingWords(String sent, String received) {
		var sentWords = sent.split("\\s+");
		var recvWords = received.split("\\s+");
		var sentMap = new HashMap<String, Integer>();
		for (var word : sentWords) {
			sentMap.put(word, 1 + sentMap.getOrDefault(word, 0));
		}

		for (var word : recvWords) {
			var count = sentMap.get(word);
			if (count != null) {
				count--;
				if (count == 0) {
					sentMap.remove(word);
				} else {
					sentMap.put(word, count);
				}
			}
		}
		var result = new ArrayList<String>();
		for (var entry : sentMap.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				result.add(entry.getKey());
			}
		}

		return result;
	}
}