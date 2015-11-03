package Google;

public class WhenItRainsItPours {

	public static void main(String[] args) {

		int[] arr = { 5,1,2,3,2,1,5};

		System.out.println(answer(arr));

	}

	private static int answer(int[] heights) {

		int leftMax = 0;
		int rightMax = 0;

		int left = 0;
		int right = heights.length - 1;

		int volume = 0;

		while (left < right) {
			if (leftMax < heights[left])
				leftMax = heights[left];
			if (rightMax < heights[right])
				rightMax = heights[right];
			if (rightMax >= leftMax) {
				volume += leftMax - heights[left];
				left += 1;
			} else {
				volume += rightMax - heights[right];
				right -= 1;
			}
		}
		
		return volume;

	}

}
