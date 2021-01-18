/*  Given a number N, find the smallest number which can be obtained by rearranging the digits of N. The generated number should not have any leading zeroes.

Example 1:

Input: N = 846903
Output:304689

Example 2:

Input: N = 55010
Output:10055

*/

//Initial Template for Java

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    String N = sc.next();
		    Solution T = new Solution();
		    System.out.println(T.smallestnum(N));
		    
	    }
	
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String smallestnum(String N)
    {
        int[] cnt=new int[10];
        Arrays.fill(cnt,0);
        for(int i=0;i<N.length();i++)
            cnt[N.charAt(i)-'0']++;
        String res="";
        
        for(int i=1;i<10;i++){
            if(cnt[i]>0){
                res=String.valueOf(i);
                cnt[i]--;
                break;
            }
        }
 
        for(int i=0;i<10;i++){
           
            while(cnt[i]>0){
                      cnt[i]--;
                      res+=String.valueOf(i);
            }
        }
       
        return res;
       //code here
    }
}

