package boj.workbook_8708;

/**
 * 문자열 게임 2 -
 */
import java.io.*;
public class BOJ_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        StringBuilder sb = new StringBuilder();
        while(t-->0) {
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if(k == 1){
                sb.append(1).append(" ").append(1).append("\n");
                continue;
            }

            char[] chars = s.toCharArray();
            int size = chars.length;
            int [] memo = new int[size];
            for (int i = 0; i < size; i++) {
                memo[i] = chars[i] - 'a';
            }
            int min = Integer.MAX_VALUE;

            // 3번 구하기
            for (int i = 0; i < 26; i++) {
                int start = 0;
                int count = 0;
                for (int j = 0; j < size; j++) {
                    if(memo[j] == i) count++;
                    if(count == k){
                        while (true){
                            if(memo[start] == i){
                                min = Math.min(min, j - start + 1);
                                break;
                            }
                            start++;
                        }
                        start++;
                        count--;
                    }
                }
            }
            if(min == Integer.MAX_VALUE){
                sb.append(-1).append("\n");
                continue;
            }

            // 4번 구하기
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 26; i++) {
                int start = -1;
                int count = 0;
                for (int j = 0; j < size; j++) {
                    if(memo[j] == i){
                        count++;
                        if(start == -1) start = j;
                    }
                    if(count == k){
                        max = Math.max(max, j - start + 1);
                        count--;
                        start++;
                        while (true){
                            if(memo[start] == i){
                                break;
                            }
                            start++;
                        }
                    }
                }
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
