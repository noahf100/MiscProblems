package Test;

public class LongestCommonSubsequence {

	public static int longestCommon(String a, String b){
		int al = a.length();
		int bl = b.length();
		
		int[][] dp = new int[al + 1][bl + 1];
		for(int i = 1; i < al + 1; i++){
			for(int j = 1; j < bl + 1; j++){
				if(a.charAt(i - 1) == b.charAt(j - 1)){
					dp[i][j] = 1 + dp[i - 1][j - 1];
				}
				else{
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[al][bl];
	}
	
	public static void main(String[] args){
		String a = "ABCDGH";
		String b = "AEDFHR";
		System.out.println(longestCommon(a, b));
	}
}
