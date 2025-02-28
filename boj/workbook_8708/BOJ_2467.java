package boj.workbook_8708;

/**
 * 용액 - 골드5
 * 이분탐색 풀이
 */
import java.io.*;
import java.util.*;
public class BOJ_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //  2 <= n <= 100,000
        int [] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int min = 2000000001;
        int [] answer = new int[2];
        for (int i = 0; i < n; i++) {
            int target = input[i];
            int start = 0;
            int end   = n - 1;
            while (start <= end){
                int mid = (start+end) / 2;
                int result = target + input[mid];
                if(result == 0){
                    if(i < mid){
                        System.out.println(target + " " + input[mid]);
                        return;
                    }
                    System.out.println(input[mid] + " " + target);
                    return;
                }
                if(result < 0){
                    start = mid + 1;
                }
                else end = mid - 1;
                if(i == mid) continue;
                int gap = Math.abs(result);
                if(min > gap){
                    min = gap;
                    answer[0] = target;
                    answer[1] = input[mid];
                }
            }
        }
        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1]);
    }
}
/*
산성 용액 1 ~ 10억
알칼리 용액 -10억 ~ -1

산성 용액과 알칼리성 용액의 특성값이 정렬된 순서로 주어졌을 때,
이 중 두 개의 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액을 찾는 프로그램을 작성
 */