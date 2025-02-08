package boj.workbook_8708;

/**
 * 랭킹전 대기열 - 실버2
 */
import java.io.*;
import java.util.*;
public class BOJ_20006 {
    private final static String START = "Started!";
    private final static String WAIT  = "Waiting!";
    static class Room {
        int min = 0;
        int max = 0;
        HashMap<String, Integer> member = new HashMap<>();

        public Room(String name, int level) {
            min = level - 10;
            max = level + 10;
            member.put(name, level);
        }
        public void addMember(String name, int level){
            member.put(name, level);
        }
        public int getMemberCount(){
            return member.size();
        }
        public int getMin() {
            return min;
        }
        public int getMax() {
            return max;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()); // 플레이어의 수 p
        int m = Integer.parseInt(st.nextToken()); // 방의 정원 m

        ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            boolean flag = true;
            for (Room room : rooms) {
                if(room.getMemberCount() == m) continue; // 풀방
                if(room.getMin() <= level &&  level <= room.getMax()) {
                    flag = false;
                    room.addMember(name, level);
                    break;
                }
            }
            if(flag) {
                Room room = new Room(name, level);
                rooms.add(room);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            if(room.getMemberCount() == m) {
                sb.append(START);
            }
            else sb.append(WAIT);
            sb.append("\n");

            room.member.entrySet().stream()
                    .sorted((o1, o2) ->{
                        return o1.getKey().compareTo(o2.getKey());
                    }).forEach(entry -> {
                        sb.append(entry.getValue()).append(" ");
                        sb.append(entry.getKey());
                        sb.append("\n");
                    });
        }
        System.out.println(sb);
    }
}
