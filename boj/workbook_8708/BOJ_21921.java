package boj.workbook_8708;

/**
 * 블로그 - 실버3
 */
import java.io.*;
import java.util.*;
public class BOJ_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int max = 0;
        int count = 0;
        int cnt = 0;
        int sum = 0;
        st = new StringTokenizer(in.readLine());
        int [] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = Integer.parseInt(st.nextToken());
            cnt++;
            sum += memo[i];
            if(cnt < x) continue;
            if(cnt == x){
                max = sum;
                count = 1;
                continue;
            }
            cnt--;
            sum -= memo[i - x];
            if(max == sum){
                count++;
            }
            else if(max < sum){
                max = sum;
                count = 1;
            }
        }
        if(max == 0){
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(count);
    }
}
