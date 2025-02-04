package boj.workbook_8708;

/**
 * KCPC - 실버2
 */
import java.io.*;
import java.util.*;
public class BOJ_3758 {

    static class Team{
        int teamId;
        int score = 0;
        int submitCount = 0;
        int lastSubmit = 0;

        public Team(int teamId) {
            this.teamId = teamId;
        }

        @Override
        public String toString() {
            return teamId + " "  + score + " " + submitCount + " " + lastSubmit;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(t-->0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제의 개수
            int id = Integer.parseInt(st.nextToken()); // 팀 ID
            int m = Integer.parseInt(st.nextToken()); // 로그 엔트리의 개수

            // key: team ID value: <key: 문제 번호 : 최고 점수 >
            Map<Integer, Map<Integer, Integer>> map1 = new HashMap<>();
            // key: team ID value: 제출 횟수
            Map<Integer, Integer> map2 = new HashMap<>();
            // key: team ID value: 마지막 제출 시간
            Map<Integer, Integer> map3 = new HashMap<>();
            int cnt = 0;

            // map1 초기화
            for (int i = 1; i <= n; i++) {
                map1.put(i, new HashMap<>());
                for (int j = 1; j <= k; j++) {
                    map1.get(i).put(j, 0);
                }
            }

            while (m --> 0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 팀 ID
                int b = Integer.parseInt(st.nextToken()); // 문제 번호
                int c = Integer.parseInt(st.nextToken()); // 획득한 점수

                map1.get(a).put(b, Math.max(map1.get(a).get(b), c));
                map2.put(a, map2.getOrDefault(a, 0) + 1);
                map3.put(a, ++cnt);
            }

            Team [] teams = new Team[n];
            for (int i = 0; i < n; i++) {
                teams[i] = new Team(i + 1);
            }

            for (int i = 1; i <= n; i++) {
                Map<Integer, Integer> temp = map1.get(i);
                int score = temp.entrySet().stream().mapToInt(e -> e.getValue()).sum();
                teams[i - 1].score = score;
            }

            map3.entrySet()
                    .stream()
                    .forEach(
                            entry -> teams[entry.getKey() - 1].lastSubmit = entry.getValue());

            map2.entrySet()
                    .stream()
                    .forEach(entry -> teams[entry.getKey() - 1].submitCount = entry.getValue());


            Arrays.sort(teams, (o1, o2) -> {
                if(o1.score != o2.score) return o2.score - o1.score;
                if(o1.submitCount != o2.submitCount) return o1.submitCount - o2.submitCount;
                return o1.lastSubmit - o2.lastSubmit;
            });

            for (int i = 0; i < teams.length; i++) {
                if(teams[i].teamId == id) {
                    sb.append(i + 1);
                    break;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}