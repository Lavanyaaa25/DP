import java.util.Arrays;

public class ClimbingStairs {
    //number of ways in which u can reach the nth step starting from 0th stairs by moving 1 step or two

    private int memo(int n,int[] dp){
        if(n==0||n==1)
            return 1;
        if(dp[n]==-1){
            int x=memo(n-1,dp);
            int y=memo(n-2,dp);
            dp[n]=x+y;
        }
       return dp[n];
    }

    private int tabu(int n,int[] dp){
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }

    private int space(int n){
        int p1=1,p2=1;
        for(int i=2;i<=n;i++){
            int curr=p1+p2;
            p2=p1;
            p1=curr;
        }
        return p1;
    }
    public void findClimbingStairsWay(int n){
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
    System.out.println("Memo="+memo(n,dp));
    System.out.println("Tabulation="+tabu(n,dp));
    System.out.println("Space="+space(n));

    }
}
