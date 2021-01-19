/*     Given a sorted array arr[] of distinct integers. Modify the array to look like a wave. In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
Note: The converted array must be the lexicographically smallest wave array.


Example 1:

Input:
N = 5
arr[] = {1,2,3,4,5}
Output: 2 1 4 3 5
Explanation: Array elements after 
sorting it in wave form are 
2 1 4 3 5.
 

Example 2:

Input:
N = 6
arr[] = {2,4,7,8,9,10}
Output: 4 2 8 7 10 9
Explanation: Array elements after 
sorting it in wave form are 
4 2 8 7 10 9.
*/


//Initial Template for Java
   
import java.io.*;
import java.util.*;

class GFG {
public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); 
        
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n]; 
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i]=Integer.parseInt(inputLine[i]); 
            }
            Solution obj = new Solution();
            obj.convertToWave(arr, n);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++)
                sb.append(arr[i] + " ");
            System.out.println(sb); 
        }
    }
}



// } Driver Code Ends


//Back-end complete function Template for Java

class Solution{
    public static void convertToWave(int arr[], int n){
        
        Arrays.sort(arr); 
        for(int i=0;i<n-1;i+=2){
            int temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
        // code here
    }
}

