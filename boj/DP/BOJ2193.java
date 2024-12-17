package boj.DP;

import java.util.*;
public class BOJ2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [][] dp = new long [2][n + 1];
        dp[0][1] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[0][i] = dp[0][i-1] + dp[1][i-1];
            dp[1][i] = dp[0][i-1];
        }
        System.out.println(dp[0][n] + dp[1][n]);
    }
}

/**
 0과 1로만 이루어진 수를 이진수라 한다.
 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다.

 이친수는 0으로 시작하지 않는다.
 이친수에서는 1이 두 번 연속으로 나타나지 않는다.

 예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다.
 N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.

 int [][] dp = new int [2][n]

 dp[0][n] = dp[0][n-1] + dp[1][n-1]
 dp[1][n] = dp[0][n-1]

 dp[0][1] = 0
 dp[1][1] = 1

 dp[0][2] = 1  -> dp[0][1] + dp[1][1]
 dp[1][2] = 0  -> dp[0][1]

 dp[0][3] = 1
 dp[1][3] = 1

 [0, 0, 0, 0]
 [0, 1, 0, 0]

 */