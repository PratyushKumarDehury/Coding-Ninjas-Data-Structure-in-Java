Write a program to print first x terms of the series 3N + 2 which are not multiples of 4.
Input format :
Integer x
Output format :
Terms of series (separated by space)
Constraints :
1 <= x <= 1,000
Sample Input 1 :
10
Sample Output 1 :
5 11 14 17 23 26 29 35 38 41
Sample Input 2 :
4
Sample Output 2 :
5 11 14 17


import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// Write your code here

	Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int x ;
		int i ;
        int count = 0;
		for(i = 1; count < n; i++) {
			x = (3 * i) + 2;
			if(x % 4 != 0)	{		
			System.out.print(x + " ");
                 count++;
		}
       }
		

	}

}
