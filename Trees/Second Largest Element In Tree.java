Given a generic tree, find and return the node with second largest value in given tree. Return NULL if no node with required value is present.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output format:
Second Largest node data
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
40
  
  
  
  
  
  
  
  
  
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
	
		
 public static TreeNode<Integer> max;
 public static TreeNode<Integer> secMax;
public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){


	// Write your code here
         if(root == null){
            return null;
        }
        max = new TreeNode<>(Integer.MIN_VALUE);
        secMax = max;
        findSecondlargest(root);
        return secMax;

    }
    public static void findSecondlargest(TreeNode<Integer> root){
        if(root.data > max.data){
            secMax = max;
            max = root;
        }
        else if(root.data > secMax.data && root.data != max.data){
            secMax = root;
        }
        for(TreeNode<Integer> i : root.children){
            findSecondlargest(i);
        }
    }
}
