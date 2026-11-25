package BarkingDogAgain.YouTube3_Array;

/**
 * 방 번호 [실버4]
 */
import java.util.*;
import java.io.*;
public class BOJ_1475 {
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] memo = new int[10];
		for(int i = 0; i < input.length(); i++) {
			memo[input.charAt(i) - '0']++;
		}
		int temp = ((memo[6] + memo[9])) / 2 + ((memo[6] + memo[9]) % 2 == 0 ? 0 : 1);
		memo[6] = temp; memo[9] = temp;
		int max = 0;
		for(int i = 0; i < 10; i++) {
			max = Math.max(max, memo[i]);
		}
		System.out.println(max);
	}
}
