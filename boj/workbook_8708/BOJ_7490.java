package boj.workbook_8708;

/**
 * 0 만들기 - 골드5
 */
import java.io.*;
import java.util.*;
public class BOJ_7490 {
    static int [] memo;
    static int end;
    static ArrayList<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        int [] input = new int[t];
        for (int i = 0; i < t; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < t; i++) {
            int target = input[i];
            end = target - 1;
            memo = new int[end];
            func(0);
            Collections.sort(list);
            for (String s : list) {
                sb.append(s).append("\n");
            }
            sb.append("\n");
            list.clear();
        }
        System.out.println(sb);
    }
    public static void func(int cur){
        if(cur == end){
            calculate();
            return;
        }
        for (int i = 0; i < 3; i++) {
            memo[cur] = i;
            func(cur+1);
        }
    }
    public static void calculate(){
        Deque<Integer> dq = new LinkedList<>();
        dq.addLast(1);
        int idx = 2;
        for (int i = 0; i < end; i++) {
            if(memo[i] == 0 || memo[i] == 1){
                dq.addLast(idx++);
                continue;
            }
            int last = dq.pollLast();
            int result = Integer.parseInt(String.valueOf(last) + String.valueOf(idx++));
            dq.addLast(result);
        }
        for (int i = 0; i < end; i++) {
            if(memo[i] == 2) continue;
            int first = dq.pollFirst();
            int second = dq.pollFirst();
            if(memo[i] == 0){
                dq.addFirst(first + second);
                continue;
            }
            dq.addFirst(first - second);
        }
        if(dq.peek() == 0) make();
    }
    public static void make(){
        StringBuilder temp = new StringBuilder();
        temp.append(1);
        int idx = 2;
        for (int i = 0; i < end; i++) {
            if(memo[i] == 0){
                temp.append("+");
            }
            else if(memo[i] == 1){
                temp.append("-");
            }
            else{
                temp.append(" ");
            }
            temp.append(idx++);
        }
        list.add(temp.toString());
    }

}
