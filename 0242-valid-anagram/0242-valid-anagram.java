class Solution {
    public boolean isAnagram(String s, String t) {
          if (s.length() != t.length()) return false;
    
    s = sort_string(s);
    t = sort_string(t);
    
    return s.equals(t);    
    
}

public String sort_string(String s) {
    char [] c = s.toCharArray();
    Arrays.sort(c);
    return new String(c);
}
}