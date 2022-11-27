Given a Linked List, which has nodes in alternating ascending and descending orders. Sort the list efficiently and space complexity should be O(1).
You just need to return the head of sorted linked list, don't print the elements.
Input format :
Line 1 : Linked list elements of length L (separated by space and terminated by -1)
Line 2 : Integer n
Output format :
Updated list elements (separated by space)
Sample Input 1 :
10 40 53 30 67 12 89 -1
Sample Output 1 :
10 12 30 40 53 67 89








public class Solution {

	public static LinkedListNode<Integer> sort(LinkedListNode<Integer> head) {
		//Your code goes here
         if(head == null || head.next == null)
            return head;
        
        //used three pointer
        LinkedListNode<Integer> temp = null;
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        
        //middle of linked list
        while(fast !=  null && fast.next != null){
            temp = slow;
            slow = slow.next;          
            fast = fast.next.next;  
            
        }   
        temp.next = null;            
        
        LinkedListNode<Integer> list1 = sort(head);  //2   
        LinkedListNode<Integer> list2 = sort(slow);  //1 
        
        return mergelist(list1, list2);         
            
    }
    
    public static LinkedListNode<Integer> mergelist(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){
        
        LinkedListNode fh = null, ft = null;
         
         while(head1 != null && head2 != null){
             if(fh == null && ft == null){
                 if(head1.data > head2.data){
                      fh = head2;
                     ft = head2;
                    head2 = head2.next;
          
            }else{
                fh = head1;
                ft = head1;
                head1 = head1.next;
            }
        }
        if(head1 != null && head2 != null) {
            if(head1.data < head2.data){
                ft.next = head1;//1
                ft = ft.next;
                head1 = head1.next;

            }else{
                ft.next = head2;//2
                ft = ft.next;
                head2 = head2.next;
            }
        }
        
    }
    
    if(head1 != null){
        ft.next = head1;
    }
    if(head2 != null){
        ft.next = head2;
    }
    
    return fh;
        
	}

}