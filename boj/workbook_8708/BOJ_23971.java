package boj.workbook_8708;

/**
 * ZOAC 4 - 브론즈3
 * 수학 - 사칙연산
 */
import java.util.*;
import java.io.*;
public class BOJ_23971 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken()) + 1;
        System.out.println(((h / n) + (h % n == 0 ? 0 : 1)) * (( (w / m) + (w % m == 0 ? 0 : 1))));
    }
}
