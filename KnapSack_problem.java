
//Name=RALASI RASILA SAHOO
//REGD NO.=2041019076
//BRANCH=CS-IT
//SEC-C

//0/1 Knapsack problem
public class KnapSack_problem
{

	
	static int max(int a, int b)
	{
	return (a > b) ? a : b;
	}

	
	static int knapSack(int W, int wt[], int val[], int n)
	{
		
		if (n == 0 || W == 0)
			return 0;
		if (wt[n - 1] > W)
			return knapSack(W, wt, val, n - 1);
		else
			return max(val[n - 1]+ knapSack(W - wt[n - 1], wt,val, n - 1),
					knapSack(W, wt, val, n - 1));
	}

	
	public static void main(String args[])
	{
		
		int wt[] = new int[] { 10, 20, 30 };
		int val[] = new int[] { 60, 100, 120 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}
}

//OUTPUT
//220

