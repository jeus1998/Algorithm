package programmers2.HighScoreKit.hash;

/**
 * 해시/베스트 앨범
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 * LEVEL 3
 * 프로그래머스 JDK 14 -> toList() 사용 불가능;;
 */
import java.util.*;
import java.util.stream.*;
public class Hash5 {
	public int[] solution(String[] genres, int[] plays) {
		// 장르별 재생 횟수
		Map<String, Integer> prefixSum = new HashMap<>();
		// 장르별 고유 번호, 재생 횟수
		Map<String, List<int[]>> map = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			if(!map.containsKey(genres[i])) {
				map.put(genres[i], new ArrayList<>());
			}
			map.get(genres[i]).add(new int[] {i, plays[i]});
			prefixSum.put(genres[i], prefixSum.getOrDefault(genres[i], 0) + plays[i]);
		}

		List<Integer> result = new ArrayList<>();
		
		// 장르 2개 뽑기
		List<Map.Entry<String, Integer>> mapEntry = prefixSum.entrySet().stream().sorted((o1, o2)
			-> o2.getValue() - o1.getValue()).collect(Collectors.toList());

		for (Map.Entry<String, Integer> entry : mapEntry) {
			String key = entry.getKey();
			List<int[]> collect = map.get(key).stream().sorted((o1, o2) -> {
				// 재생 횟수 내림차순
				if (o1[1] != o2[1]) return o2[1] - o1[1];
				// 고유 번호 오름차순
				return o1[0] - o2[0];
			}).collect(Collectors.toList());
			// 최대 2개
			for (int i = 0; i < Math.min(collect.size(), 2) ; i++) {
				result.add(collect.get(i)[0]);
			}
		}

		int [] answer = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		return answer;
	}
}
/*
장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시

1. 속한 노래가 가장 많이 재생된 장르를 먼저 수록
2. 장르 내에서 많이 재생된 노래를 먼저 수록
3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록

genres[i] : i번째 노래의 장르
plays[i] : i번째 노래의 재생 횟수

genres.length == plays.length & 1 ≤ genres.length ≤ 10,000
장르 종류 100개 미만
장르에 속한 곡이 하나라면, 하나의 곡만 선택
모든 장르는 재생된 횟수가 다르다.

실수했던 부분
- 모든 장르에 대해서 최대 노래 2곡씩 선택하는 것인데
- 상위 장르 2개만 선택하는 것으로 착각함
 */