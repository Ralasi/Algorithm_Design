
//Name=RALASI RASILA SAHOO
//REGD NO.=2041019076
//BRANCH=CS-IT
//SEC-C

//Weighted interval scheduling
import java.util.*;
class Weighted_Interval_Scheduling 
{

	static class Job 
	{
		int start, finish, profit;
		Job(int start, int finish, int profit)
		{
			this.start = start;
			this.finish = finish;
			this.profit = profit;
		}
	}

	static int latestNonConflict(Job arr[], int i)
	{
		for (int j = i - 1; j >= 0; j--) 
		{
			if (arr[j].finish <= arr[i - 1].start)
				return j;
		}
		return -1;
	}

	static int findMaxProfitDP(Job arr[], int n)
	{

		int[] table = new int[n];
		table[0] = arr[0].profit;

		for (int i = 1; i < n; i++) 
		{
			int inclProf = arr[i].profit;
			int l = latestNonConflict(arr, i);
			if (l != -1)
				inclProf += table[l];

			table[i] = Math.max(inclProf, table[i - 1]);
		}

		int result = table[n - 1];
		return result;
	}

	static int findMaxProfit(Job arr[], int n)
	{
	
		Arrays.sort(arr, new Comparator<Job>() 
		{
			public int compare(Job j1, Job j2)
			{
				return j1.finish - j2.finish;
			}
		});

		return findMaxProfitDP(arr, n);
	}

	public static void main(String args[])
	{
		int m = 4;
		Job arr[] = new Job[m];
		arr[0] = new Job(3, 10, 20);
		arr[1] = new Job(1, 2, 50);
		arr[2] = new Job(6, 19, 100);
		arr[3] = new Job(2, 100, 200);
		System.out.println("The optimal profit is "+ findMaxProfit(arr, arr.length));
	}
}

//OUTPUT
//The optimal profit is 250

