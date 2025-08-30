package programmers2.HighScoreKit.ExhaustiveSearch;

/**
 * 완전탐색/최소직사각형
 * LEVEL 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */
public class ExhaustiveSearch1 {
	public int solution(int[][] sizes) {
		int size = sizes.length;
		int w = 0; // 가로
		int h = 0; // 세로

		// 길이가 긴 것을 가로로, 짧은 것을 세로로
		for (int i = 0; i < size; i++) {
			int max = Math.max(sizes[i][0], sizes[i][1]);
			int min = Math.min(sizes[i][0], sizes[i][1]);
			w = Math.max(w, max);
			h = Math.max(h, min);
		}

		return h * w;
	}
}
/*



 */