package boj.workbook_8708;

/**
 *  어두운 굴다리 - 실버4
 */
import java.util.*;
import java.io.*;
public class BOJ_17266 {
    static int n;
    static int m;
    static int [] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine()); // 굴다리의 길이 N
        m = Integer.parseInt(in.readLine()); // 가로등의 개수 M
        memo = new int[m]; // 가로등의 위치
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; i++) {
            memo[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        max = Math.max(memo[0], max);
        max = Math.max(n - memo[m - 1], max);

        if(m >= 2){
            for (int i = 1; i < m; i++) {
                max = Math.max((memo[i] - memo[i - 1]) / 2 + ((memo[i] - memo[i-1]) % 2 == 0 ? 0 : 1), max);
            }
        }
        System.out.println(max);
    }
}
/*

0 1 2 3 4 5 6 7 8 9 10
    l           l




 */