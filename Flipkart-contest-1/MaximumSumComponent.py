"""  Given an undirected graph with V vertices and E edges. Every node has been assigned a value. The task is to find the connected chain with the maximum sum of values among all the connected components in the graph.

Example 1:

Input: 
V = 7, E = 4 
Values = {10, 25, 5, 15, 5, 20, 0} 
Edges={ {1,2} ,{3,4}, {4,5} ,{6,7} }
Output: 35


"""


#Driver Code Starts
#Initial Template for Python 3

 # } Driver Code Ends

#User function Template for python3

class Solution:
    
    def findParent(vertex,union):
        if (union[vertex]!=vertex):
            union[vertex]=Solution.findParent(union[vertex],union)
        return union[vertex]
    
    def createEdge(vertex1,vertex2,union):
        parent1=Solution.findParent(vertex1,union)
        parent2=Solution.findParent(vertex2,union)
        union[parent1]=parent2
        
	
    def solve(self, V,E,Values,Edges):
        union={}
        for i in range(1,V+1):
	        union[i]=i
        for edge in Edges:
            Solution.createEdge(edge[0],edge[1],union)
        ans={}
        for i in union:
	        parent=Solution.findParent(i,union)
	        if parent in ans:
	            ans[parent]+=Values[i-1]
	        else:
	            ans[parent]=Values[i-1]
        l=Values+list(ans.values())
        return max(l)
	    

		# your code here


#{ 
#Driver Code Starts.
import sys
sys.setrecursionlimit(10**6)
if __name__ == "__main__":
	t = int (input ())
	for tc in range (t):
		V,E = map(int,input ().strip().split())
		Values=list(map(int,input().strip().split()))
		Edges=[]
		for i in range(E):
		    e=list(map(int,input().strip().split()))
		    Edges.append(e)
		ob = Solution()
		print(ob.solve(V,E,Values,Edges))
#} Driver Code Ends
