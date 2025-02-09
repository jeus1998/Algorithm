package boj.workbook_8708;

/**
 * 창고 다각형 - 실버2
 */
import java.util.*;
import java.io.*;
public class BOJ_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 기둥의 개수 n
        int [] height = new int[1001];

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int max_height = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()); // 위치 -> 기둥 왼쪽
            int h = Integer.parseInt(st.nextToken()); // 높이
            height[l] = h;
            start = Math.min(start, l);
            end = Math.max(end, l);
            max_height = Math.max(max_height, h);
        }

        // left -> max
        int max_l = 0;
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = start; i <= end; i++) {
            if (height[i] == max_height) {
                max_l = i;
                break;
            }
            if(stack.isEmpty()){
                stack.push(height[i]);
            }
            if(stack.peek() < height[i]){
                stack.push(height[i]);
            }
            answer += stack.peek();
        }
        stack.clear();
        // right -> max
        for (int i = end; i >= max_l; i--) {
            if(stack.isEmpty()){
                stack.push(height[i]);
            }
            if(stack.peek() < height[i]){
                stack.push(height[i]);
            }
            answer += stack.peek();
        }
        System.out.println(answer);
    }
}