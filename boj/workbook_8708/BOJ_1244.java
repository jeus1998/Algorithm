package boj.workbook_8708;

/**
 * 스위치 켜고 끄기 - 실버4
 */
import java.io.*;
import java.util.*;
public class BOJ_1244 {
    static int n;
    static int [] memo;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        memo = new int[n + 1];
        st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= n; i++) {
            memo[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(in.readLine());
        while (m --> 0){
            st = new StringTokenizer(in.readLine());
            int sex = Integer.parseInt(st.nextToken()); // 성별
            int num = Integer.parseInt(st.nextToken()); // 스위치 숫자
            if(sex == 1) man(num);
            else woman(num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n / 20; i++) {
            for (int j = 1; j + i * 20 <= n; j++) {
                if(j == 21) break;
                sb.append(memo[i * 20 + j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void man(int num){
        int cnt = 0;
        while (num * ++cnt <= n){
            if(memo[num * cnt] == 0){
                memo[num * cnt] = 1;
            }
            else memo[num * cnt] = 0;
        }
    }
    public static void woman(int num){
        int cnt = 1;
        while (true){
            boolean flag = false;
            if(num - cnt >= 1 && num + cnt <= n){
                if(memo[num - cnt] != memo[num + cnt]){
                    flag = true;
                }
            }
            else flag = true;
            if(flag){
                cnt--;
                break;
            }
            cnt++;
        }
        for (int i = num - cnt; i <= num + cnt; i++) {
            if(memo[i] == 0) memo[i] = 1;
            else memo[i] = 0;
        }
    }
}
