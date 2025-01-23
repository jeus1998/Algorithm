package boj.workbook_8708;

/**
 * 집합 - 실버5
 */
import java.util.*;
import java.io.*;
public class BOJ_11723 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] memo = new int [21]; // 1 ~ 20 집합
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n --> 0){
            String [] split = br.readLine().split(" ");
            switch (split[0]){
                case "add": {
                    int num = Integer.parseInt(split[1]);
                    memo[num] = 1;
                    break;
                }
                case "remove": {
                    int num = Integer.parseInt(split[1]);
                    memo[num] = 0;
                    break;
                }
                case "check": {
                    int num = Integer.parseInt(split[1]);
                    if(memo[num] == 1) sb.append(1);
                    else sb.append(0);
                    sb.append("\n");
                    break;
                }
                case "toggle": {
                    int num = Integer.parseInt(split[1]);
                    if(memo[num] == 0) memo[num] = 1;
                    else memo[num] = 0;
                    break;
                }
                case "all": {
                    Arrays.fill(memo, 1);
                    break;
                }
                case "empty": {
                    Arrays.fill(memo, 0);
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}