package boj.BarkingDog_Collection.TopologicalSorting;

/**
 * 계보 복원가 호석 골드3
 * Topological Sorting
 * 시간초과 발생 코드 -> 레벨 구하는 알고리즘을 위상 정렬과 동시에 진행하고 bfs를 통해서 child를 채우면 통과할듯하다.
 */
import java.io.*;
import java.util.*;
public class BOJ21276_TimeOut {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 사람의 수

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        ArrayList<String> names = new ArrayList<>(); // 석호촌 사람들 저장

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String name = st.nextToken();
            names.add(name);
            map1.put(i, name);
            map2.put(name, i);
        }

        // 그래프, child 초기화
        ArrayList<Integer>[] graph = new ArrayList[n];
        ArrayList<Integer>[] reverseGraph = new ArrayList[n];
        ArrayList<String>[] child = new ArrayList[n]; // 자식들을 저장한다.
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            child[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        int [] indegree = new int[n];

        int m = Integer.parseInt(br.readLine()); // 간선의 개수
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            String name1 = st.nextToken();
            String name2 = st.nextToken();

            int idx1 = map2.get(name1);
            int idx2 = map2.get(name2);

            graph[idx1].add(idx2);
            reverseGraph[idx2].add(idx1);
            indegree[idx2]++;
        }

        ArrayList<String> ancestor = new ArrayList<>(); // 조상들만 넣는 리스트 <- 간선이 존재하지 않는 정점

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        // 위상 정렬을 알고리즘 시작
        while (!q.isEmpty()){
            int cur = q.poll();

            if(graph[cur].isEmpty()){ // <- 조상
                ancestor.add(map1.get(cur));
                continue;
            }

            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                indegree[next]--;
                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }

        // 레벨 구하기
        int [] depth = new int[n]; // level 기록용
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < ancestor.size(); i++) {
            int idx = map2.get(ancestor.get(i));
            depth[idx] = 0;
            queue.add(new int[]{idx, 0});
        }

        while (!queue.isEmpty()){
            int [] temp = queue.poll();
            for (int i = 0; i < reverseGraph[temp[0]].size(); i++) {
                int next = reverseGraph[temp[0]].get(i);
                if(depth[next] >= temp[1] + 1) continue;
                depth[next] = temp[1] + 1;
                queue.add(new int[]{next, temp[1] + 1});
            }
        }

        // 바로 직속 자식을 구하기 위한 bfs
        for (int i = 0; i < ancestor.size(); i++) {
            int idx = map2.get(ancestor.get(i));
            q.add(idx);
        }

        while (!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0; i < reverseGraph[cur].size(); i++) {
                int next = reverseGraph[cur].get(i);
                if(depth[next] - depth[cur] == 1){
                    child[cur].add(map1.get(next));
                    q.add(next);
                }
            }
        }

        // 출력용 StringBuilder
        StringBuilder sb = new StringBuilder();

        sb.append(ancestor.size()).append("\n"); // 조상의 개수

        Collections.sort(ancestor); // 조상을 사전순으로 출력하기 위해 정렬
        for (String s : ancestor) {
            sb.append(s).append(" ");
        }
        sb.append("\n");

        Collections.sort(names); // 마을의 사람들을 사전순서로 정렬
        for (String name : names) {
            int idx = map2.get(name);
            Collections.sort(child[idx]); // 현재 이름의 자식들을 사전 순서대로 정렬
            sb.append(name).append(" ").append(child[idx].size()).append(" ");
            for (String s : child[idx]) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
