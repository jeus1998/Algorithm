package boj.workbook_8708;

/**
 * DFS와 BFS 실버2
 */
import java.io.*;
import java.util.*;
public class BOJ_1260 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int v = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new boolean[n+1];

        // 그래프 초기화
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        dfs(v);

        sb.append("\n");
        visited = new boolean[n+1];
        bfs(v);

        System.out.println(sb);
    }
    public static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");
        Collections.sort(graph[v]);
        for (int i = 0; i < graph[v].size(); i++) {
             if (!visited[graph[v].get(i)]) {
                 dfs(graph[v].get(i));
             }
        }
    }
    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        sb.append(v).append(" ");
        q.add(v);
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                if(!visited[graph[cur].get(i)]) {
                    visited[graph[cur].get(i)] = true;
                    sb.append(graph[cur].get(i)).append(" ");
                    q.add(graph[cur].get(i));
                }
            }
        }
    }
}
