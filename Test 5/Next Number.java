Given a large number represented in the form of a linked list. Write code to increment the number by 1 in-place(i.e. without using extra space).
Note: You don't need to print the elements, just update the elements and return the head of updated LL.
  
Input Constraints:
1 <= Length of Linked List <=10^6.
Input format :
Line 1 : Linked list elements (separated by space and terminated by -1)
Output Format :
Line 1: Updated linked list elements 
Sample Input 1 :
3 9 2 5 -1
Sample Output 1 :
3 9 2 6
Sample Input 2 :
9 9 9 -1
Sample Output 1 :
1 0 0 0 
  
  
  
  
  
  
  
  /*************** 
 * Following is the Node class already written 
class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}
}
 ***************/

public class Solution {
    

public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
     //Code-->
     LinkedListNode<Integer> temp1;
     LinkedListNode<Integer> prev = null;
    LinkedListNode<Integer> curr = head;

        
        while(curr != null){
            temp1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp1;
        }
         
        LinkedListNode<Integer> temp2 = prev;
        int extra = 0;
        LinkedListNode<Integer> a = new LinkedListNode<Integer>(1);        
        while(temp2 != null){
            if(temp2.data == 9){
                temp2.data = 0;
                extra = 1;
                if(temp2.next == null){
                    temp2.next = a;
                }
            }else{
              if(extra == 1){                
                int d = temp2.data+1;
                if(d == 10){
                  temp2.data = 0;
                   extra = 1;  
                }else{
                   extra = 0;
                }
              }else{                
                  temp2.data = temp2.data+1;
                  break;
              }
            }
            temp2 = temp2.next;
        }
        LinkedListNode<Integer> temp3;
        LinkedListNode<Integer> prev1 = null;
        LinkedListNode<Integer> curr1 = prev;
        while(curr1 != null){
            temp3 = curr1.next;
            curr1.next = prev1;
            prev1 = curr1;
            curr1 = temp3;
        }
        return prev1;
}
}

