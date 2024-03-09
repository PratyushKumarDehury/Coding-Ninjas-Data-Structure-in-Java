Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .

There is a path from any cell to all its neighbouring cells. For a particular cell, neighbouring cells are those cells that share an edge or a corner with the cell.

Detailed explanation ( Input/output format, Notes, Images )


Constraints :
1 <= N <= 1000
1 <= M <= 1000
Time Limit: 1 second
Sample Input 1:
2 11
CXDXNXNXNXA
XOXIXGXIXJX
Sample Output 1:
1
Sample Input 2:
5 5
DANDO
NNINJ
AXGJC
INJAA
CODDI
Sample Output 2:
0






public class Solution {
	
	int solve(String[] Graph , int N, int M)
	{
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        
        String searchingString = "CODINGNINJA";
		boolean[][] visited = new boolean[Graph.length][];
		for(int i = 0; i < Graph.length; i++) { 
            //Graph.length is for rows
            //Graph[i].length is fot columns per row
			visited[i] = new boolean[Graph[i].length()];
		}

		for(int i = 0; i < Graph.length; i++) {
			for(int j = 0; j < Graph[i].length(); j++) {
				if(Graph[i].charAt(j) == 'C' ){
					//first character search
					boolean ans =  dfs( Graph,visited,searchingString.substring(1),i,j);
					if(ans) {
						return 1;
					}  
				}
			}

		}
		return 0;
	}
    public static boolean dfs(String[] graph, boolean[][] visited, String searchString,int i,int j) {

		if(searchString.length() == 0) {
			visited[i][j] = true;
			return true;
		}

		visited[i][j] = true;
		// To traverse in 8 different directions
		int[] X_Dir = {-1,1,0,0,1,-1,1,-1 };
		int[] Y_Dir = {0,0,-1,1,1,-1,-1,1 };

		for(int k = 0; k < X_Dir.length; k++) {
			int x = i+ X_Dir[k];
			int y = j+ Y_Dir[k];

			if( x >= 0 && y >= 0 && x < graph.length && y < graph[x].length() && graph[x].charAt(y) == searchString.charAt(0) && !visited[x][y]) {
					
				boolean smallAns = dfs(graph, visited, searchString.substring(1), x, y);
				if(smallAns) {
					return smallAns;
				}
				
			}
		}
		visited[i][j] = false;
		return false;
    

	}
	
	
}
