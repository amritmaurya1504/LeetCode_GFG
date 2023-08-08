//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        
        return gcd(b, a % b);
    }
    public static int countFractions(int n, int[] numerator, int[] denominator) {
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        // Reducing the numerator or denominator
        for(int i = 0; i < n; i++){
            int g = gcd(numerator[i], denominator[i]);
            numerator[i] /= g;
            denominator[i] /= g;
        }
        
        // Now iterate again int the array tp find the answer;
        for(int i = 0; i < n; i++){
            String fraction = numerator[i] + "/" + denominator[i];
            String requiredFraction = (denominator[i] - numerator[i]) + "/" + denominator[i];

            if (map.containsKey(requiredFraction)) {
                ans += map.get(requiredFraction);
            }

            map.put(fraction, map.getOrDefault(fraction, 0) + 1);
        }
        
        return ans;
    }
}
        
/*

class Solution {
    public static int countFractions(int n, int[] numerator, int[] denominator) {
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                double first = (double)numerator[i] / denominator[i];
                double second = (double)numerator[j]/ denominator[j];
                if(first + second == 1){
                    ans++;
                }
            }
        }
        return ans;
    }
}
*/