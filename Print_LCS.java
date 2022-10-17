import java.util.Arrays;

class Print_LCS{
    static int[][] dp;
    public static void main(String[] args) {
        String str1 = "acbcf";
        String str2 = "abcdaf";

        String res = printLCS(str1,str2,str1.length(), str2.length());
        System.out.println(res);
    }
    public static String printLCS(String s1, String s2, int n, int m){
        dp = new int[n+1][m+1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        int lenOfLCS = lcs(s1, s2, n, m);
        System.out.println("length of LCS" + " " + lenOfLCS);

        String res = backTracking(s1,s2,n,m);

        return res;
    }

    public static int lcs(String s1, String s2, int n, int m){
        if(n == 0 || m == 0){
            return dp[n][m] = 0;
        }

        if(dp[n][m] != -1) return dp[n][m];

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return dp[n][m] = 1 + lcs(s1, s2, n-1, m-1);
        }else{
            return dp[n][m] = Math.max(lcs(s1, s2, n-1, m), lcs(s1, s2, n, m-1));
        }
    }

    public static String backTracking(String s1, String s2, int n, int m){
        int i = n, j = m;
        StringBuilder str = new StringBuilder();
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                str.append(s1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i][j-1] > dp[i-1][j]){
                    j--;
                }else{
                    i--;
                }
            }
        }

        return str.reverse().toString();
    }
}