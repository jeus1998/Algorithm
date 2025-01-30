package boj.workbook_8708;

/**
 * 카드2 - 실버4
 */
import java.util.*;
public class BOJ_2164 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        while (q.size() >= 2){
            q.poll();
            q.add(q.poll());
        }
        System.out.println(q.peek());
    }
}
