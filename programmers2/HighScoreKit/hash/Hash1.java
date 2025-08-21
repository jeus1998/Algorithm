package programmers2.HighScoreKit.hash;

/**
 * 해시/완주하지 못한선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 * LEVEL 1
 * 제한 사항
 * - 마라톤에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * - completion의 길이는 participant의 길이보다 1 작습니다.
 * - participant와 completion의 원소는 알파벳 소문자로만 이루어져 있습니다.
 * - 참가자 중에는 동명이인이 있을 수 있습니다.
 */
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Hash1 {

	public String solution1(String[] participant, String[] completion) {

		Map<String, Long> map1 = Arrays.stream(completion).collect(Collectors.groupingBy(
			Function.identity(), Collectors.counting()
		));
		Map<String, Long> map2 = Arrays.stream(participant).collect(Collectors.groupingBy(
			Function.identity(), Collectors.counting()
		));

		for (String k : map1.keySet()) {
			if (map1.get(k).compareTo(map2.getOrDefault(k, -1L)) != 0) {
				return k;
			}
		}
		return null;
	}

	public String solution2(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<>();
		Arrays.stream(completion).forEach(k -> map.put(k, map.getOrDefault(k, 0) + 1));
		Arrays.stream(participant).forEach(k -> map.put(k, map.getOrDefault(k, 0) + 1));
		for(String key : map.keySet()){
			if(map.get(key) % 2 == 0) continue;
			return key;
		}
		return "never happen";
	}
}
