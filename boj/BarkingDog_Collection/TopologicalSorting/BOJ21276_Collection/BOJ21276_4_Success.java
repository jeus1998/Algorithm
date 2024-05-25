package boj.BarkingDog_Collection.TopologicalSorting.BOJ21276_Collection;

/**
 * 계보 복원가 호석 골드3
 * Topological Sorting
 * BOJ21276_3_PartialSuccess 개선
 * 그래프를 주어진 입력에서 반대로 만든다 그렇게 해서 위상 정렬을 하면 직속 자식을 쉽게 구하는게 가능하다
 * 19/19 성공
 */
import java.io.*;
import java.util.*;
public class BOJ21276_4_Success {
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
        ArrayList<String>[] child = new ArrayList[n]; // 자식들을 저장한다.
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            child[i] = new ArrayList<>();
        }

        int [] indegree = new int[n];

        int m = Integer.parseInt(br.readLine()); // 간선의 개수
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            String name1 = st.nextToken();
            String name2 = st.nextToken();

            int idx1 = map2.get(name1);
            int idx2 = map2.get(name2);

            graph[idx2].add(idx1);  // 역방향 그래프로 만든다.
            indegree[idx1]++;
        }

        ArrayList<String> ancestor = new ArrayList<>(); // 조상들만 넣는 리스트 <- 간선이 존재하지 않는 정점

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(indegree[i] != 0) continue;
            q.add(i);
            ancestor.add(map1.get(i)); // 차수가 0이면 조상
        }

        while (!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if(--indegree[next] == 0){
                    q.add(next);
                    child[cur].add(map1.get(next));
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
