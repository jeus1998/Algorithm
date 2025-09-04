package programmers2.HighScoreKit.greedy;

/**
 * 탐욕법/구명보트
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42885
 */
import java.util.*;
public class Greedy4 {
	public static void main(String[] args) {
		Greedy4 obj = new Greedy4();
		int[] people = {70, 50, 80, 50};
		System.out.println(obj.solution(people, 100));
	}
	public int solution(int[] people, int limit) {
		int answer = 0;
		int l = 0;
		int r = people.length - 1;
		Arrays.sort(people);
		while (true) {
			if(l > r) break;
			answer++;
			if(l == r) {
				break;
			}
			int heavy = people[r];
			int light = people[l];
			if(heavy + light <= limit) {
				l++;
				r--;
			}
			else r--;
		}
		return answer;
	}
}
/*
- 한 번에 최대 2명 탑승 가능
- 무게 제한 있음

-> 최소한의 보트 개수로 모든 사람을 구출해야 함
 */
