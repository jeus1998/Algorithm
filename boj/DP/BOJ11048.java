package boj.DP;

import java.io.*;
import java.util.*;
public class BOJ11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int [][] maze = new int [n+1][m+1];
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                maze[i][j] = Integer.parseInt(st.nextToken());
                maze[i][j] += Math.max(maze[i-1][j], Math.max(maze[i-1][j-1], maze[i][j-1]));
            }
        }
        System.out.println(maze[n][m]);
    }
}

/**

 준규는 N×M 크기의 미로에 갇혀있다.
 미로는 1×1크기의 방으로 나누어져 있고, 각 방에는 사탕이 놓여져 있다.
 준규는 현재 (1, 1)에 있고, (N, M)으로 이동하려고 한다.
 준규가 (r, c)에 있으면, (r+1, c), (r, c+1), (r+1, c+1)로 이동할 수 있고,
 각 방을 방문할 때마다 방에 놓여져있는 사탕을 모두 가져갈 수 있다. 또, 미로 밖으로 나갈 수는 없다.
 준규가 (N, M)으로 이동할 때, 가져올 수 있는 사탕 개수의 최댓값을 구하시오.

 (r+1, c): 아래
 (r, c+1): 오른쪽
 (r+1, c+1): 대각선 아래 + 오른쪽

 3가지로만 이동 가능

 사탕의 개수 (0 <= candy <= 100)

 dp[n][m] 최댓값을 반환하는게 목표

 */