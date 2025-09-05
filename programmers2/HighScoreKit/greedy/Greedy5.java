package programmers2.HighScoreKit.greedy;

/*
 * 탐욕법/섬 연결하기
 * LEVEL 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/42861
 * 알고리즘 설명
 * 최소 신장 트리(Minimum Spanning Tree, MST)를 찾는 문제로,
 * 크루스칼(Kruskal) 알고리즘이나 프림(Prim) 알고리즘을 사용할 수 있습니다.
 * - 프림 알고리즘(우선순위 큐 활용): solution1
 * - 크루스칼 알고리즘(Union-Find 활용): solution2
 */
import java.util.*;
import java.util.stream.*;
public class Greedy5 {

	// 프림 알고리즘
	public int solution1(int n, int[][] costs) {
		// 그래프 초기화
		ArrayList<int[]>[] graph = new ArrayList[n];
		IntStream.range(0, n).forEach(i -> {
			graph[i] = new ArrayList<>();
		});

		// 그래프 양방향 연결
		IntStream.range(0, costs.length).forEach(i -> {
			graph[costs[i][0]].add(new int [] {costs[i][1], costs[i][2]});
			graph[costs[i][1]].add(new int [] {costs[i][0], costs[i][2]});
		});
		// 우선순위 큐
		PriorityQueue<int[]> pq =
			new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		int answer = 0; // 사용 cost
		int cnt = 0; // 연결된 간선의 개수
		boolean [] visited = new boolean[n]; // 방문 체크용 배열
		visited[0] = true;
		pq.addAll(graph[0]);
		while(cnt < n - 1) {
			int [] cur = pq.poll();
			if(visited[cur[0]]) continue;
			visited[cur[0]] = true;
			answer += cur[1];
			cnt++;
			for(int [] next : graph[cur[0]]) {
				if(visited[next[0]]) continue;
				pq.add(next);
			}
		}
		return answer;
	}
	// 크루스칼 알고리즘
	public int solution2(int n, int[][] costs) {
		init(n, costs);
		int cnt = 0;
		int answer = 0;
		for(int [] cur : costs) {
			if(cnt == n - 1) break;
			if(find(cur[0]) == find(cur[1])) continue;
			union(cur[0], cur[1]);
			cnt++;
			answer += cur[2];
		}
		return answer;
	}
	public static int [] group;
	public static void init(int n, int [][] costs) {
		group = new int [n];
		for(int i = 1; i < n; i++){
			group[i] = i;
		}
		// cost 순서대로 오름차순 정렬
		Arrays.sort(costs, (o1, o2) -> {
			return o1[2] - o2[2];
		});
	}
	public static int find(int num) {
		if(num == group[num]) return num;
		else return group[num] = find(group[num]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x < y) group[y] = x;
		else group[x] = y;
	}
}
