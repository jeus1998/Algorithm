package boj.BarkingDog_Collection.MST;

/**
 * 행성 터널 플레티넘5
 * MST
 * Time: 10:40AM~ 11:33AM
 */
import java.util.*;
import java.io.*;
public class BOJ2887 {
    static int [] parent;
    static PriorityQueue<int[]> pq;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> list = new ArrayList<>();

        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list.add(new int[]{i, x, y, z});
        }

        // o[0] = 시작 정점 o[1] = 도착 정점 o[2] = 두 정점 사이의 간격
        pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        // x를 기준으로 오름차순 정렬
        Collections.sort(list, Comparator.comparingInt(o -> o[1]));
        calculate(list, 1);

        // y를 기준으로 오름차순 정렬
        Collections.sort(list, Comparator.comparingInt(o -> o[2]));
        calculate(list, 2);

        // z를 기준으로 오름차순 정렬
        Collections.sort(list, Comparator.comparingInt(o -> o[3]));
        calculate(list, 3);

        int cnt = 0;
        long cost = 0;
        while (!pq.isEmpty() && cnt < n - 1){
            int [] temp = pq.poll();
            if(find(temp[0]) == find(temp[1])) continue;
            cnt++;
            cost += temp[2];
            union(temp[0], temp[1]);
        }
        System.out.println(cost);
    }
    public static void calculate(ArrayList<int[]> list, int num){
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            int min = Math.abs(list.get(i)[num] - list.get(i+1)[num]);
            pq.add(new int[]{list.get(i)[0], list.get(i+1)[0], min});
        }
    }
    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x > y) parent[x] = y;
        else parent[y] = x;
    }
}
