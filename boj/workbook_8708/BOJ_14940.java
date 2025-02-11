package boj.workbook_8708;

/**
 * 쉬운 최단거리 - 실버1
 */
import java.io.*;
import java.util.*;
public class BOJ_14940 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static final int INF = 1000 * 1000;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int [][] map = new int[n][m];

        int target_x = 0;
        int target_y = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    target_x = i;
                    target_y = j;
                }
            }
        }

        int [][] answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(answer[i], INF);
        }
        answer[target_x][target_y] = 0;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[] {target_x,target_y});
        while(!q.isEmpty()) {
            int [] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + arx[i];
                int ny = y + ary[i];
                if(!validation(nx, ny) || map[nx][ny] == 0) continue;
                if(answer[nx][ny] > answer[x][y] + 1) {
                    answer[nx][ny] = answer[x][y] + 1;
                    q.add(new int[] {nx, ny});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(map[i][j] == 0){
                    sb.append(0).append(" ");
                    continue;
                }
                if(answer[i][j] == INF){
                    sb.append(-1).append(" ");
                    continue;
                }
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        return false;
    }
}
