class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> lst = new ArrayList<>();
//below code -> if length of given string array is null then we will return empty list
        if(strs.length == 0 || strs == null){
            return lst;
        }
// below code -> if length is 1 then return given string array as list
        if(strs.length == 1){
            lst.add(Arrays.asList(strs));
            return lst;
        }
// initiating hashmap to store the strings and makes lists of array list
//first string of strs array -> convert it into array of characters, then sort it, then convert it into string and you will get the key for map, then adding it to map.....
//example -> bat -> ['b','a','t'] -> ['a','b','t'] -> abt -> map.add(abt - [" "])
        
        HashMap<String, List<String>> map = new HashMap<>();
         for(int i = 0; i <= strs.length - 1; i++){
            char [] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            StringBuilder strtemp = new StringBuilder();
            strtemp.append(arr);
            String tmp = strtemp.toString();
            if(map.containsKey(tmp)){
                map.get(tmp).add(strs[i]);
            }
            else{
                map.put(tmp, new ArrayList(Arrays.asList(strs[i])));
            }
        }
        
        return new ArrayList<>(map.values());
        
    }
}