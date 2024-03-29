Given two Generic trees, return true if they are structurally identical i.e. they are made of nodes with the same values arranged in the same way.
Input format :

Line 1 : Tree 1 elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Line 2 : Tree 2 elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : true or false

Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
10 3 20 30 40 2 40 50 0 0 0 0
Sample Output 1 :
true
Sample Input 2 :
10 3 20 30 40 2 40 50 0 0 0 0 
10 3 2 30 40 2 40 50 0 0 0 0
Sample Output 2:
false
  
  
  
  
  
  
  
  
  
  
  
  
  public class Solution {

/*	TreeNode structure 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/
        public static boolean isIdentical = true;
	
	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

		// Write your code here
		if(root1.data != root2.data || root1.children.size() != root2.children.size()){
		     return false;
		}
		QueueUsingLL<TreeNode<Integer>> pendingNodes1 = new QueueUsingLL<>();
		for(int i = 0; i < root1.children.size(); i++){
		   pendingNodes1.enqueue(root1.children.get(i));
		}
        
		QueueUsingLL<TreeNode<Integer>> pendingNodes2 = new QueueUsingLL<>();
		for (int i = 0; i < root2.children.size(); i++){
		    pendingNodes2.enqueue(root2.children.get(i));
		}
		if(!pendingNodes1.isEmpty() && !pendingNodes2.isEmpty()){
			try {
			   isIdentical = checkIdentical(pendingNodes1.front(), pendingNodes2.front());
			} catch (QueueEmptyException e){
			    e.printStackTrace();
			}
		}
		return isIdentical;
	}
	
}

