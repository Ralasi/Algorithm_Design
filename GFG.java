
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG
{

static void getMinimumPenalty(String x, String y,int pxy, int pgap)
{
	int i, j;
	int m = x.length(); 
	int n = y.length(); 
	int dp[][] = new int[n + m + 1][n + m + 1];
	for (int[] x1 : dp)
	Arrays.fill(x1, 0);
	for (i = 0; i <= (n + m); i++) {
		dp[i][0] = i * pgap;
		dp[0][i] = i * pgap;}
	for (i = 1; i <= m; i++){
		for (j = 1; j <= n; j++){
			if (x.charAt(i - 1) == y.charAt(j - 1)){
				dp[i][j] = dp[i - 1][j - 1];
			}else{
				dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + pxy ,
											dp[i - 1][j] + pgap) ,
											dp[i][j - 1] + pgap );
			}}}
	int l = n + m; 
	i = m; j = n;
	int xpos = l;
	int ypos = l;
	int xans[] = new int[l + 1];
	int yans[] = new int[l + 1];
	while ( !(i == 0 || j == 0)){
		if (x.charAt(i - 1) == y.charAt(j - 1)){
			xans[xpos--] = (int)x.charAt(i - 1);
			yans[ypos--] = (int)y.charAt(j - 1);
			i--; j--;}
		else if (dp[i - 1][j - 1] + pxy == dp[i][j]){
			xans[xpos--] = (int)x.charAt(i - 1);
			yans[ypos--] = (int)y.charAt(j - 1);
			i--; j--;}
		else if (dp[i - 1][j] + pgap == dp[i][j]){
			xans[xpos--] = (int)x.charAt(i - 1);
			yans[ypos--] = (int)'_';
			i--;}
		else if (dp[i][j - 1] + pgap == dp[i][j]){
			xans[xpos--] = (int)'_';
			yans[ypos--] = (int)y.charAt(j - 1);
			j--;}}
	while (xpos > 0){
		if (i > 0) xans[xpos--] = (int)x.charAt(--i);
		else xans[xpos--] = (int)'_';}
	while (ypos > 0){
		if (j > 0) yans[ypos--] = (int)y.charAt(--j);
		else yans[ypos--] = (int)'_';}
	int id = 1;
	for (i = l; i >= 1; i--){
		if ((char)yans[i] == '_' &&
			(char)xans[i] == '_'){
			id = i + 1;
			break;}}
	System.out.print("Minimum Penalty in " +"aligning the genes = ");
	System.out.print(dp[m][n] + "\n");
	System.out.println("The aligned genes are :");
	for (i = id; i <= l; i++){
		System.out.print((char)xans[i]);}
	System.out.print("\n");
	for (i = id; i <= l; i++){
		System.out.print((char)yans[i]);}
	return;}
public static void main(String[] args)
{
	String gene1 = "AGGGCT";
	String gene2 = "AGGCA";
	int misMatchPenalty = 3;
	int gapPenalty = 2;
	getMinimumPenalty(gene1, gene2,misMatchPenalty, gapPenalty);}}

