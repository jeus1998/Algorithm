package boj.workbook_8708;

/**
 * 에디터 - 실버2
 */
import java.io.*;
import java.util.*;
public class BOJ_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Deque<Character> front = new ArrayDeque<>();
        Deque<Character> back = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            front.addLast(str.charAt(i));
        }

        int m = Integer.parseInt(br.readLine()); // 1 <= m <= 500,000
        while (m --> 0){
            String [] input = br.readLine().split(" ");
            switch (input[0]){
                case "L": {
                    if(!front.isEmpty()){
                        back.addFirst(front.pollLast());
                    }
                    break;
                }
                case "D": {
                    if(!back.isEmpty()){
                        front.addLast(back.pollFirst());
                    }
                    break;
                }
                case "B":{
                    if(!front.isEmpty()){
                        front.pollLast();
                    }
                    break;
                }
                default: {
                    front.addLast(input[1].charAt(0));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = front.size();
        for (int i = 0; i < size; i++) {
            sb.append(front.pollFirst());
        }
        size = back.size();
        for (int i = 0; i < size; i++) {
            sb.append(back.pollFirst());
        }
        System.out.println(sb);
    }
}
/**

 ABC
 커서 위치 -> .A.B.C.

 명령어
 L: 커서를 왼쪽으로 한 칸 맨 앞이면 무시
 D: 커서를 오른쪽으로 맨 뒤이면 무시
 B: 커서 왼쪽에 있는 문자를 삭제 맨 앞이면 무시
 P $: $라는 문자를 커서 왼쪽에 추가

 커서 시작 맨 뒤에 위치

 Deque<String> front
 Deque<String> back
 */