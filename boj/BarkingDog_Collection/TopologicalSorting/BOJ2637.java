package boj.BarkingDog_Collection.TopologicalSorting;

/**
 * 장난감 조립 골드2
 * Topological Sorting
 * Time: 08:27AM~09:23AM
 */
import java.io.*;
import java.util.*;
public class BOJ2637 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 1 ~ N-1 : 기본 부품 or 중간 부품  N : 완제품
        int m = Integer.parseInt(br.readLine()); // 필요한 부품들 간의 관계

        ArrayList<int[]>[] graph = new ArrayList[n+1]; // 관계 기록용
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int [] indegree = new int[n+1];

        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            indegree[x]++;
            graph[y].add(new int[]{x, k});

        }

        HashMap<Integer, HashMap<Integer, Integer>> part = new HashMap<>();

        boolean [] basic = new boolean[n+1];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n; i++) { // 기본 부품들
            if(indegree[i] == 0){
                basic[i] = true;
                q.add(i);
            }
        }

        int [][] memo = new int[n+1][n+1];

        while (!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                int [] next = graph[cur].get(i);
                int target = next[0];
                int num = next[1]; // 개수

                if(basic[cur]){
                    memo[target][cur] = num;
                }
                else{
                    for (int j = 1; j < n; j++) {
                         memo[target][j] += memo[cur][j] * num;
                    }
                }
                if(--indegree[target] == 0) q.add(target);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(memo[n][i] != 0){
                sb.append(i).append(" ").append(memo[n][i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
/*
기본 부품 1,2,3,4

중간 부품 5 = {1, 2, 2}
중간 부품 6 = {5, 5, 3, 3, 3, 4, 4, 4}
완제품 7 = {5, 5, 6, 6, 6 4, 4, 4, 4, 4}

완제품 7 = {기본 부품 1 : 16, 기본 부품 2: 16, 기본부품 3: 9, 기본부품 4: 17 }

이와 같이 어떤 장난감 완제품과 그에 필요한 부품들 사이의 관계가 주어져 있을 때
하나의 장난감 완제품을 조립하기 위하여 필요한 기본 부품의 종류별 개수를 계산하는 프로그램을 작성하시오.
 */