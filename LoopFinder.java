package Google

/**
* Count number of array elements in an array containing a loop
*/

public class LoopFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numbers[] = {1,2,1};
		
		int count = findLoop(numbers);
		System.out.println("count: " + count);

	}

	/**
	 * @param numbers
	 */
	private static int findLoop(int[] numbers) {
		
		int count = 0;
		int i = 0;
		
		// get cycle start
		while(numbers[i] > 0){
			int prevIndex = i;
			i = numbers[i];
			numbers[prevIndex] = -1 * numbers[prevIndex];
		}
		
		// get count
		int startOfArray = i;
		
		do{
			count++;
			i = numbers[Math.abs(i)];
		}while(Math.abs(i) != startOfArray);
		
		return  count;
		
	}

	/**
	 * @param numbers
	 */
	private static void printArray(int[] numbers) {
		// TODO Auto-generated method stub
		for(int i=0;i<numbers.length;i++){
			System.out.print(", " + numbers[i]);
		}
		System.out.println(" ");
	}

}
