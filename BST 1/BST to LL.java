Given a BST, convert it into a sorted linked list. You have to return the head of LL.
Input format:
The first and only line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.   
Output Format:
The first and only line of output prints the elements of sorted linked list.
  
Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1:
2 5 6 7 8 10
  
  
  
  
  
  
  
  
  
  
  
import java.util.LinkedList;
public class Solution {

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
	 * right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */

	/*
	 * LinkedList Node Class
	 *
	 * 
	 * class LinkedListNode<T> { T data; LinkedListNode<T> next;
	 * 
	 * public LinkedListNode(T data) { this.data = data; } }
	 */
	private static class PassNode {
        LinkedListNode<Integer> head, tail;
        public PassNode(LinkedListNode<Integer> head, LinkedListNode<Integer> tail) {
            this.head = head;
            this.tail = tail;
        }
    }
    
	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        PassNode passNode= constructLinkedListHelper(root);
        return passNode.head;
    }
    
    public static PassNode constructLinkedListHelper(BinaryTreeNode<Integer> root)
    {
    	if(root == null){
            return new PassNode(null, null);
        }
        
        if (root.left == null && root.right == null){
        	PassNode passNode = new PassNode(new LinkedListNode<Integer>(root.data), null);
            return passNode;
        }
        
        PassNode passNodeLeft = constructLinkedListHelper(root.left);
        PassNode passNodeRight = constructLinkedListHelper(root.right);
        PassNode passNode = new PassNode(null, null);
        LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(root.data);
        
        if (passNodeLeft.head == null){
        	passNode.head = newNode;
        }else{
        	passNode.head = passNodeLeft.head;//1
        }


        // ****************************************
        if(passNodeLeft.tail == null){
        	passNode.head.next = newNode;
            passNode.tail = newNode;
        }else{
        	passNodeLeft.tail.next = newNode;
            passNode.tail = newNode;
        }

        
        // ****************************************
        if (passNodeRight.head != null){
        	passNode.tail.next = passNodeRight.head;
            passNode.tail = passNodeRight.head;//2.1
        }
        
        if(passNodeRight.tail != null){
        	passNode.tail = passNodeRight.tail;//2.2
        }
    
        return passNode;
	}
}
