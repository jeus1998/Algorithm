package boj.workbook_8708;

/**
 * 크로스 컨트리 - 실버3
 */
import java.io.*;
import java.util.*;
import java.util.stream.*;
public class BOJ_9017 {

    static class Team {
        private int teamId;
        private int score; // 1 ~ 4
        private int last;  // 다섯 번째 주자
        private int count = 1;
        public void addScore(int score){
            if(this.count <= 4) this.score += score;
            if(this.count == 5) this.last = score;
            this.count++;
        }
        public Team(int teamId){
            this.teamId = teamId;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t =  Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t--> 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Map<Integer, Integer> map = new HashMap<>();

            int [] memo = new int[n];
            for (int i = 0; i < n; i++) {
                int cur = Integer.parseInt(st.nextToken());
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                memo[i] = cur;
            }

            Map<Integer, Team> teams = new HashMap<>();
            map.keySet().stream()
                    .filter(k -> map.get(k) >= 6)
                    .forEach(k -> teams.put(k, new Team(k)));

            int score = 1;
            for (int i = 0; i < n; i++) {
                if(!teams.containsKey(memo[i])) {
                    continue;
                }
                teams.get(memo[i]).addScore(score++);
            }

            Team team = teams.values().stream()
                    .sorted((t1, t2) -> {
                        if (t1.score != t2.score) return t1.score - t2.score;
                        return t1.last - t2.last;
                    }).collect(Collectors.toList()).get(0);

            sb.append(team.teamId).append("\n");
        }
        System.out.println(sb);
    }
}