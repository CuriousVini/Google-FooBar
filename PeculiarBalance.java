package Google;

import java.util.ArrayList;
import java.util.List;

// FooBar - Convert decimal to balanced ternary

public class PeculiarBalance {

	public static void main(String[] args) {

		int x = 546;

		String[] str = answer(x);

		for (String s : str)
			System.out.println(s);

	}

	private static String[] answer(int x) {
		return balancedTernary(decimalToTernary(x));
	}

	// find convert ternary to balanced ternary representation.
	private static String[] balancedTernary(List<Integer> ternary) {

		List<String> arr = new ArrayList<String>();
		int carry = 0;
		int i =0;

		for (i = 0 ; i < ternary.size(); i++) {

			int temp = ternary.get(i) + carry;
			carry = 0;

			switch (temp) {
			case 3:
				arr.add(i, "-");
				carry = 1;
				break;
			case 2:
				arr.add(i, "L");
				carry = 1;
				break;
			case 1:
				arr.add(i, "R");
				carry = 0;
				break;
			case 0:
				arr.add(i, "-");
				carry = 0;
				break;
			}
		}
		
		if (carry == 1)
			arr.add(i, "R");

		return arr.toArray(new String[arr.size()]);
	}

	
	// convert decimal to ternary representation
	private static List<Integer> decimalToTernary(int x) {
		List<Integer> list = new ArrayList<Integer>();
		int i = 0;

		while (x > 0) {
			list.add(i, (int) (x % 3));
			x = x / 3;
			i++;
		}
		return list;
	}	

}
