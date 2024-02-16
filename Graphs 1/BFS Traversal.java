Given an undirected and disconnected graph G(V, E), print its BFS traversal.

Note:

1. Here you need to consider that you need to print BFS path starting from vertex 0 only. 
2. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
3. E is the number of edges present in graph G.
4. Take graph input in the adjacency matrix.
5. Handle for Disconnected Graphs as well
Detailed explanation ( Input/output format, Notes, Images )
  
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
4 4
0 1
0 3
1 2
2 3
Sample Output 1:
0 1 3 2







import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    //A print helper function to solve the print function issues
    public static void printHelper(int edges[][], int sv,boolean visited[]){ 
    
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;
        while(q.size() != 0){
            int firstelem = q.poll(); //here both poll and remove can be used, both remove and return the first element of the queue.
            System.out.print(firstelem + " ");
            for(int i = 0; i < edges.length; i++){
                if(edges[firstelem][i] == 1 && !visited[i]){ 
                    q.add(i);
                    visited[i] = true;
                }       
            }
        }   
    }
    // we have to deal with both connected and non connected
    public static void print(int edges[][]){
        boolean visited[] = new boolean[edges.length];
        for(int i = 0; i < edges.length; i++){
            if(!visited[i]){
                printHelper(edges, i, visited);   
            }
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt(); //here V stands for vertices
        int E = s.nextInt(); //here E stands for edges
        int edges[][] = new int[V][V]; 
        //creates an adjaceny matrix for all vertices
        //taking input, loop from 0 to e-1, that is e times and get the starting and ending vertex
        for(int i = 0; i < E; i++){
            int fv = s.nextInt(); 
            int sv = s.nextInt(); 
            edges[fv][sv] = 1;   
            edges[sv][fv] = 1;
        }
        print(edges); //call print edges function
    }

}
