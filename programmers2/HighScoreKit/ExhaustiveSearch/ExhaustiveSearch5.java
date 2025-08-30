package programmers2.HighScoreKit.ExhaustiveSearch;

/**
 * 완전탐색/피로도
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class ExhaustiveSearch5 {
	private static int [][] dungeons;
	private static boolean [] visited;
	private static int max = 0;
	private static int size = 0;
	public int solution(int k, int[][] dungeons) {
		init(dungeons);
		func(k, 0);
		return max;
	}
	public static void init(int [][] dungeon) {
		dungeons = dungeon;
		size = dungeon.length;
		visited = new boolean[size];
	}
	public static void func(int k, int depth) {
		max = Math.max(max, depth);
		if(max == size) {
			return;
		}
		for (int i = 0; i < size; i++) {
			if(visited[i] || k < dungeons[i][0]) continue;
			visited[i] = true;
			func(k - dungeons[i][1], depth + 1);
			visited[i] = false;
		}
	}

}
/*
최소 필요 피로도, 소모 피로도
탐험 가능한 최대 던전 수


 */

