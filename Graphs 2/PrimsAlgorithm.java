Given an undirected, connected and weighted graph G(V, E) with V number of vertices 
(which are numbered from 0 to V-1) and E number of edges.



Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.



For printing MST follow the steps -

1. In one line, print an edge which is part of MST in the format - 
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. 
And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note: Order of different edges doesn't matter.
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
Line 1: Two Integers V and E (separated by space)
Next E lines: Three integers ei, ej and wi, denoting that there exists an edge between
vertex ei and vertex ej with weight wi (separated by space)
Output Format:
Print the MST, as described in the task.


Constraints :
2 <= V, E <= 10^5
1 <= Wi <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Input Graph(<--FIG-->)



Sample Output 1 :
0 1 3
1 2 1
0 3 5
Input Graph(<--FIG-->)





import java.util.Scanner;
public class Solution {
    
    private static void prims(int[][] adjacencyMatrix) {
		int v = adjacencyMatrix.length;
		boolean visited[] = new boolean[v];
		int weight[] = new int[v];
		int parent[] = new int[v];
		weight[0] = 0;
		parent[0] = -1;
		for(int i = 1; i < v; i++){
			weight[i] = Integer.MAX_VALUE;
		}
		for(int i = 0; i < v; i++){
			// Pick vertex with min weight
			int minVertex = findMinVertex(weight, visited);
			visited[minVertex] = true;
			// Explore its unvisited neighbors
			for(int j = 0; j < v; j++){
				if(adjacencyMatrix[minVertex][j] != 0 && !visited[j]){
					if(adjacencyMatrix[minVertex][j] < weight[j]){
						weight[j] = adjacencyMatrix[minVertex][j];
						parent[j] = minVertex;
					}
				}
			}
		}
		
		// Print edges of MST
		for(int i = 1; i < v; i++){
			if(parent[i] < i){
				System.out.println(parent[i] + " " + i +" "+ weight[i]);
			}else{
				System.out.println(i + " " + parent[i] +" "+ weight[i]);
			}
		}	
	}
	
	private static int findMinVertex(int[] weight, boolean visited[]) {
		
		int minVertex = -1;
		for(int i = 0; i < weight.length; i++){
			if(!visited[i]  && (minVertex == -1 || weight[i] < weight[minVertex])){
				minVertex = i;
			}
		}
		return minVertex;
	}


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		/* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
        
        	int adjacencyMatrix[][] = new int[V][V];
			for(int i = 0; i < E; i++){
				int V1 = s.nextInt();
				int V2 = s.nextInt();
				int weight = s.nextInt();
				adjacencyMatrix[V1][V2] = weight;
				adjacencyMatrix[V2][V1] = weight;
			}
		
			prims(adjacencyMatrix);
    }
}


	