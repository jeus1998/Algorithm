package boj.workbook_8708;

/**
 * 숫자 고르기 -
 */
import java.util.*;
import java.io.*;
public class BOJ_2668 {
    static int [] memo;
    static boolean [] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            memo[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (Integer i : list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int cur, int start){
         if(memo[cur] == start){
             list.add(start);
             return;
         }
         if(!visited[memo[cur]]){
             visited[memo[cur]] = true;
             dfs(memo[cur], start);
         }
    }
}

