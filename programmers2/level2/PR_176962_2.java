package programmers2.level2;

/**
 * 과제 진행하기
 */
import java.util.*;
public class PR_176962_2 {
    public static void main(String[] args) {

        String[][] plans1 = {
                {"korean", "11:40", "30"},
                {"english", "12:10", "20"},
                {"math", "12:30", "40"}
        };

        String[][] plans2 = {
                {"science", "12:40", "50"},
                {"music", "12:20", "40"},
                {"history", "14:00", "30"},
                {"computer", "12:30", "100"}
        };

        String[][] plans3 = {
                {"aaa", "12:00", "20"},
                {"bbb", "12:10", "30"},
                {"ccc", "12:40", "10"}
        };

        // {"korean", "english", "math"}
        System.out.println(Arrays.toString(solution(plans1)));
        // {"science", "history", "computer", "music"}
        System.out.println(Arrays.toString(solution(plans2)));
        // {"bbb", "ccc", "aaa"}
        System.out.println(Arrays.toString(solution(plans3)));

    }
    static class Plan{
        public String name; // 과제 이름
        public int start;   // 시작 시간
        public int remain;  // 남은 시간
        public Plan(String name, int start, int remain) {
            this.name = name;
            this.start = start;
            this.remain = remain;
        }
        @Override
        public String toString(){
            return name + " " + start + " " + remain;
        }
    }

    public static String[] solution(String[][] plans) {
        int size = plans.length;
        ArrayList<Plan> planList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            planList.add(new Plan(plans[i][0], convert(plans[i][1]), Integer.parseInt(plans[i][2])));
        }
        Collections.sort(planList, (o1, o2) -> o1.start - o2.start);
        String[] answer = new String[size];
        Stack<Plan> stack = new Stack<>();
        int answerIndex = 0;
        for (int i = 0; i < size - 1; i++) {
            Plan plan = planList.get(i);
            Plan nextPlan = planList.get(i + 1);

            if(plan.start + plan.remain > nextPlan.start){
                stack.push(new Plan(plan.name, plan.start, plan.remain - (nextPlan.start - plan.start)));
                continue;
            }
            answer[answerIndex++] = plan.name;
            int remain = nextPlan.start - (plan.start + plan.remain);
            while (true){
                if(remain == 0 || stack.isEmpty()) break;
                Plan stackPlan = stack.pop();
                if(remain >= stackPlan.remain){
                    remain -= stackPlan.remain;
                    answer[answerIndex++] = stackPlan.name;
                    continue;
                }
                Plan returnPlan = new Plan(stackPlan.name, stackPlan.start, stackPlan.remain - remain);
                stack.push(returnPlan);
                break;
            }
        }
        stack.push(planList.get(size - 1));
        while (!stack.isEmpty()){
            answer[answerIndex++] = stack.pop().name;
        }

        return answer;
    }
    public static int convert(String time){
        String[] split = time.split(":");
        return (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
    }
}
