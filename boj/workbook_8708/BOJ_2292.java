package boj.workbook_8708;

/**
 * 벌집 - 브론즈 2
 */
import java.util.*;
public class BOJ_2292 {
    final static int LIMIT = 1000000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num == 1){
            System.out.println(1);
            return;
        }
        int [] dp = new int [18259];
        dp[1] = 1;
        for (int i = 2; i < 18259; i++) {
            dp[i] = dp[i-1] + 6 * (i-1);
            if(dp[i] >= num || dp[i] >= LIMIT){
                System.out.println(i);
                break;
            }
        }
    }
}