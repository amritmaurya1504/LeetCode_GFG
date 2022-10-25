class Solution {
    public boolean buddyStrings(String s, String goal) {
          if(s.length() != goal.length())
            return false;
        if(s.equals(goal) && s.chars().distinct().count() != s.length()){
            return true;
        }
        
        List<List<Character>> list = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != goal.charAt(i))
                list.add(List.of(s.charAt(i),goal.charAt(i)));
            if(list.size()>2) return false;
        }
        return (list.size()==2 && list.get(0).get(0)==list.get(1).get(1) 
                && list.get(0).get(1)==list.get(1).get(0));
    }
}