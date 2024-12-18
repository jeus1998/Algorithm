package boj.DP;

import java.util.*;
public class BOJ1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        int z = 1;
        while (z * z <= n){
            list.add(z*z);
            z++;
        }
        int [] memo = new int [list.size()];
        for (int i = 0; i < list.size(); i++) {
            memo[i] = list.get(i);
        }
        int [] dp = new int [n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < memo.length; j++) {
                if(i - memo[j] < 0) break;
                dp[i] = Math.min(dp[i], dp[i-memo[j]] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}

/** 제곱수의 합

 어떤 자연수 N은 그보다 작거나 같은 제곱수들의 합으로 나타낼 수 있다.
 예를 들어 11=3^2+1^2+1^2(3개 항)이다
 11=2^2+2^2+1^2+1^2+1^2(5개 항)도 가능
 11을 그 합으로써 표현할 수 있는 제곱수 항의 최소 개수는 3

 주어진 자연수 N을 이렇게 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하는 프로그램을 작성

 1 <= N <= 100,000
 */