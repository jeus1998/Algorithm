package boj.workbook_8708;

/**
 * 최소힙 - 실버2
 */
import java.util.*;
import java.io.*;
public class BOJ_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(pq.isEmpty()) sb.append(0);
                else sb.append(pq.poll());

                sb.append("\n");
            }
            else pq.add(input);
        }
        System.out.println(sb);
    }
}
