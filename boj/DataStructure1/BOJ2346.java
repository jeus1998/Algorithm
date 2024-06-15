package boj.DataStructure1;

/**
 * 풍선 터트리기
 * 실버3
 * ArrayDeque -> 통과 LinkedList 통과 x
 */
import java.util.*;
import java.io.*;
public class BOJ2346 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<int []> list = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(cur > 0) cur--;
            list.add(new int[]{i, cur});
        }

        StringBuilder sb = new StringBuilder();
        int move = 0;

        int[] temp = list.pollFirst();
        sb.append(temp[0]).append(" ");
        move = temp[1];

        while (!list.isEmpty()){

            while (move != 0){
                if(move > 0){
                    list.addLast(list.pollFirst());
                    move--;
                }
                else{
                    list.addFirst(list.pollLast());
                    move++;
                }
            }
            int [] cur = list.pollFirst();
            sb.append(cur[0]).append(" ");
            move = cur[1];
        }
        System.out.println(sb);
    }
}
