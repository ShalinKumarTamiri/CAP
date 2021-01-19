"""
Aterp is the head nurse at city hospital. City hospital contains R*C number of wards and structure of hospital is in the form of a 2-D matrix.
Given a matrix of dimension R*C where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0 : Empty ward
1 : Cells have uninfected patients
2 : Cells have infected patients

An infected patient at ward [i,j] can infect other uninfected patient at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. Help Aterp determine the minimum units of time after which there won't remain any uninfected patient i.e all patients would be infected. If all patients are not infected after infinite units of time then simply return -1.


Example 1:

Input:
3 5
2 1 0 2 1
1 0 1 2 1
1 0 0 2 1 
Output:
2

Explanation:
Patients at positions {0,0}, {0, 3}, {1, 3}
and {2, 3} will infect patient at {0, 1}, 
{1, 0},{0, 4}, {1, 2}, {1, 4}, {2, 4} during 1st 
unit time. And, during 2nd unit time, patient at 
{1, 0} will get infected and will infect patient 
at {2, 0}. Hence, total 2 unit of time is required 
to infect all patients.

Example 2:

Input:
3 5
2 1 0 2 1
0 0 1 2 1
1 0 0 2 1

Output:
-1

Explanation:
All patients will not be infected.
 
"""



class Solution:
    def helpaterp(self, hospital):
        infected=[]
        uninfected=set()
        for i in range(len(hospital)):
            for j in range(len(hospital[0])):
                if(hospital[i][j]==1):
                    uninfected.add((i,j))
                elif(hospital[i][j]==2):
                    infected.append((i,j))
        if len(infected)==0:
            return 0
        check=True
        res=0
        while(check==True and len(uninfected)>0):
            check=False
            possibleInfected=[]
            for i,j in infected:
                directions=[(i+1,j),(i,j+1),(i-1,j),(i,j-1)]
                for dir in directions:
                    if dir in uninfected:
                        check=True
                        possibleInfected.append(dir)
                        uninfected.remove(dir)
            infected=possibleInfected
            res+=1
        if(len(uninfected)!=0):
            return -1
        else:
            return res
        # code here
        



#{ 
#  Driver Code Starts
#Initial Template for Python 3


if __name__ == '__main__':
    t=int(input())
    for tcs in range(t):
        
        rc=input().split() #row and column
        r=int(rc[0])    
        c=int(rc[1])
        
        
        hospital=[]
        
        for i in range(r):
            hospital.append([int(j) for j in input().split()])
            
        ob = Solution()        
        print(ob.helpaterp(hospital))

# } Driver Code Ends
