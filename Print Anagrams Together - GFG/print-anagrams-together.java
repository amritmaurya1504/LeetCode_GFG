//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        List<List<String>> lst = new ArrayList<>();
//below code -> if length of given string array is null then we will return empty list
        if(string_list.length == 0 || string_list == null){
            return lst;
        }
// below code -> if length is 1 then return given string array as list
        if(string_list.length == 1){
            lst.add(Arrays.asList(string_list));
            return lst;
        }
// initiating hashmap to store the strings and makes lists of array list
//first string of strs array -> convert it into array of characters, then sort it, then convert it into string and you will get the key for map, then adding it to map.....
//example -> bat -> ['b','a','t'] -> ['a','b','t'] -> abt -> map.add(abt - [" "])
        
        HashMap<String, List<String>> map = new HashMap<>();
         for(int i = 0; i <= string_list.length - 1; i++){
            char [] arr = string_list[i].toCharArray();
            Arrays.sort(arr);
            StringBuilder strtemp = new StringBuilder();
            strtemp.append(arr);
            String tmp = strtemp.toString();
            if(map.containsKey(tmp)){
                map.get(tmp).add(string_list[i]);
            }
            else{
                map.put(tmp, new ArrayList(Arrays.asList(string_list[i])));
            }
        }
        
        return new ArrayList<>(map.values());
    }
}
