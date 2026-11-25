package BarkingDogAgain.YouTube3_Array;

/**
 * 알파벳 소문자로만 이루어진 단어 S가 주어진다.
 * 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.
 */
import java.io.*;
import java.util.*;
public class BOJ_10808 {
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var bw = new BufferedWriter(new OutputStreamWriter(System.out));
		var S = br.readLine();
		int [] memo = new int [26];
		for	(int i = 0; i < S.length(); i++) {
			memo[S.charAt(i) - 'a']++;
		}
		var sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			sb.append(memo[i]).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
