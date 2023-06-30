
//Name=RALASI RASILA SAHOO
//REGD NO.=2041019076
//BRANCH=CS-IT
//SEC-C

//Approximation string matching
public class ApproxString 
{
	static int win(int x,int y,int z)
	{
		if(x<=y&&x<=z)
			return x;
		if(y<=x&&y<=z)
			return y;
		else
			return z;
	}
	static int editDistDP(String str1,String str2,int m,int n)
	{
		int dp[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++) 
		{
			for(int j=0;j<=n;j++) 
			{
				if(i==0)
					dp[i][j]=j;
				else if(j==0)
					dp[i][j]=i;
				else if(str1.charAt(i-1)==str2.charAt(j-1))
					dp[i][j]=dp[i-1][j-1];
				else
					dp[i][j]=1+win(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
				
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) 
	{
		String str1="benyam";
		String str2="ephrem";
		System.out.println("Minimum edit distance "+editDistDP(str1,str2,str1.length(),str2.length()));

	}

}

//OUTPUT
//Minimum edit distance 5
