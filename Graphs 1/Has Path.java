Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), 
check if there exists any path between them or not. Print true if the path exists and false otherwise.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= V <= 1000
0 <= E <= 1000
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= V - 1
0 <= v2 <= V - 1
Time Limit: 1 second
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
true
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
false







import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
public class Solution {
    
    public static boolean hasPath2(int[][] adjMatrix, int currentVertex, int destinationVertex){

        int n = adjMatrix.length;;
        if (currentVertex >= n || destinationVertex >= n){
            return false;
        }
        if (adjMatrix[currentVertex][destinationVertex] == 1){
            return true;
        }
        // create array
        boolean[] visited = new boolean[adjMatrix.length];
        // create a queue
        Queue<Integer> pendingVertices = new LinkedList<>();
        pendingVertices.add(currentVertex);
        // mark source vertex visited
        visited[currentVertex] = true;
        while (!pendingVertices.isEmpty()){
            // remove topEle from queue
            currentVertex = pendingVertices.poll();
            if (visited[currentVertex] && visited[destinationVertex]){
                return true;
            }
            // put all non-visited adjacent vertices of topEle in queue
            for (int i = 0; i < adjMatrix.length; i++){
                if (adjMatrix[currentVertex][i] == 1 && !visited[i]){
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }


	public static void main(String[] args) throws NumberFormatException, IOException {
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
        
         Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // no. of vertices
        int e = sc.nextInt(); // no. of edges
        // assumption : if v = 4 then vertices will be : (0, 1, 2, 3)
        // we have to check there is exists edge between a and b or not
        int[][] adjMatrix = new int[v][v];
        // take all edges input
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        int a = sc.nextInt(); // start vertex
        int b = sc.nextInt(); // destination vertex
        // Has Path
        boolean ans = hasPath2(adjMatrix, a, b);
        System.out.println(ans);

        
    
	}

}
