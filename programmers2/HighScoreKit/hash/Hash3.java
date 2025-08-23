package programmers2.HighScoreKit.hash;

/*
 * 해시/전화번호 목록
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 * LEVEL 2
 * 제한 사항
 * - phone_book의 길이는 1 이상 1,000,000 이하입니다.
 * - 각 전화번호의 길이는 1 이상 20 이하입니다.
 * - 같은 전화번호가 중복해서 들어있지 않습니다.
 */
import java.util.*;
public class Hash3 {
	// 95.8 -> 효율성 1개 실패
	public boolean solution1(String[] phone_book) {
		HashSet<String> set = new HashSet<>();
		for (String phone : phone_book) {
			for (int i = 1; i < phone.length(); i++) {
				set.add(phone.substring(0, i));
			}
		}
		for (String phone : phone_book) {
			if (set.contains(phone)) {
				return false;
			}
		}
		return true;
	}

	// 100.0 -> 통과
	public boolean solution2(String[] phone_book) {
		// Olog(n)
		Arrays.sort(phone_book);
		// O(n)
		for (int i = 0; i < phone_book.length - 1; i++) {
			// O(m) m = phone_book[i] 길이
			if (phone_book[i + 1].startsWith(phone_book[i])) {
				return false;
			}
		}
		return true;
	}

	public boolean solution3(String[] phone_book) {
		HashSet<String> set = new HashSet<>();
		// O(n)
		for (String phone : phone_book) {
			set.add(phone);
		}
		for(String phone : phone_book) {
			for(int i = 1; i < phone.length(); i++) {
				if(set.contains(phone.substring(0, i))) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * substring(begin, end)
	 * begin: 시작 인덱스(포함)
	 * end: 종료 인덱스(포함하지 않음)
	 * 예: "12345".substring(0, 2) -> "12"
	 */
}
