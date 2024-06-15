package boj.DataStructure1;

/**
 * 회전하는 큐
 * 실버3
 */
import java.io.*;
import java.util.*;
public class BOJ1021 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 큐의 크기
        int m = Integer.parseInt(st.nextToken()); // 뽑고자 하는 수의 개수

        Queue<Integer> target = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            target.add(Integer.parseInt(st.nextToken()));
        }

        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dq.addLast(i);
        }

        int cnt = 0;
        while (!target.isEmpty()){
            int cur = target.poll();

            if(dq.peekFirst() == cur){
                dq.pollFirst();
            }
            else{
                int idx = dq.indexOf(Integer.valueOf(cur));
                int left_length = idx;
                int right_length = dq.size() - idx;

                if(left_length <= right_length){
                    while (dq.peekFirst()!= cur){
                        dq.addLast(dq.pollFirst());
                        cnt++;
                    }
                }
                else{
                    while (dq.peekFirst()!= cur){
                        dq.addFirst(dq.pollLast());
                        cnt++;
                    }
                }
                dq.pollFirst();
            }
        }
        System.out.println(cnt);
    }
}
/*
10 3
2 9 5 -> 8

1 2 3 4 5 6 7 8 9 10

2 3 4 5 6 7 8 9 10 1  cnt = 1

3 4 5 6 7 8 9 10 1    out: 2

1 3 4 5 6 7 8 9 10    cnt = 2

10 1 3 4 5 6 7 8 9    cnt = 3

9 10 1  3 4 5 6 7 8  cnt = 4

10 1 3 4 5 6 7 8  out: 9

cnt = 8
 */