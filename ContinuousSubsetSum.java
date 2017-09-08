package Test;

import java.util.HashSet;

public class ContinuousSubsetSum {
	public static boolean subsetSum(int[] in, int sum){
		HashSet<Integer> sums = new HashSet<Integer>();
		int counter = 0;
		if(sum == 0){
			return true;
		}
		for(int i: in){
			counter += i;
			if(sums.contains(counter - sum)){ 
				return true;
				// There exists an a, b such that sum(0,b) - sum(0,a) = sum
				// So, counter - x = sum => there exists an x such that
				//x = counter - sum
				
			}
			sums.add(counter);
		}
		return false;
	}
	
	public static void main(String[] args){
		int[] in = {};
		int sum = 0;
		System.out.println(subsetSum(in, sum));
	}
}
