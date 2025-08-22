package programmers2.HighScoreKit.hash;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 해시/폰켓몬
 * https://programmers.co.kr/learn/courses/30/lessons/1845
 * LEVEL 1
 * 제한 사항
 * - nums의 길이는 1 이상 10,000 이하입니다.
 * - nums의 원소는 1 이상 200,000 이하인 자연수입니다.
 * - 가장 많은 종류의 폰켓몬을 선택한하는 방법이 여러 가지인 경우에도, 선택할 수 있는
 * 폰켓몬 종류 개수의 최댓값 하나만 return합니다.
 */
public class Hash2 {
	public int solution1(int[] nums) {
		int answer = nums.length / 2;
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		return Math.min(set.size(), answer);
	}

	public int solution2(int[] nums) {
		long count = Arrays.stream(nums).distinct().count();
		return Math.min((int) count, nums.length / 2);
	}
}
