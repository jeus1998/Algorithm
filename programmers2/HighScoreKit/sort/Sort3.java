package programmers2.HighScoreKit.sort;

/**
 * 정렬/H-Index
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
import java.util.*;
public class Sort3 {
	public int solution(int[] citations) {
		Arrays.sort(citations);
		int size = citations.length;
		int answer = 0;
		for (int i = 0; i < size; i++) {
			int h = size - i;
			if(citations[i] >= h) {
				answer = Math.max(answer, h);
			}
		}
		return answer;
	}
}
/*
어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고, 나머지 논문이 h번 이하 인용되었다면
h의 최댓값을 이 과학자의 H-Index라고 합니다.

[3, 0, 6, 1, 5]	3

0, 1, 3, 5, 6

0 >= 5 -> false
1 >= 4 -> false
3 >= 3 -> true
5 >= 2 -> true(h-index: 2)


3번 이상 3개
나머지 3개 이하
 */