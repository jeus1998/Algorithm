package boj.DataStructure1;

/**
 * 프린터 큐
 * 실버3
 */
import java.io.*;
import java.util.*;
public class BOJ1966 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();

        StringTokenizer st;

        while (t-->0){
            int cnt = 0;
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken()); // 문서의 개수
            int idx = Integer.parseInt(st.nextToken()); // 궁금한 문서 idx

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < num; i++) {
                int cur = Integer.parseInt(st.nextToken());
                if(idx == i){
                    q.add(new int[]{cur, 0}); // 찾고자 하는 문서 = 0
                }
                else q.add(new int[]{cur, 1});  // 다른 문서 = 1
                pq.add(cur);
            }

            while (!q.isEmpty()){
                int [] cur = q.poll();
                if(cur[0] == pq.peek()){
                    cnt++;
                    pq.poll();
                    if(cur[1] == 0){
                        break;
                    }
                }
                else q.add(cur);
            }

            pq.clear();
            q.clear();

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
