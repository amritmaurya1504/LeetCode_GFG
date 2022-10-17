class Solution {
    public boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        Set<Character> s = new HashSet<>();
        for(int i = 0; i < n; i++){
            s.add(sentence.charAt(i));
        }
        
        return s.size() == 26;
    }
}