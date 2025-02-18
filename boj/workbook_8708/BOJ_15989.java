package boj.workbook_8708;

/**
 * 1,2,3 더하기 4 - 골드5
 */
import java.io.*;
public class BOJ_15989 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int t = Integer.parseInt(br.readLine());
         int [] numbers = new int[t];
         int max = 0;
         for (int i = 0; i < t; i++) {
             numbers[i] = Integer.parseInt(br.readLine());
             max = Math.max(max, numbers[i]);
         }
         int [] arr = new int [] {1, 2, 3};
         int [] dp = new int[max+1];
         for(int i = 0; i < 3; i++){
             dp[arr[i]] += 1;
             for (int j = 1; j <= max; j++){
                 if(j - arr[i] >= 0){
                     dp[j] += dp[j - arr[i]];
                 }
             }
         }
         StringBuilder sb = new StringBuilder();
         for(int i = 0; i < t; i++){
             sb.append(dp[numbers[i]]).append("\n");
         }
        System.out.println(sb);
    }
}
/*
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 4가지가 있다.
합을 나타낼 때는 수를 1개 이상 사용해야 한다.
합을 이루고 있는 수의 순서만 다른 것은 같은 것으로 친다.
 */