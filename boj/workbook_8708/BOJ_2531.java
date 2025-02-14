package boj.workbook_8708;

/**
 * 회전 초밥 - 실버1
 */
import java.io.*;
import java.util.*;
public class BOJ_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 접시의 수 n
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수 d
        int k = Integer.parseInt(st.nextToken()); // 연속 접시의 수 k
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 c
        int [] memo = new int[n * 2];
        for (int i = 0; i < n; i++) {
            memo[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n; i < n * 2; i++) {
            memo[i] = memo[i - n];
        }
        int [] arr = new int[d + 1];
        int answer = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            arr[memo[i]]++;
            if(arr[memo[i]] == 1) count++;
        }

        if(arr[c] == 0){
            answer = count + 1;
        }
        else answer = count;

        for (int i = k; i < 2 * n; i++) {
            arr[memo[i - k]]--;
            if(arr[memo[i - k]] == 0) count--;

            arr[memo[i]]++;
            if(arr[memo[i]] == 1) count++;

            if(arr[c] == 0){
                answer = Math.max(answer, count + 1);
            }
            else answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
/**



 */