package boj.workbook_8708;

/**
 * 볼 모으기 - 실버1
 */
import java.io.*;
import java.util.*;
public class BOJ_17615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int [] memo = new int [n];
        int blue = 0, red = 0;
        for (int i = 0; i < n; i++) {
            char ball = input.charAt(i);
            if(ball == 'R'){
                red++;
                memo[i] = 1;
            }
            else blue++;
        }

        // blue red
        int blue_cnt = 0, red_cnt = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if(memo[i] == 0){
                blue_cnt++;
                if(blue_cnt == blue) break;
                continue;
            }
            red_cnt++;
            answer++;
        }

        // red blue
        blue_cnt = 0; red_cnt = 0;
        int answer2 = 0;
        for (int i = 0; i < n; i++) {
            if(memo[i] == 1){
                red_cnt++;
                if(red_cnt == red) break;
                continue;
            }
            blue_cnt++;
            answer2++;
        }

        // blue red
        blue_cnt = 0; red_cnt = 0;
        int answer3 = 0;
        for (int i = n - 1; i >= 0; i--) {
            if(memo[i] == 1){
                red_cnt++;
                if(red_cnt == red) break;
                continue;
            }
            blue_cnt++;
            answer3++;
        }

        // red blue
        blue_cnt = 0; red_cnt = 0;
        int answer4 = 0;
        for (int i = n - 1; i >= 0; i--) {
            if(memo[i] == 0){
                blue_cnt++;
                if(blue_cnt == blue) break;
                continue;
            }
            red_cnt++;
            answer4++;
        }

        System.out.println(Math.min(answer4, Math.min(answer3, Math.min(answer2, answer))));
    }
}
/**


 */




