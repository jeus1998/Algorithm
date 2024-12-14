package boj.DP;

import java.util.*;
public class BOJ2747 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] dp;
        dp = new int [n + 1];
        if(n <= 1){
            dp = new int [2];
        }
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        System.out.println(dp[n]);
    }
}

/**

피보나치 수: DP[0] = 0 DP[1] = 1 DP[N] = DP[N-2] + DP[N-1]

n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성 (N <= 45)

 */
