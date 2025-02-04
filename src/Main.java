public class Main {
    public static void main(String[] args) {

        //tabulation=bottom up
        //memoization=top down
        //overlapping sub problems=solving same problems again and again
        //tend to store the value of sub problems in map or n-d array (n=number of params)
        // think max size of n

        //steps to convert recursion to dp
        //1. declare dp[n+1]  2. store the value of f(n)  3. check if f(n) is already computed

        // try to represent the problem in terms of index
        // do all possible stuffs on that index acc to prob statement
        // sum of all stuffs= counts all way, min=to find minimum


//        Fibo obj=new Fibo();
//        obj.findFibo(5);

        ClimbingStairs c=new ClimbingStairs();
        c.findClimbingStairsWay(10);
        }
    }
