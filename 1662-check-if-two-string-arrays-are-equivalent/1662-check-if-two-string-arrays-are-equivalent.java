class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
         StringBuilder a,b;
        a = new StringBuilder();
        b = new StringBuilder();
        for(String s : word1) a.append(s);
        for(String s : word2) b.append(s);
        
        return a.toString().equals(b.toString());
    }
}