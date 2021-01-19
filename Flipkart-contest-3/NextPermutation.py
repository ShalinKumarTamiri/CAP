"""
Given an array perm[] of size N denoting a number. Find its next permutation. ie- rearrange the digits into the lexicographically next greater permutation. If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.


Example 1:

Input:
N = 6
perm[] = {1, 2, 3, 6, 5, 4}
Output: 1 2 4 3 5 6
Explanation: 124356 > 123654 and is the 
lexicographically next permutation.

Example 2:

Input:
N = 4
perm[] = {4, 3, 2, 1}
Output: 1 2 3 4
Explanation: Since 4321 can not be rearranged
to produce a bigger number, it is rearranged 
is ascending order.

"""


class Solution:
    def nextPermutation(self,perm,N):
                idx=0
                for i in range(N-1)[::-1]:
                    if perm[i]<perm[i+1]:
                        index=i+1
                        for j in range(index,len(perm)):
                            if perm[i]<perm[j]<perm[index]:
                                index=j
                        perm[i],perm[index]=perm[index],perm[i]
                        perm[i+1:]=sorted(perm[i+1:])
                        return
                return perm.sort()
                        



#{ 
#  Driver Code Starts
#Initial Template for Python 3


if __name__ == '__main__':
    tcs=int(input())
    for _ in range(tcs):
        N=int(input())
        perm=[int(x) for x in input().split()]
        
        ob = Solution()
        ob.nextPermutation(perm,N)
        for i in perm:
            print(i,end=" ")
        print()
        

# } Driver Code Ends


