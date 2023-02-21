Write a program to determine if given number is palindrome or not. Print true if it is palindrome, false otherwise.
Palindrome are the numbers for which reverse is exactly same as the original one. For eg. 121
Sample Input 1 :
121
Sample Output 1 :
true
Sample Input 2 :
1032
Sample Output 2 :
false











import java.util.Scanner;
public class Main {
	
public static void main(String[] args) {
    // Write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
		 
    int r,sum = 0,temp;  //variables
    temp = n; 
     //condition    
    while(n > 0){    
    r = n % 10;  
    sum = (sum * 10) + r;    
    n = n / 10;    
  }

if(temp == sum){
   System.out.println("true");
}else{
   System.out.println("false");
   }
  }
}


  
