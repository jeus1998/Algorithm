package boj.DP;

import java.io.*;
public class BOJ9095 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();

        int [] memo = new int [t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            memo[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, memo[i]);
        }
        if(max < 3) max = 3;
        int [] dp = new int [max+1];
        dp[1] = 1; // 1
        dp[2] = 2; // 1 + 1, 2
        dp[3] = 4; // 1 + 1 + 1, 1 + 2, 2 + 1, 3
        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        for (int i = 0; i < t; i++) {
            sb.append(dp[memo[i]]).append("\n");
        }
        System.out.println(sb);
    }
}
/** 1,2,3 더하기

 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다.
 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

 1+1+1+1
 1+1+2
 1+2+1
 2+1+1
 2+2
 1+3
 3+1

 각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수

 */
