package boj.workbook_8708;

/**
 * 빗물 - 골드5
 */
import java.io.*;
import java.util.*;
public class BOJ_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken()); // 세로의 길이
        int w = Integer.parseInt(st.nextToken()); // 가로의 길이
        int [] memo = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            memo[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 1; i <= h; i++) {
            int left = -1;
            for (int j = 0; j < w; j++) {
                if(memo[j] >= i) {
                    if(left == -1) left = j;
                    else{
                        answer += j - left - 1;
                        left = j;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
/*

 */