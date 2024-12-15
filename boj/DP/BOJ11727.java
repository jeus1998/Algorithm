package boj.DP;

import java.util.*;
public class BOJ11727 {
    static final int INF = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] dp = new int [n+2];
        dp[1] = 1; dp[2] = 3;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + (dp[i-2] * 2);
            dp[i] %= INF;
        }
        System.out.println(dp[n]);
    }
}
/**

 2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오

 dp[1] = 1
 dp[2] = 3
 dp[3] = 5
 dp[4] = 11

 n >= 3
 d[n] = dp[n-1] + dp[n-2] * 2



 */