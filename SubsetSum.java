package Test;

import java.util.HashSet;

public class SubsetSum {
	public static boolean subsetSum(int[] in, int sum){
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		for(int i = 0; i < in.length; i++){
			for(int j = sum; j >= in[i]; j--){
				if(dp[j - in[i]]){
					dp[j] = true;
				}
			}
		}
		return dp[sum];
	}
	
	public static void main(String[] args){
		int[] in = {3, 34, 4, 12, 5, 2};
		int sum = 13;
		System.out.println(subsetSum(in, sum));
	}
}
