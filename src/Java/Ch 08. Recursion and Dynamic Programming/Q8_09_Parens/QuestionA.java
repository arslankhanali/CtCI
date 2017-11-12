package Q8_09_Parens;

import java.util.HashSet;
import java.util.Set;

public class QuestionA {
	public static String insertInside(String str, int leftIndex) {
		String left = str.substring(0, leftIndex + 1);
		String right = str.substring(leftIndex + 1, str.length());
		return left + "()" + right;
	}

	public static Set<String> generateParens(int remaining) {
		Set<String> set = new HashSet<String>();
		if (remaining == 0) {
			set.add("");
		} else {
			Set<String> prev = generateParens(remaining - 1);
			System.out.print("prev");printset(prev);

			for (String str : prev) {
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '(') {
						String s = insertInside(str, i);
						/* Add s to set if it is not already in there. Note:
						 * HashSet automatically checks for duplicates before
						 * adding, so an explicit check is not necessary. */
						set.add(s);
					}
				}
				set.add("()" + str);
				System.out.println();
				System.out.print("set");printset(set);
				System.out.println();
				System.out.println();
			}
		}
		return set;
	}

	public static void printset(Set<String> set){
		for (String s : set) {
			System.out.print(s+",");
		}
	}
	public static void main(String[] args) {
		Set<String> list = generateParens(4);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println(list.size());
	}

}
