/*  Given two distinct words start and target, and a set denoting a dictionary of unique words of equal lengths. Find the length of the shortest transformation sequence from start to target.
Keep the following conditions in mind:

A word can only consist of lowercase characters.
Only one letter can be changed in each transformation.
Each transformed word must exist in the dictionary. 
The starting word may not exist in the dictionary.
Target will always be in the dictionary otherwise the path is not possible and you should return 0.

Example 1:

Input:
D={"poon","plee","same","poie","plea","plie","poin"}
start="toon"
target="plea"
Output: 7
Explanation:
The length of the smallest transformation sequence
from toon to plea is 7 i.e. toon -> poon -> poin ->
poie -> plie -> plee -> plea
 

Example 2:

Input:
D= {"aaa", "aab","abc"} 
start="aaa"
target="aab"
Output: 2
Explanation:
The length of the smallest transformation 
sequence from aaa to aab is 2 i.e. aaa -> aab
*/



//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t>0)
		{
		    int n = Integer.parseInt(br.readLine().trim());
		    Set<String> s = new HashSet<>();
		    for(int i=0;i<n;i++)
		    {
		        String words = br.readLine().trim();
		        s.add(words);
		    }
			String start = br.readLine().trim();
			String target = br.readLine().trim();
			Solution T = new Solution();
			System.out.println(T.wordLadderLength(start,target,s));
			t--;
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java


public class Solution {
    public boolean findDifference(String word1,String word2){
        int count=0;
        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i)!=word2.charAt(i))
                 count++;
        }
        return count>1?false:true;
    }
    public int wordLadderLength(String start, String target, Set<String> D) {
        Queue<String> q=new LinkedList<>();
        Set<String> visitedWords=new HashSet<>();
        int res=1;
        q.add(start);
        while(q.size()>0){
            int size=q.size();
            for(int i=0;i<size;i++){
            String s=q.poll();
            if(s.equals(target))
                  return res;
            else{
                     for(String word :D){
                         if(!visitedWords.contains(word) && findDifference(word,s)==true){
                             visitedWords.add(word);
                             q.add(word);
                             
                         }
                     }
                }
            }
            res++;
        }
        return 0;
        // code here
    }
}
