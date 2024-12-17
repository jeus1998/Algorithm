package boj.DP;

import java.util.*;
import java.io.*;
public class BOJ11053 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] input = new int [n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int max = 1;
        int [] dp = new int [n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(input[i] > input[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
/** 가장 긴 증가하는 부분 수열

 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성

 수열 A = {10, 20, 10, 30, 20, 50}

 A = {10, 20, 30, 50} 이고, 길이는 4

 */
