package boj.workbook_8708;

/**
 * 숨바꼭질 - 실버1
 */
import java.io.*;
import java.util.*;
public class BOJ_1697 {
    static int n, k;
    static final int LIMIT = 200001;
    static int [] min;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 수빈이
        k = Integer.parseInt(st.nextToken()); // 동생
        min = new int[LIMIT];
        Arrays.fill(min, LIMIT);
        q = new LinkedList<>();
        min[n] = 0;
        q.add(n);
        while (!q.isEmpty()){
            int cur = q.poll();
            next(cur + 1, cur);
            next(cur - 1, cur);
            next(cur * 2, cur);
        }
        System.out.println(min[k]);
    }
    public static void next(int nx, int cur){
        if(validation(nx) && min[cur] + 1 < min[nx]){
            min[nx] = min[cur] + 1;
            q.add(nx);
        }
    }
    public static boolean validation(int nx){
        if(0 <= nx && nx < LIMIT) return true;
        return false;
    }
}
