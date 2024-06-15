package boj.DataStructure1;

/**
 * 큐2
 * 실버4
 */
import java.util.*;
import java.io.*;
public class BOJ18258 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (n-->0){
            st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            if(com.equals("push")){
                dq.addLast(Integer.parseInt(st.nextToken()));
            }
            else if(com.equals("pop")){
                if(dq.isEmpty()) sb.append("-1");
                else sb.append(dq.pollFirst());
                sb.append("\n");
            }
            else if(com.equals("front")){
                if(dq.isEmpty()) sb.append("-1");
                else sb.append(dq.peekFirst());
                sb.append("\n");
            }
            else if(com.equals("back")){
                if(dq.isEmpty())  sb.append("-1");
                else sb.append(dq.peekLast());
                sb.append("\n");
            }
            else if(com.equals("size")){
                sb.append(dq.size()).append("\n");
            }
            else if(com.equals("empty")){
                if(dq.isEmpty()) sb.append("1");
                else sb.append("0");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
