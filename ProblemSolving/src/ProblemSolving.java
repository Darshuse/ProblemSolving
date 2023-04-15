import java.util.Stack;

public class ProblemSolving {

	public static boolean validateString(String stringValue) {
		if (stringValue.length() < 1 || stringValue.length() > 2000) {
			return false;
		}
		return true;
	}

	// reverse the sub string between ()
	public static void reverseWord(char word[], int x, int y) {
		if (x < y) {
			char ch = word[x];
			word[x] = word[y];
			word[y] = ch;
			reverseWord(word, x + 1, y - 1);
		}

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
					if (!st.isEmpty()) {
						char[] word = wordWantedAsReversed.toCharArray();
						reverseWord(word, st.peek() + 1, i - 1);
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

		String str = "test(dda)(((sulp)";
		System.out.println(prepareString(str));
	}

}
