package boj.greedy;

import java.util.*;
import java.io.*;

/**
 * 백준: 25947 실버1 선물할인
 */
public class BJ25947 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 선물의 개수
        int b = Integer.parseInt(input[1]); // 초기 예산
        int a = Integer.parseInt(input[2]); // 할인 받을 수 있는 최대 선물 개수
        int A = a;

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        // 2,4,6,8,10,12
        int cur   = 0;
        while (cur < n){
            if(a > 0){
                b -= (list.get(cur) / 2);
                a--;
            }
            else{
                if(A == 0){
                    b -= list.get(cur);
                }
                else{
                    b -= list.get(cur - A) / 2;
                    b -= (list.get(cur) / 2);
                }
            }
            if(b < 0) break;
            cur++;
        }
        System.out.println(cur);
    }
}
