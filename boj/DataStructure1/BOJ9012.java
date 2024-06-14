package boj.DataStructure1;

/**
 * 괄호
 * 실버4
 */
import java.util.*;
import java.io.*;
public class BOJ9012 {
    public static final String NO = "NO";
    public static final String YES = "YES";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        while (t-->0){
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                char cur = input.charAt(i);
                if(stack.isEmpty()) stack.push(cur);
                else{
                    if(stack.peek() == '(' && cur == ')') stack.pop();
                    else stack.push(cur);
                }
            }
            if(stack.isEmpty()) sb.append(YES);
            else sb.append(NO);

            stack.clear();
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
