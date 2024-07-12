package programmers2.level2;

/**
 * 이모티콘 할인 행사
 */
import java.util.*;
public class PR_150368 {
    static int n;           // 이모티콘 개수
    static int [] memo;     // 백트래킹 기록용
    static int [][] user;   // 유저
    static int [] emoticon; // 이모티콘
    static int answer1 = 0; // 최대 가입자
    static int answer2 = 0; // 최대 판매액
    public int[] solution(int[][] users, int[] emoticons) {
       n = emoticons.length;
       memo = new int [n];
       user = new int [users.length][2];
       for(int i = 0; i < users.length; i++){
           user[i][0] = users[i][0];
           user[i][1] = users[i][1];
       }
       emoticon = Arrays.copyOf(emoticons, n);

       backtracking(0);

       return new int[]{answer1, answer2};
   }
   public static void backtracking(int depth){
       if(depth == n){
           calculate();
           return;
       }
       // 할인율 10 ~ 40퍼
       for(int i = 10; i <= 40; i += 10){
           memo[depth] = i;
           backtracking(depth + 1);
       }
   }
   public static void calculate(){

       int [] price = new int [n]; // 각 이모티콘 할인된 가격
       for(int i = 0; i < n; i++){
           price[i] = emoticon[i] * (100 - memo[i]) / 100;
       }

       int cnt1 = 0; // 이모티콘 플러스 서비스 가입자 숫자
       int cnt2 = 0; // 이모티콘 플러스 가입자x 이모티콘 누적 금액

       for(int i = 0; i < user.length; i++){
           int sum = 0; // 사용자 이모티콘 구매 누적 금액
           boolean flag = false; // 이모티콘 플러스 가입 체크
           for(int j = 0; j < n; j++){
               if(memo[j] >= user[i][0]){
                   sum += price[j];
               }

               if(sum >= user[i][1]){
                   flag = true;
                   break;
               }
           }
           if(flag){
               cnt1++;     // 이모티콘 플러스 가입자 추가
           }
           else{
               cnt2 += sum; // 이모티콘 판매액
           }
       }

       if(answer1 > cnt1) return; // 서비스 가입자가 적으면 return

       if(answer1 < cnt1){  // 서비스 가입자가 더 크면 갱신
           answer1 = cnt1;
           answer2 = cnt2;
       }
       else if(answer2 < cnt2){ // 서비스 가입자는 같은데 판매액이 더 크면 갱신
           answer2 = cnt2;
       }
   }
}
