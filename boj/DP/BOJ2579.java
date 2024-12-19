package boj.DP;

import java.io.*;
public class BOJ2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] score = new int [n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        int [][] dp = new int [2][n+1];
        dp[0][1] = score[0];
        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(dp[0][i-2], dp[1][i-2]) + score[i-1];
            dp[1][i] = score[i-1] + dp[0][i-1];
        }
        System.out.println(Math.max(dp[0][n], dp[1][n]));
    }
}
/** 계단 오르기

 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성

 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있
 연속된 세 개의 계단을 모두 밟아서는 안 된다.
 마지막 도착 계단은 반드시 밟아야 한다.

 10, 20, 15, 25, 10, 20 -> 75

 dp[2][6] -> dp[0][1] 연속 x dp[1][1] 연속 o
 */