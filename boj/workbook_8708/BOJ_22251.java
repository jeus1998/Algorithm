package boj.workbook_8708;

/**
 * 빌런 호석
 */
import java.io.*;
import java.util.*;
public class BOJ_22251 {
    static int n, k, p, x;
    static int [][] numbers = {
            {1,1,1,1,1,1,0}, // 0
            {0,1,1,0,0,0,0}, // 1
            {1,1,0,1,1,0,1}, // 2
            {1,1,1,1,0,0,1}, // 3
            {0,1,1,0,0,1,1}, // 4
            {1,0,1,1,0,1,1}, // 5
            {1,0,1,1,1,1,1}, // 6
            {1,1,1,0,0,0,0}, // 7
            {1,1,1,1,1,1,1}, // 8
            {1,1,1,1,0,1,1}  // 9
    };
    static int[][] memo = new int[10][10];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 1 ~ n층
        k = Integer.parseInt(st.nextToken()); // 디스플레이 k 자리의 수
        p = Integer.parseInt(st.nextToken()); // 1 ~ 최대 p개 반전
        x = Integer.parseInt(st.nextToken()); // x층
        init();
        int [] check = new int[k];
        String current = String.valueOf(x);
        int index = k - 1;
        for (int i = current.length() - 1; i >= 0; i--) {
            check[index--] = current.charAt(i) - '0';
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if(x == i) continue;
            int [] cur = new int[k];
            String s = String.valueOf(i);
            index = k - 1;
            for (int j = s.length() -1; j >= 0; j--) {
                cur[index--] = s.charAt(j) - '0';
            }
            int cnt = 0;
            for (int j = 0; j < k; j++) {
                if(check[j] == cur[j]) continue;
                cnt += memo[check[j]][cur[j]];
            }
            if(cnt <= p){
                answer++;
            }
        }
        System.out.println(answer);
    }
    public static void init(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(i == j) continue;
                if(memo[i][j] != 0) continue;
                int count = 0;
                for (int l = 0; l < 7; l++) {
                    if(numbers[i][l] != numbers[j][l]) count++;
                }
                memo[i][j] = count;
                memo[j][i] = count;
            }
        }
    }


}
/*
 */