package boj.DataStructure1;

/**
 * 좋은 단어
 * 실버4
 */
import java.io.*;
import java.util.*;
public class BOJ3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int t = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (t-->0){
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                char cur = input.charAt(i);
                if(!stack.isEmpty() && stack.peek() == cur){
                    stack.pop();
                }
                else stack.push(cur);
            }
            if(stack.isEmpty()) cnt++;
            stack.clear();
        }
        System.out.println(cnt);
    }
}
