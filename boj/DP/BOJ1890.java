package boj.DP;

import java.io.*;
import java.util.*;
public class BOJ1890 {
    static int n;
    static int [] arx = {0, 1};
    static int [] ary = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int [][] map = new int [n][n];
        long [][] dp  = new long [n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(dp[i][j] == 0 || map[i][j] == 0) continue;
                for (int k = 0; k < 2; k++) {
                    int nx = (arx[k] * map[i][j]) + i;
                    int ny = (ary[k] * map[i][j]) + j;
                    if(validation(nx, ny)){
                        dp[nx][ny] += dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < n) return true;
        return false;
    }
}

/**
 N×N 게임판에 수가 적혀져 있다.
 이 게임의 목표는 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 점프를 해서 가는 것이다.
 각 칸에 적혀있는 수는 현재 칸에서 갈 수 있는 거리를 의미한다.
 반드시 오른쪽이나 아래쪽으로만 이동해야 한다. 0은 더 이상 진행을 막는 종착점
 한 번 점프를 할 때, 방향을 바꾸면 안 된다. 즉, 한 칸에서 오른쪽으로 점프를 하거나, 아래로 점프를 하는 두 경우만 존재한다.
 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 이동할 수 있는 경로의 개수를 구하는 프로그램을 작성하시오.

 게임 판의 크기 N (4 ≤ N ≤ 100)이 주어진다


 [1, 0, 1, 0]
 [0, 0, 0, 0]
 [1, 1, 0, 1]
 [1, 0, 1, 12]

 */