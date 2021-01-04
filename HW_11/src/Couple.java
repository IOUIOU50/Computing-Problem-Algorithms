class Couple { 
    static int[] dp = new int[1000]; 
  
    // Returns count of ways n people 
    // can remain single or paired up. 
    static int countFriendsPairings(int n) 
    { 
        if (dp[n] != -1) 
            return dp[n]; 
  
        if (n > 2) 
            return dp[n] = countFriendsPairings(n - 1) + (n - 1) * countFriendsPairings(n - 2); 
        else
            return dp[n] = n; 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        for (int i = 0; i < 1000; i++) 
            dp[i] = -1; 
        int n = 2; 
        System.out.println(countFriendsPairings(n)); 
    } 
} 
  
// This code is contributed by Ita_c. 
