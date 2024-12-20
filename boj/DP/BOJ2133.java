package boj.DP;

import java.util.*;
public class BOJ2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] dp = new int [31];
        dp[2] = 3;
        for (int i = 4; i <= 30; i+=2) {
            int cnt = 3;
            for (int j = i - 2; j >=2; j-=2) {
                dp[i] += dp[j] * cnt;
                if(cnt == 3) cnt--;
            }
            dp[i] += 2;
        }
        System.out.println(dp[n]);
    }
}


/** 타일 채우기

 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수

 홀수 = 0

 dp[2] = 3
 dp[4] = 8
 dp[6] = 48
 dp[8] =


 */
