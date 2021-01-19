"""A[][] is a (R x C) boolean matrix  such that each of its element is either 0 or 1. Each row of the matrix is sorted. Find the index of the row which has the maximum number of ones. If there are multiple such rows then return the smallest index.
An array B[] of size R is used to construct matrix A such that B[i] denotes the number of zeroes in the ith row.


Example 1: 

Input:
R=3, C=3
B[]={1, 0, 2} 

Output: 1

Explanation:
A[][] =[[0,1,1],
        [1,1,1],
        [0,0,1]]
Row with index 1 has maximum number of 1s. 
 """
 
 #Driver Code Starts
#Initial Template for Python 3

class A:
    __B=None
    __R=None
    __C=None
    def __init__(self, R, C,B):
        self.__R=R
        self.__B=B
        self.__C=C
    def __getP(self,i,j):
        assert 0<=i and i<self.__R and 0<=j and j<self.__C
        if(self.__B[i]>=j+1):
            return 0
        return 1
    def get(self,i,j):
        return self.__getP(i,j)
        

 # } Driver Code Ends

#User function Template for python3

class Solution:
    # do not edit this function
    # use it to get the value of A[i][j]
    def get(self, i, j):
      return a.get(i,j)
      
    def solve(self, R, C):
        ans=0
        row=0
        oneCount=C
        while(row<R and self.get(row,C-1)==0):
            row+=1
        for i in range(row,R,1):
            check=oneCount
            
            for j in range(oneCount,0,-1):
                if self.get(i,j-1)==1:
                    oneCount=j-1
                else:
                    break
            if oneCount==0:
                return i
            if oneCount!=check:
                ans=i
        return ans
                    
                
        # code here


#{ 
#Driver Code Starts.

if __name__ == "__main__":
	t = int (input ())
	for tc in range (t):
		__R,__C = map(int,input().split())
		__B=[int(i) for i in input().split()]
		a=A(__R,__C,__B)
		ob = Solution()
		print(ob.solve(__R,__C))
#} Driver Code Ends
 
