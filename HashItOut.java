package Google;

import java.util.ArrayList;
import java.util.List;


public class HashItOut {

	public static void main(String[] args) {
		
		int[] digest = {0, 129, 5, 141, 25, 137, 61, 149, 113, 145, 53, 157, 233, 185, 109, 165};
		
		for(int i : answer(digest))
			System.out.println(" " + i);

	}
	
	
	private static List<Integer> getMultiples(int num, int from, int to, int digest){
		
		List<Integer> list = new ArrayList<Integer>();
		
		int start = from/(num+1);
		int end = to/(num+1);
		
		for(int i=start;i<end;i++){
			list.add(i * num + digest);
		}
		return list;
	}
	
	private static int[] answer(int[] digest) {
		
		int[] message = new int[digest.length];
		int prev;
		
		for(int i=0;i<digest.length;i++){
			if(i == 0)
				prev = 0;
			else
				prev = message[i-1];
			
			List<Integer> list = getMultiples (256, 0, 256*129, digest[i]);
			
			for(int j : list){
				if((j ^ prev)%129 ==0)
					message[i] = ((j ^ prev)/129)%256;
			}
				
		}
		return message;
		
	}

}
