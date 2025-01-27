package boj.workbook_8708;

/**
 * 쿠키의 신체 측정 - 실버4
 */
import java.io.*;
import java.util.*;
public class BOJ_20125 {
    static int [] heart = {0,0};
    static int [] length = new int [5];
    static int n;

    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};

    static boolean [][] visited;
    static int [][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] array = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if(array[j].equals("*")) {
                    map[i][j] = 1;
                }
            }
        }

        visited = new boolean[n][n];

        int leftArm  = 0; // 왼쪽 팔
        int rightArm = 0; // 오른쪽 팔
        int waist = -1;    // 허리

        // bfs1 - 왼쪽 팔, 오른쪽 팔, 허리
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 0){
                    visited[i][j] = true;
                    continue;
                }
                flag = true;
                visited[i][j] = true;
                heart[0] = i + 1; heart[1] = j; // 심장 위치 기록
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[] {i,j});
                while (!q.isEmpty()){
                    int [] cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur[0] + arx[k];
                        int ny = cur[1] + ary[k];
                        if(!validation(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) continue;
                        visited[nx][ny] = true;
                        if(k == 1) waist++;
                        if(k == 2) leftArm++;
                        if(k == 3) rightArm++;
                        q.add(new int[] {nx,ny});
                    }
                }
                break;
            }
            if(flag) break;
        }
        int[] result = bfs();
        StringBuilder sb = new StringBuilder();
        sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n");
        sb.append(leftArm).append(" ").append(rightArm).append(" ").append(waist)
                .append(" ").append(result[0]).append(" ").append(result[1]);

        System.out.println(sb);

    }
    public static int [] bfs(){
        int leftLeg = 0;
        int rightLeg = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j] || map[i][j] == 0) continue;
                visited[i][j] = true;
                num++;
                if(num == 1) leftLeg++;
                else rightLeg++;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[] {i,j});
                while (!q.isEmpty()){
                    int[] cur = q.poll();
                    int nx = cur[0] + arx[1];
                    if(!validation(nx, cur[1]) || map[nx][j] == 0) break;
                    visited[nx][j] = true;
                    if(num == 1) leftLeg++;
                    else rightLeg++;
                    q.add(new int[] {nx,j});
                }
            }
            if(num == 2) return new int [] {leftLeg,rightLeg};
        }
        return new int [] {leftLeg,rightLeg};
    }

    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < n) return true;
        return false;
    }
}
