package programmers2.HighScoreKit.ExhaustiveSearch;

/**
 * 완전탐색/카펫
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
import java.util.*;
public class ExhaustiveSearch4 {
	public int[] solution(int brown, int yellow) {
		// 1. yellow 약수 구하기 (가로 >= 세로)
		ArrayList<int []> candidates = new ArrayList<>();
		for(int i = 1; i <= Math.sqrt(yellow); i++) {
			if(yellow % i == 0) {
				candidates.add(new int [] {yellow / i, i});
			}
		}
		// 2. 후보중에서 brown 개수 맞는 케이스 구하기
		for (int[] candidate : candidates) {
			int sum = (candidate[0] + 2) * 2 + (candidate[1] * 2);
			if(sum == brown) return new int [] {candidate[0] + 2, candidate[1] + 2};
		}

		// 3. return
		return new int [] {};
	}
}
/*
- parameter: brown(count), yellow(count)
- 가로 길이 >= 세로 길이
- return [] {가로, 세로}

[10, 2]  -> [4, 3]
[8, 1]   -> [3, 3]
[24, 24] -> [8, 6]

think simple

가로 >= 세로  && Math.min(가로 - 세로) -> answer

 */
