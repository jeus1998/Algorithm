package programmers2.HighScoreKit.hash;

import java.util.*;

/**
 * 해시/의상
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 * LEVEL 2
 * 제한 사항
 * - clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 * - 의상의 수는 1개 이상 30개 이하입니다.
 * - 같은 이름을 가진 의상은 존재하지 않습니다.
 * - clothes의 원소는 문자열로 이루어져 있습니다.
 * - 모든 문자열의 길이는 1 이상 20 이하인 자연수이고, 알파벳 소문자 또는 '_'로만 이루어져 있습니다.
 */
public class Hash4 {
	public int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<>();
		for (String[] cloth : clothes) {
			map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
		}
		int answer = map.values()
			.stream()
			.reduce(1, (a, b) -> a * (b + 1));

		return answer - 1;
	}
}
/*
reduce API
- 스트림의 각 요소를 누적하여 하나의 결과를 만드는 연산
- 초기값과 누적 함수(람다식)를 인자로 받음
- reduce(1, (a, b) -> a * (b + 1))
  - 초기값 1로 시작
  - 스트림의 각 요소 b에 대해 누적값 a에 (b + 1)을 곱함
  - 최종적으로 모든 요소를 처리한 후의 누적값을 반환
 */
