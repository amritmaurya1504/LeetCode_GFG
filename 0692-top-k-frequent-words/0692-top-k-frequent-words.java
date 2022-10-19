class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>map=new HashMap<>();
        for(int i=0;i<words.length;i++)
        {
          map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        List<String>res=new ArrayList<>();
        Arrays.sort(words);
        while(k-->0)
        {
          int max=0;
          String s="";
          for(int i=0;i<words.length;i++)
          {
            if(map.containsKey(words[i]))
            {
              int c=map.get(words[i]);
              if(c>max)
             {
              max=c;
              s=words[i];
             }
           }
          }
          map.remove(s);
            if(res.contains(s)==false)
            {
              res.add(s);
            }
          }
          return res;
        }
}