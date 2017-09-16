package Test;

public class EditDistance {
	public static int editDistance(String a, String b){
		int al = a.length();
		int bl = b.length();
		
		int[][] dp = new int[al + 1][bl + 1];
		
		for(int i = 0; i < al + 1; i++){
			for(int j = 0; j < bl + 1; j++){
				if(i == 0){
					dp[i][j] = j;
				}
				else if(j == 0){
					dp[i][j] = i;
				}
				else if(a.charAt(i - 1) == b.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1];
				}
				else{
					dp[i][j] = Math.min(1 + dp[i - 1][j - 1], 
							Math.min(1 + dp[i - 1][j], 1 + dp[i][j - 1]));
				}
			}
		}
		return dp[al][bl];
	}
	
	public static void main(String[] args){
		String a = "saturday";
		String b = "sunday";
		System.out.println(editDistance(a, b));
	}
}
