import java.util.*;

public class Fibo {
    // 0 1 1 2 3 5 8 13 21..
    // f(n)= f(n-1) + f(n-2)
    private int memo(int n, int[] dp){
        //TC= O(n) SC= O(n) stack space +0(n) array size
        if(n==0||n==1)
            return n;
        if(dp[n]!=0)
            dp[n]=memo(n-1,dp)+memo(n-2,dp);
        return dp[n];
    }

    private int tabu(int n,int[] dp){
        //TC=O(n)
        //SC=O(n) no stack space
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2]; //replace f(n-1) to dp(n-1)
        return dp[n];
    }

    private int space(int n){
        //TC=O(n) SC=O(1)
        int prev1=1,prev2=0;
        for(int i=2;i<=n;i++)
        {
            int curr=prev2+prev1;
            prev2=prev1;
            prev1=curr;
        }
        return prev1; //prev1 stores the curr;
    }

    public void findFibo(int n){
        int[] dp=new int[n+1]; //avoid global declaration
        Arrays.fill(dp,-1);
        System.out.println("Memoization="+memo(n,dp));
        System.out.println("Tabulation="+tabu(n,dp));
        System.out.println("Space-optimization="+space(n));
    }
}
