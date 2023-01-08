Given a singly linked list of integers, sort it using 'Bubble Sort.'
Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Input format :
The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the sorted singly linked list.

Output for every test case will be printed in a seperate line.
  
Constraints :
0 <= M <= 10^3
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 
 Sample Input 2 :
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90 
  
  
  
  
  
  
  
  
  
  
  
  
  /*

	Following is the Node class already written for the Linked List

	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;
    
    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*/

public class Solution {

	public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
		
        
        //Write your code here
        int count = 0;
        LinkedListNode<Integer> temp1 = head;
        while(temp1 != null){
            temp1 = temp1.next;
            count++;
        }
        for(int i = 0; i < count-1; i++){
            
            LinkedListNode<Integer> prev = null;
            LinkedListNode<Integer> curr = head;
            for(int j = 0; j < count-i-1; j++){
                if(curr.data <= curr.next.data){
                    prev = curr;
                    curr = curr.next;
                
                    
                }else{
                    if(prev == null){
                    LinkedListNode<Integer> temp = curr.next;
                    head = head.next;//1
                    curr.next = temp.next;
                    temp.next = curr;
                    prev = temp;
                    
                        
                }else{
                    LinkedListNode<Integer> temp = curr.next;
                    prev.next = temp;//2
                    curr.next = temp.next;
                    temp.next = curr;
                    prev = temp;
                }
            }
        }
    }
        return head;
    }
}


    
   
