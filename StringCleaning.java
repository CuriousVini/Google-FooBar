package Google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Algorithm: Push string by removing every possibility of word from chunk 
 * @author macretina
 *
 */

public class StringCleaning {

	public static void main(String[] args) {

		String chunk = "aabb";
		String word = "ab";
		System.out.println("answer: " + answer(chunk, word));
	}

	private static String answer(String chunk, String word) {
		Set<String> seen = new HashSet<String>();
		Queue<String> queue = new LinkedList();
		return answerUtil(chunk, word, seen, queue);
	}

	public static String answerUtil(String chunk, String word,
			Set<String> seen, Queue<String> queue) {
		String finalResult = chunk;

		queue.add(chunk);

		while (!queue.isEmpty()) {
			String value = queue.remove();
			int fromIndex = 0;
			while (value.indexOf(word, fromIndex) != -1) {
				int index = value.indexOf(word, fromIndex);
				String remaining = value.substring(0, index)
						+ value.substring(index + word.length());
				fromIndex++;
				if (seen.contains(remaining))
					continue;
				else if (remaining.length() == finalResult.length()) {
					if (remaining.compareTo(finalResult) < 0)
						finalResult = remaining;
				} else if (remaining.length() < finalResult.length())
					finalResult = remaining;
				seen.add(remaining);
				queue.add(remaining);
			}

		}
		return finalResult;
	}

}
