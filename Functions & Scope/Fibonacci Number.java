Given a number N, figure out if it is a member of fibonacci series or not. Return true if the number is member of fibonacci series else false.
Fibonacci Series is defined by the recurrence
    F(n) = F(n-1) + F(n-2)
where F(0) = 0 and F(1) = 1


Input Format :
Integer N
Output Format :
true or false

Constraints :
0 <= n <= 10^4

Sample Input 1 :
5
Sample Output 1 :
true
Sample Input 2 :
14
Sample Output 2 :
false



public class Solution {
	
	public static boolean checkMember(int n){
				   
		int a = 0,b = 0;
        int i = 0;
      for(i = 0; i < n; i++){
            b = i + a;	
            i = a;
            a = b;
        }
        if(i == n){
            return true;
        }
        else{
            return false;
        }
    }
	

}


//Using While loop

// public class Solution{
//     public static boolean checkMember(int n){
//         int a = 0;
//             int b = 1;
//             if (n==a || n==b) return true;
//             int c = a+b;
//             while(c<=n)
//             {
//                 if(c == n) return true;
//                 a = b;
//                 b = c;
//                 c = a + b;
//             }
//             return false;
//         }
//     }
    
    




    


