package boj.BarkingDog_Collection.TopologicalSorting;

/**
 * ACM Craft 골드3
 * Topological Sorting
 * Time: 12:01PM ~ 12:15PM
 */
import java.io.*;
import java.util.*;
public class BOJ1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();  // 출력용
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        while (t-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 건물의 개수
            int k = Integer.parseInt(st.nextToken()); // 건설순서 규칙의 개수

            int [] indegree = new int[n+1];
            ArrayList<Integer>[] graph = new ArrayList[n+1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            int [] original = new int[n+1]; // 각 건물이 해당 건물만을 짓는 시간
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                original[i] = Integer.parseInt(st.nextToken());
            }

            while (k-->0){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                graph[v1].add(v2);
                indegree[v2]++;
            }

            int target = Integer.parseInt(br.readLine());

            int [] time = Arrays.copyOf(original, original.length);

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if(indegree[i] == 0) q.add(i);
            }

            while (!q.isEmpty()){
                int cur = q.poll();
                for (int i = 0; i < graph[cur].size(); i++) {
                    int next = graph[cur].get(i);
                    time[next] = Math.max(time[next], time[cur] + original[next]);
                    if(--indegree[next] == 0) q.add(next);
                }
            }
            sb.append(time[target]).append("\n");
        }

        System.out.println(sb);
    }
}