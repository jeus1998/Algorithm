package boj.BarkingDog_Collection.TopologicalSorting;

/**
 * 작업 골드4
 * Topological Sorting
 * Time: 11:25AM ~ 11:59AM
 */
import java.io.*;
import java.util.*;
public class BOJ2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // indegree
        int [] indegree = new int[n+1];

        // 그래프 초기화
        ArrayList<Integer>[] graph = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int [] time = new int[n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken()); // <- 작업마다 걸리는 시간

            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                int job = Integer.parseInt(st.nextToken());
                indegree[i]++;
                graph[job].add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int [] copy = Arrays.copyOf(time, time.length);

        while (!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                time[next] = Math.max(time[cur] + copy[next], time[next]);
                if(--indegree[next] == 0){
                   q.add(next);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, time[i]);
        }
        System.out.println(max);
    }
}
