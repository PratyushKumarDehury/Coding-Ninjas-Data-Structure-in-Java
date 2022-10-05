Given a string S (that can contain multiple words), you need to find the word which has minimum length.
Note : If multiple words are of same length, then answer will be first minimum length word in the string.
Words are seperated by single space only.
Input Format :
String S
Output Format :
Minimum length word

Constraints :
1 <= Length of String S <= 10^5
Sample Input 1 :
this is test string
Sample Output 1 :
is
Sample Input 2 :
abc de ghihjk a uvw h j
Sample Output 2 :
a




public class Solution {
	
	public static String minLengthWord(String input){
		
		// Write your code here
        int space = 0;
		int start = 0;
		int end = 0;
		int minLength = Integer.MAX_VALUE;
		for(int i = 0; i <= input.length(); i++){
			
			if(i == input.length() || input.charAt(i) == ' ' ){
				int length = i-space;
				if(minLength > length){
					minLength = length;
					start = space;
					end = i;
				}
				space = i+1;
			}
		}
		return input.substring(start,end);

	}
}
