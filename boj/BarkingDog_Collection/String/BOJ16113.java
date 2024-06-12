package boj.BarkingDog_Collection.String;

/**
 * 시그널
 * 실버1
 */
import java.io.*;
import java.util.*;
public class BOJ16113 {
    static int [] arx ={-1,1,0,0};
    static int [] ary ={0,0,-1,1};
    static int [][] init = new int[10][2];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        // 행은 5 열은 m
        int m = n / 5;

        char [][] signal = new char[5][m];
        int cur = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < m; j++) {
                signal[i][j] = input.charAt(cur++);
            }
        }
        init();

        // 0,6 동일
        // 2,2 = '#' = 6 / 2,2 = '.' = 0

        StringBuilder sb = new StringBuilder();

        Queue<int[]> q = new LinkedList<>();
        boolean [] visited = new boolean[m];
        for (int i = 0; i < m; i++) {
            if(visited[i] || signal[0][i] == '.') continue;
            boolean [][] visit = new boolean[5][3];
            visit[0][0] = true;
            int max = 0; // 최단 거리
            int cnt = 1; // 면적의 크기
            q.add(new int[]{0,0,0});
            while (!q.isEmpty()){
                int [] temp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = temp[0] + arx[j];
                    int ny = temp[1] + ary[j];
                    if(0 <= nx && 0 <= ny && nx < 5 && ny < 3){
                         if(m <= ny + i) continue;
                         if(signal[nx][ny + i] == '.' || visit[nx][ny]) continue;
                         q.add(new int[]{nx,ny, temp[2] + 1});
                         if(temp[2] + 1 > max){
                             max = temp[2] + 1;
                         }
                         visit[nx][ny] = true;
                         cnt++;
                    }
                }
            }
            int answer = -1;
            for (int j = 0; j < 10; j++) {
                if(init[j][1] == max && init[j][0] == cnt){
                    answer = j;
                    break;
                }
            }
            if(answer == 0 || answer == 6){
                if(signal[2][i+1] == '.'){
                    answer = 0;
                }
                else answer = 6;
            }
            if(answer == 3 || answer == 5){
               if(signal[1][i] == '.'){
                   answer = 3;
               }
               else answer = 5;
            }

            visited[i] = true;
            if(answer != 1){
                visited[i+1] = true;
                visited[i+2] = true;
            }
            if(answer!= -1) sb.append(answer);
        }
        System.out.println(sb);
    }
    public static void init(){
        init[0][0] = 12;
        init[0][1] = 6;
        init[1][0] = 5;
        init[1][1] = 4;
        init[2][0] = 11;
        init[2][1] = 10;
        init[3][0] = 11;
        init[3][1] = 8;
        init[4][0] = 9;
        init[4][1] = 6;
        init[5][0] = 11;
        init[5][1] = 8;
        init[6][0] = 12;
        init[6][1] = 6;
        init[7][0] = 7;
        init[7][1] = 6;
        init[8][0] = 13;
        init[8][1] = 6;
        init[9][0] = 12;
        init[9][1] = 8;
    }
}
/*

0: 12, 6
1: 5, 4
2: 11, 10
3: 11, 8
4: 9, 6
5: 11, 6
6: 12, 6
7: 7, 6
8: 13, 6
9: 12, 8

 */