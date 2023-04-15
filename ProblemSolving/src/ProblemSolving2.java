import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ProblemSolving2 {

	public static boolean validateString(String stringValue) {
		if (stringValue.length() < 1 || stringValue.length() > 2000) {
			return false;
		}
		return true;
	}

	public static char[] reverseWord(char word[], int x, int y) {
		String unArrangedString = new String(word).substring(x, y + 1);
		Stack<Character> result = new Stack<>();
		Queue<Character> arranedStringqueue = new LinkedList<>();
		String arranedString = "";
		for (char c : unArrangedString.toCharArray()) {
			result.push(c);
		}
		while (!result.isEmpty()) {
			arranedStringqueue.add(result.pop());
		}
		while (!arranedStringqueue.isEmpty()) {
			arranedString = arranedString + arranedStringqueue.remove();
		}
		String wordString = new String(word);
		wordString = wordString.replace(wordString.substring(x, y + 1), arranedString);
		word = wordString.toCharArray();
		return word;
	}

	// applies reverse on all available String between ()
	public static String prepareString(String wordWantedAsReversed) {
		boolean validString = validateString(wordWantedAsReversed);
		if (validString) {
			int length = wordWantedAsReversed.length();
			Stack<Integer> st = new Stack<Integer>();
			for (int i = 0; i < length; i++) {
				if (wordWantedAsReversed.charAt(i) == '(') {
					st.push(i);
				}

				if (wordWantedAsReversed.charAt(i) == ')') {
					char[] word = wordWantedAsReversed.toCharArray();
					if (!st.isEmpty()) {
						word = reverseWord(word, st.peek() + 1, i - 1);
						st.pop();
						wordWantedAsReversed = String.copyValueOf(word);
					}

				}
			}

			return wordWantedAsReversed;
		} else {
			return "";
		}
	}

	public static void main(String[] args) {

		String x = "test(dda)(sulp)))";
		String result = prepareString(x);
		System.out.println(result);
	}

}
