package programmers2.HighScoreKit.ExhaustiveSearch;

import java.util.Arrays;

/**
 * 완전탐색/모음사전
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */
public class ExhaustiveSearch7 {
	private static final char [] words = {'A', 'E', 'I', 'O', 'U'};
	private static char [] memo = new char [5];
	private static char[] targetArr;
	private static int count = 0;
	private static int answer = -1;
	public int solution(String word) {
		targetArr = word.toCharArray();
		func(0);
		return answer;
	}
	public static void func(int depth) {
		if(answer != -1 || depth == 5) return;
		for (int i = 0; i < 5; i++) {
			count++;
			memo[depth] = words[i];
			if(answer == -1 && targetArr.length == depth + 1) {
				boolean isSame = true;
				for (int j = 0; j < depth + 1; j++) {
					if(memo[j] != targetArr[j]) {
						isSame = false;
						break;
					}
				}
				if(isSame) answer = count;
			}
			func(depth + 1);
		}
	}
}
