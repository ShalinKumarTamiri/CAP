/*
Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
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
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.bfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        Boolean visited[] = new Boolean[V];
        LinkedList<Integer> q = new LinkedList<>();
        Arrays.fill(visited,false);
        visited[0]=true;
        q.add(0);
        while(q.size()>0){
            int vertex = q.poll();
            arr.add(vertex);
            for(int i=0;i<adj.get(vertex).size();i++){
                if(!visited[adj.get(vertex).get(i)]){
                    visited[adj.get(vertex).get(i)]=true;
                    q.add(adj.get(vertex).get(i));
                }
            }
        }
        return arr;
                // Code here
    }
}
