/*  The jury consists of M teams of people. Size of each team is given in array teams[]. The jury collectively has N mics that must be shared by everyone. Find a way to break the teams into N groups such that each group can have its own mic and the size of the largest group is minimised. 
 

Example 1:

Input:
N = 3, M = 2
teams[] = {10, 30}
Output: 15
Explanation: We split 2nd team into 2 
groups {15,15}, so we get {10,15,15}. 
Here maximum group size is 15.
 

Example 2:

Input:
N = 4, M = 2
teams[] = {2, 1}
Output: 1
Explanation:
Here we need 4 groups, so we will split
first team into 2 groups of size 1 and
last group will remain empty.
Group sizes = {1,1,1,0}
Therefore maximum group size is 1.

*/


//Initial Template for C++

#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends


//User function Template for C++

class Solution
{
public:
    int micsandjury(int N, int M,int teams[])
    {
        int low=1,high=1000000000,mid;
        while(low<high){
            mid=(low+high)/2;
            int temp=0;
            for(int i=0;i<M;i++){
                temp+=teams[i]/mid;
                if(teams[i]%mid!=0)
                temp+=1;

            
 
            }
            if(temp>N)
             low=mid+1;
            else{
                
                high=mid;
            }
        }
        return (int)high;
       //code here
    }
};


// { Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N;int M;
        
        cin >>N>>M;
        int teams[M];
        int i;
        for(i=0;i<M;i++)
        cin>>teams[i];
        
        Solution ob;
        int ans = ob.micsandjury(N,M,teams);
        cout << ans << endl;
    }
    return 0;
}  // } Driver Code Ends
