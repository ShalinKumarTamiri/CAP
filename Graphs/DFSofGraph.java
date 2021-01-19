/*
  Given a connected undirected graph. Perform a Depth First Traversal of the graph.
*/

// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.dfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
         Boolean visited[] = new Boolean[V];
         Arrays.fill(visited,false);
         ArrayList<Integer> arr = new ArrayList<Integer>();
         dfs(arr,visited,0,adj);
         return arr;
        // Code here
    }
    public void dfs(ArrayList<Integer> arr , Boolean visited[] , int v , ArrayList<ArrayList<Integer>> adj){
            visited[v]=true;
            arr.add(v);
            for(int element=0;element<adj.get(v).size();element++){
                if(!visited[adj.get(v).get(element)]){
                     dfs(arr,visited,adj.get(v).get(element),adj);
                }
            }
    }
}
