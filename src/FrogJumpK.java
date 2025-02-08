import java.util.*;
public class FrogJumpK {
    //can jum k steps instead of just one and two

    private int memo(int n,int[] dp,int k,int[] h){
        if(n==0)
            return 0;
        if(dp[n]==-1) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (n - j >= 0) {
                    int jump = Math.abs(h[n] - h[n - j]) + memo(n - j, dp, k, h);
                    min = Math.min(min, jump);
                }
            }
            dp[n]=min;
        }
        return dp[n];

    }

    private int tabu(int n,int[] dp,int k,int[] h){
        dp[0]=0;
        for(int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if (i-j>=0) {
                    int jump = Math.abs(h[i] - h[i - j]) + dp[i-j];
                    min=Math.min(min,jump);
                }
            }
            dp[i]=min;
        }
        return dp[n-1];
    }


    public void calculate(int n,int k,int[] h){
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        System.out.println("Memo="+memo(n-1,dp,k,h)); //memo n-1
        System.out.println("tabu="+tabu(n,dp,k,h)); //tabu n
//    Space optimization could be O(k)
    }
}
