package programmers2.HighScoreKit.ExhaustiveSearch;

/**
 * 완전탐색/모의고사
 * LEVEL 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */
import java.util.*;
import java.util.stream.*;
public class ExhaustiveSearch2 {
	private static final int [][] person = {
			{1, 2, 3, 4, 5},
			{2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
	};
	public int[] solution(final int[] answers) {
		int [] score = new int[3];
		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < 3; j++) {
				if(answers[i] == person[j][i % person[j].length]) {
					score[j]++;
				}
			}
		}
		int max = Arrays.stream(score).max().getAsInt();
		return IntStream.range(0, score.length)
			.filter(i -> score[i] == max)
			.map(i -> i + 1)
			.toArray();
	}
}
/*
1번: 1, 2, 3, 4, 5
2번: 2, 1, 2, 3, 2, 4, 2, 5
3번: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
 */