package boj.DataStructure1;

/**
 * 카드 놓기
 * 실버3
 */
import java.util.*;
import java.io.*;
public class BOJ18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder(br.readLine());
        sb.reverse();
        StringTokenizer st = new StringTokenizer(sb.toString());

        Deque<Integer> dq = new LinkedList<>();

        int cnt = 1;
        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(st.nextToken());
            switch (s){
                case 1: {
                    dq.addFirst(cnt);
                    break;
                }
                case 2:{
                    int out = dq.pollFirst();
                    dq.addFirst(cnt);
                    dq.addFirst(out);
                    break;
                }
                default:{
                    dq.addLast(cnt);
                }
            }
            cnt++;
        }
        sb = new StringBuilder();
        while (!dq.isEmpty()){
            sb.append(dq.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }
}
/*
1: 제일 위의 카드를 1장
2: 위에서 2번째 (카드가 2장 이상일 때)
3: 제일 밑에 카드를 바닥에

결과는 항상 위에서부터 1,2,3,4,5 순서대로

2 3 3 2 1
5 4 3 2 1

1 2 3 3 2
1 2 3 4 5

1 5 2 3 4
 */