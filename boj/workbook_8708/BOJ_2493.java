package boj.workbook_8708;

/**
 * 탑 - 골드5
 */
import java.io.*;
import java.util.*;
public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 탑의 개수
        int [] top = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }
        int [] answer = new int[n];
        Stack<int []> stack = new Stack<>();
        stack.push(new int [] {top[n-1], n-1});
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && top[i] >= stack.peek()[0]) {
                int [] cur = stack.pop();
                answer[cur[1]] = i + 1;
            }
            stack.push(new int [] {top[i], i});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
