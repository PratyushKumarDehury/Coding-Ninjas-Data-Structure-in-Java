Given input consists of n numbers. Check whether those n numbers form an arithmetic progression or not. Print true or false.
Input format :
Line 1 : n
Line 2 : n numbers
Sample Input 1 :
6
2 6 10 14 18 22
Sample Output 1 :
true
Sample Input 2 :
6
2 6 10 15 19 23
Sample Output 2 :
false
  
  
  
  
  
  
  
  
  
  
  
import java.util.Scanner;
public class Main {
	
public static void main(String[] args) {
     // Write your code here
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int [] arr = new int[n];
        
    for(int i = 0; i < n; i++){//1
        arr[i] = sc.nextInt();
    }
            
    boolean ans = false;
    int ans2 = arr[1] - arr[0];   
    if(n > 2){
         
    for(int i = 2; i < n - 1; i++){//2
    	if((arr[i + 1] - arr[i]) == ans2){
            ans = true;
            continue;  
        }else{
            ans = false;
            break;
        }
    }
        
     }else{
        ans = true;
    }
    if(ans){
        System.out.println("true");
    }else{
    	System.out.println("false");

	    }
       }
    }
}


	
