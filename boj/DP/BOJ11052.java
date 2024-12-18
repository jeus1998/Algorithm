package boj.DP;

import java.util.*;
import java.io.*;
public class BOJ11052 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] memo = new int [n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            memo[i] = Integer.parseInt(st.nextToken());
        }
        int [] dp = new int [n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i - j < 0) break;
                dp[i] = Math.max(dp[i-j] + memo[j], dp[i]);
            }
        }
        System.out.println(dp[n]);
    }
}
/** 카드 구매하기

 카드는 카드팩의 형태로만 구매할 수 있고,
 카드팩의 종류는 카드 1개가 포함된 카드팩, 카드 2개가 포함된 카드팩, ... 카드 N개가 포함된 카드팩과 같이 총 N가지가 존재
 민규는 카드의 개수가 적은 팩이더라도 가격이 비싸면 높은 등급의 카드가 많이 들어있을 것이라는 미신을 믿고 있다.
 따라서, 민규는 돈을 최대한 많이 지불해서 카드 N개 구매하려고 한다.
 카드가 i개 포함된 카드팩의 가격은 Pi원

 카드팩이 총 4가지 종류가 있고, P1 = 1, P2 = 5, P3 = 6, P4 = 7
 민규가 카드 4개를 갖기 위해 지불해야 하는 금액의 최댓값은 10
 2개 들어있는 카드팩을 2번 사면 된다.

 카드 팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최댓값을 구하는 프로그램을 작성
 */