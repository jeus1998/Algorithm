package boj.workbook_8708;

/**
 * 인구이동 - 골드4
 */
import java.io.*;
import java.util.*;
public class BOJ_16234 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정사각형 N
        int l = Integer.parseInt(st.nextToken()); // 인구 이동 조건
        int r = Integer.parseInt(st.nextToken()); // 인구 이동 조건
        int [][] map = new int[n][n];
        for (int i = 0; i < n; i++) { // 초기 데이터
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;
        while (true){
            boolean [][] visited = new boolean[n][n];
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j]) continue;
                    visited[i][j] = true;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    ArrayList<int []> union = new ArrayList<>();
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur[0] + arx[k];
                            int ny = cur[1] + ary[k];
                            if(!validate(nx, ny) || visited[nx][ny]) continue;
                            int gap = Math.abs(map[nx][ny] - map[cur[0]][cur[1]]);
                            if(l <= gap && gap <= r){
                                visited[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                                union.add(new int[]{nx, ny});
                            }
                        }
                    }
                    if(union.isEmpty()) continue;
                    flag = true;
                    int count = 1 + union.size();
                    int sum = map[i][j];
                    for (int k = 0; k < union.size(); k++) {
                        sum += map[union.get(k)[0]][union.get(k)[1]];
                    }
                    int result = sum / count;
                    map[i][j] = result;
                    for (int k = 0; k < union.size(); k++) {
                        map[union.get(k)[0]][union.get(k)[1]] = result;
                    }
                }
            }
            if(flag){
                day++;
                continue;
            }
            break;
        }
        System.out.println(day);
    }
    public static boolean validate(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < n) return true;
        return false;
    }
}
/*
인구 이동이 없을 때까지 반복

두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선 개방
국경선이 열려있어 이동할 수 있으면, 그 나라를 하루 동안은 연합이라고 한다.
각 칸의 인구수는 연합의 이구수 / 연합을 이루는 칸의 개수
연합을 해체하고, 모두 국경선을 닫는다.

인구 이동이 며칠 동안 발생하는지 구하는 프로그램 작성

 */