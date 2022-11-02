Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.
Note: Array A can contain duplicate elements as well.
Input format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output format :
The first and only line of output contains the count of pair of elements in the array which sum up to 0. 

Constraints :
0 <= N <= 10^4
Time Limit: 1 sec
Sample Input 1:
5
2 1 -2 2 3
Sample Output 1:
2





import java.util.*;
import java.util.HashMap;
public class Solution {
	public static int PairSum(int[] input, int size) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        
         HashMap <Integer,Integer> map1 = new HashMap<>();
         for(int i = 0; i < input.length; i++){
				
				if(map1.containsKey(input[i])){
					
					map1.put(input[i], map1.get(input[i]) + 1);
				}else{
					map1.put(input[i], 1);
				}
			}

        
        int count = 0;
        for(int i = 0; i < input.length; i++) {
			
		if(input[i] != 0 && map1.containsKey(input[i]) && map1.containsKey(-1 * input[i])){
				
                    count = count + map1.get(-input[i]);
                    if(map1.get(input[i])>1){
                    map1.put(input[i],map1.get(input[i]) -1);
                    }else{
                        map1.remove(input[i]);
                    }
                    
                }else if(input[i] == 0 && map1.containsKey(input[i]) && map1.get(input[i]) > 1){
                     count = count + map1.get(input[i]) - 1;

                    if(map1.get(input[i]) > 1){
            
                    map1.put(input[i],map1.get(input[i]) - 1);
                    }else{
                        map1.remove(input[i]);
                    }
            }
        }
             return count;
	}
}


       
