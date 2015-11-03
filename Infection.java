package Google;

public class Infection {

	public static void main(String[] args) {
		
		int[][] arr = {{6, 7, 2, 7, 6}, {6, 3, 1, 4, 7}, {0, 2, 4, 1, 10}, {8, 1, 1, 4, 9}, {8, 7, 4, 9, 9}};

		arr = answer(arr, 2, 1, 5 );
		printArray(arr);
		
		
	}

	private static void printArray(int[][] arr) {
		for(int i = 0;i<arr.length;i++){
			for(int j = 0; j<arr[i].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println(" ");
		}
	}

	public static int[][] answer(int[][] population, int x, int y, int strength) {
		
		int row = y;
		int col = x;
		
		int m = population.length;
		int n = population[0].length;
		
		// valid row and col moves
		int rowMoves[] = {-1, 0, 1, 0};
		int colMoves[] = {0, -1, 0, 1};
		
		if(population[row][col] > strength)
			return population;
		
		population[row][col] = -1;
		answerUtil(row, col, rowMoves, colMoves, m, n, population, strength);
		return population;
	}

	// util to spread infection
	private static void answerUtil(int row, int col, int[] rowMoves, int[] colMoves, int m, int n, int[][] population, int strength) {
		
		for(int i =0; i <4; i++){
			int next_row = row + rowMoves[i];
			int next_col = col + colMoves[i];
			
			if(isSafe(next_row, next_col, m, n, population, strength)){
				population[next_row][next_col] = -1;
				answerUtil(next_row,next_col, rowMoves, colMoves, m, n, population, strength);
			}
		}
		
	}

	// check whether its safe to move to next position
	private static boolean isSafe(int next_row, int next_col, int m, int n, int[][] population, int strength) {
		
		if(next_row >= 0 && next_row < m && next_col >= 0 && next_col < n && population[next_row][next_col] > -1 && population[next_row][next_col] <= strength)
			return true;
		
		return false;
	}

}
