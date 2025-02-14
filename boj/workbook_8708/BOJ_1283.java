package boj.workbook_8708;

/**
 * 단축키 지정 - 실버1
 */
import java.io.*;
import java.util.*;
public class BOJ_1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 옵션의 개수 N
        Set<Character> memo = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String [] split = input.split(" ");
            boolean flag = false;
            // 첫 글자 단축키 지정 확인
            for (int j = 0; j < split.length; j++) {
                char first = split[j].charAt(0);
                char firstLowerCase = Character.toLowerCase(first);
                if(memo.contains(firstLowerCase)) continue;
                memo.add(firstLowerCase);
                StringBuilder temp = new StringBuilder();
                temp.append('[').append(first).append(']');
                temp.append(split[j].substring(1));
                split[j] = temp.toString();
                flag = true;
                break;
            }
            if(flag){
                for (int j = 0; j < split.length; j++) {
                    sb.append(split[j]).append(" ");
                }
                sb.append('\n');
                continue;
            }
            // 왼쪽부터 차례대로 단축키 지정 확인
            for (int j = 0; j < input.length(); j++) {
                char cur = input.charAt(j);
                if(cur == ' ') continue;
                Character curLowerCase = Character.toLowerCase(cur);
                if(memo.contains(curLowerCase)) continue;
                memo.add(curLowerCase);
                StringBuilder temp = new StringBuilder();
                temp.append(input.substring(0, j));
                temp.append('[').append(cur).append(']');
                temp.append(input.substring(j + 1));
                input = temp.toString();
                break;
            }
            sb.append(input).append("\n");
        }
        System.out.println(sb);
    }
}
