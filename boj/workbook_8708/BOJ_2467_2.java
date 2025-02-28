package boj.workbook_8708;

/**
 * 용액 - 골드5
 * 투포인터 풀이
 */
import java.io.*;
import java.util.*;
public class BOJ_2467_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end   = n - 1;
        int min = 2000000001;
        int [] answer = new int[n];
        while (start < end){
            int result = input[start] + input[end];
            int gap = Math.abs(result);
            if(gap == 0){
                System.out.println(input[start] + " " + input[end]);
                return;
            }
            if(min > gap){
                min = gap;
                answer[0] = input[start];
                answer[1] = input[end];
            }
            if(result < 0){
                start++;
                continue;
            }
            end--;
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
