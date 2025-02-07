import java.util.Arrays;

public class FrogJump {
    //frog wants to reach nth sth stair from 1st
    // he can jump to i+1th or i+2th stair. Energy lost in jumping in height[i-1]-height[j-1]
    // height[i] is the height of i+1th stair
    //1 based index

    //why greedy doesnt work? In future we might lose significant value
    private int memo(int n,int [] h,int[] dp){
        //TC=O(n) SC=O(n)+0(n)
        if(n==0)
            return 0;
        if(dp[n]==-1) {
            int y = Integer.MAX_VALUE;
            int x = Math.abs(h[n] - h[n - 1]) + memo(n - 1, h, dp);
            if (n - 2 >= 0)
                y = Math.abs(h[n] - h[n - 2]) + memo(n - 2, h, dp);
            dp[n]=Math.min(x, y);
        }
        return dp[n];
    }

    private int tabu(int n,int[] h,int[] dp){
        //TC=O(n) SC=O(n)
        dp[0]=0;
        int y=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int x=dp[i-1]+Math.abs(h[i]-h[i-1]);
            if(i>1)
                y=dp[i-2]+Math.abs(h[i]-h[i-2]);
            dp[i]=Math.min(x,y);
        }
        return dp[n];
    }
    private int space(int n,int[] h){
        //TC=O(n) SC=O(1)
        int x=0,y=0;
        for(int i=1;i<=n;i++){
            int l=Integer.MAX_VALUE;
            int k=x+Math.abs(h[i]-h[i-1]);
            if(i>1)
                l=y+Math.abs(h[i]-h[i-2]);
            int curr=Math.min(k,l);
            y=x;
            x=curr;
        }
        return x;
    }
    public void calculateMin(int n,int[] h){
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println("Memo="+memo(n-1,h,dp));
        System.out.println("Tabu="+tabu(n-1,h,dp));
        System.out.println("Space="+space(n-1,h));
    }
}
