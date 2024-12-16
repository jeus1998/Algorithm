package boj.DP;

import java.io.*;
import java.util.*;
public class BOJ1520 {
    static int n,m;
    static int [][] map, dp;
    static boolean [][] visited;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int [n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];
        visited[0][0] = true;
        dp = new int [n][m];
        dp[n-1][m-1] = 1;
        System.out.println(dfs(0, 0));
    }
    public static int dfs(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = arx[i] + x;
            int ny = ary[i] + y;
            if(!validation(nx, ny) || map[x][y] <= map[nx][ny]) continue;
            if(!visited[nx][ny]){
                visited[nx][ny] = true;
                dp[x][y] += dfs(nx, ny);
            }
            else dp[x][y] += dp[nx][ny];
        }
        return dp[x][y];
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        return false;
    }
}
/**
 한 칸은 한 지점을 나타내는데 각 칸에는 그 지점의 높이가 쓰여 있으며
 각 지점 사이의 이동은 지도에서 상하좌우 이웃한 곳끼리만 가능하다.
 현재 제일 왼쪽 위 칸이 나타내는 지점에 있는 세준이는 제일 오른쪽 아래 칸이 나타내는 지점으로 가려고 한다.
 그런데 가능한 힘을 적게 들이고 싶어 항상 높이가 더 낮은 지점으로만 이동하여 목표 지점까지 가고자 한다.
 지도가 주어질 때 이와 같이 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽 아래 지점까지 항상 내리막길로만
 이동하는 경로의 개수를 구하는 프로그램을 작성하시오.

 M과 N은 각각 500이하의 자연수이고, 각 지점의 높이는 10000이하의 자연수이다.

 [3, 2, 2, 2, 1]
 [1, 0, 0, 1, 1]
 [1, 0, 0, 1, 0]
 [1, 1, 1, 1, 1]
 */