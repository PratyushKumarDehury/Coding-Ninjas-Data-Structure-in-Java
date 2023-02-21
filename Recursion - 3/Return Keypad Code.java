Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
Return empty string for numbers 0 and 1.
Note : 1. The order of strings are not important.
2. Input and output has already been managed for you. You just have to populate the output array and return the count of elements populated in the output array.
Input Format :
Integer n
Output Format :
All possible strings in different lines

Constraints :
1 <= n <= 10^6
Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf









public class solution {
    
    public static String[] singledigit(int n){
        if(n <= 1 || n >= 10){
          System.out.print(0);
        }
        if(n == 2){
            String output[] = {"a","b","c"};
            return output;
        }
        else if(n == 3){
            String output[] = {"d","e","f"};
            return output;
        }
        else if(n == 4){
            String output[] = {"g","h","i"};
            return output;
        }
        else if(n == 5){
            String output[] = {"j","k","l"};
            return output;
        }
        else if(n == 6){
            String output[] = {"m","n","o"};
            return output;
        }
        else if(n == 7){
            String output[] = {"p","q","r","s"};
            return output;
        }
        else if(n == 8){
            String output[] = {"t","u","v"};
            return output;
        }else{
            String output[] = {"w","x","y","z"};
            return output;
        }
    }

// Return a string array that contains all the possible strings
public static String[] keypad(int n){
// Write your code here    
     if(n == 0){
      String ans[] = {""};
      return ans;
     }
      int x = 0;
      String smallAns[] = keypad(n/10);
      String singleDigit[] = singledigit(n%10);
      String output[] = new String[singleDigit.length * smallAns.length];
        for(int i = 0; i < singleDigit.length; i++){
           for(int j = 0; j < smallAns.length; j++){
             output[x++]=smallAns[j]+singleDigit[i];
             }
         }
        return output;

	}
	
}
      

    
