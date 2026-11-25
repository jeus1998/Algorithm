package BarkingDogAgain.YouTube3_Array;

/**
 * 두 수의 합 [실버3]
 */
import java.io.*;
import java.util.*;
public class BOJ_3273 {
	static final int INF = 1000001;
	public static void main(String[] args) throws  IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());
		var elements = new boolean[INF];
		var record = new int [n];
		var inputTokens = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			var cur = Integer.parseInt(inputTokens.nextToken());
			elements[cur] = true;
			record[i] = cur;
		}
		var x = Integer.parseInt(br.readLine());
		var answer = 0;
		for(int i = 0; i < n; i++) {
			if(x - record[i] <= 0 || x - record[i] >= INF) continue;
			if(elements[x - record[i]]) answer++;
		}
		System.out.println(answer / 2);
	}
}