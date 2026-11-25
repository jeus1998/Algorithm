package BarkingDogAgain.YouTube3_Array;

/**
 * 숫자의 개수 [브론즈2]
 */
import java.util.*;
import java.io.*;
public class BOJ_2577 {
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		String result = Integer.toString(A * B * C);
		int [] memo = new int [10];
		for(int i = 0; i < result.length(); i++) {
			memo[result.charAt(i) - '0']++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 10; i++) {
			sb.append(memo[i]).append("\n");
		}
		System.out.println(sb);
	}
}
