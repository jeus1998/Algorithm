package boj.workbook_8708;

/**
 * 비슷한 단어 - 실버2
 */
import java.io.*;
import java.util.*;
public class BOJ_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        ArrayList<String> list = new ArrayList<>();
        Map<String, int []> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = in.readLine();
            list.add(input);
            int [] temp = new int[26];
            for (int j = 0; j < input.length(); j++) {
                temp[input.charAt(j) - 'A']++;
            }
            map.put(input, temp);
        }
        String first = list.get(0);
        int [] firstArr = map.get(first);
        int firstSize = first.length();
        int answer = 0;
        for (int i = 1; i < n; i++) {
            String second = list.get(i);
            int [] secondArr = map.get(second);
            int secondSize = second.length();
            int size = Math.abs(firstSize - secondSize); // 두 단어 길이 차이
            if(size > 1) continue;
            int cnt = 0;
            for (int j = 0; j < 26; j++) {
                cnt += Math.abs(firstArr[j] - secondArr[j]);
            }
            if(size == 1 && cnt == 1){
                answer++;
                continue;
            }

            if(cnt <= 2) answer++;

        }
        System.out.println(answer);
    }
}
