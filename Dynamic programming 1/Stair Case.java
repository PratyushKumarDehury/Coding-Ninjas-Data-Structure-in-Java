A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count and return all possible ways in which the child can run-up to the stairs.
Input format :
The first and the only line of input contains an integer value, 'n', denoting the total number of steps.
Output format :
Print the total possible number of ways.

 Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1:
4
Sample Output 1:
7
Sample Input 2:
10
Sample Output 2:
274








public class Solution {

	public static long staircase(int n) {
	      //Your code goes here
        long[] staircase = new long[n + 1]; //this is our DP array/list of size (n + 1)

	     //Base Cases
        if(n == 0){
           return 1;
        }
		
	if(n == 1 || n == 2){
           return n;
        }
 
        staircase[0] = 1;
	staircase[1] = 1;
	staircase[2] = 2;
		
	for(int i = 3; i <= n; i++){
		staircase[i] = staircase[i - 1] + staircase[i - 2] + staircase[i - 3];
	}
	return staircase[n];
    }
}

//Another Slolution-->
if(n == 0){
	return 1;
}
else if(n == 1){
	return 1;
}
else if(n == 2){
	return 2;
}

long x = staircase(n-1);
long y = staircase(n-2);
long z = staircase(n-3);
return x+y+z;
}
}


	         
	
