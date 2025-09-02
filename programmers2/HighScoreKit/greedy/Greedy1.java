package programmers2.HighScoreKit.greedy;


/**
 * 탐욕법/체육복
 * LEVEL 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */
import java.util.*;
import java.util.stream.*;
public class Greedy1 {
	public int solution(int n, int[] lost, int[] reserve) {
		int [] memo = new int[n+1];
		// 모든 학생 1로 초기화
		Arrays.fill(memo, 1);
		memo[0] = 0;
		// 여벌 체육복 있는 학생 +1
		for (int i : reserve) {
			memo[i]++;
		}
		// 체육복 잃어버린 학생 -1
		for (int i : lost) {
			memo[i]--;
		}
		for (int i = 1; i <= n; i++) {
			// 이미 체육복 있는 경우
			if(memo[i] >= 1) continue;

			// 맨 앞 학생인 경우
			if(i == 1) {
				if(memo[i + 1] == 2) {
					memo[i]++;
					memo[i + 1]--;
				}
				continue;
			}

			// 맨 뒤 학생인 경우
			if(i == n) {
				if(memo[i - 1] == 2) {
					memo[i]++;
					memo[i - 1]--;
				}
				continue;
			}

			// 앞 뒤 학생 확인
			if(memo[i - 1] == 2) {
				memo[i]++;
				memo[i - 1]--;
			}
			else if(memo[i + 1] == 2) {
				memo[i]++;
				memo[i + 1]--;
			}
		}

		return (int) IntStream.range(1, n + 1).filter(e -> memo[e] >= 1).count();
	}
}
/*
최대한 많은 학생들이 체육수업을 들을 수 있도록


 */