Given a binary number as an integer N, convert it into decimal and print.
Input format :
An integer N in the Binary Format
Output format :
Corresponding Decimal number (as integer)

Constraints :
0 <= N <= 10^9

Sample Input 1 :
1100
Sample Output 1 :
12
Sample Input 2 :
111
Sample Output 2 :
7


import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
	// Write your code here
       //while loop Approach
        
//          Scanner sc = new Scanner(System.in);
//          int binary = sc.nextInt();
//          int sum = 0,count = 1, place;
      
//         while(binary != 0)
//         {  
//             place = binary % 10;
//             sum = sum + (place * count);
            
//             count *= 2;
//             binary /= 10;
//         }
       
         
            
//             System.out.println(sum);    
		
 

//For loop approach
         Scanner sc = new Scanner(System.in);
         int sum = 0,two = 1;
        
        int binary = sc.nextInt();
        for(int count = 0; binary != 0; binary /= 10){  
            count = binary % 10;
            sum = sum + (count * two);
            two *= 2;    
        }
           
            System.out.println(sum);    
	}
}


		



