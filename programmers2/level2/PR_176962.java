package programmers2.level2;

/**
 * 과제 진행하기
 */
import java.util.*;
public class PR_176962 {
    static class Task {
        public String name;
        public int startTime;
        public int leftTime;

        public Task(String name, int startTime, int leftTime){
            this.name = name;
            this.startTime = startTime;
            this.leftTime = leftTime;
        }
    }
    // 과제가 끝난 순서
    static Queue<String> answer = new LinkedList<>();

    // 진행중이던 과제 보관
    static Stack<Task> stack = new Stack<>();
    public String[] solution(String[][] plans) {

       ArrayList<Task> list = new ArrayList<>();
       for(int i = 0; i < plans.length; i++){
           int time = calculate(plans[i][1]);
           list.add(new Task(plans[i][0], time, Integer.parseInt(plans[i][2])));
       }

       // sort 시작 시간이 빠른 순서대로
       Collections.sort(list, (o1, o2) -> {
          return o1.startTime - o2.startTime;
       });

       int time = 0;
       for(int i = 0; i < list.size(); i++){
           Task cur = list.get(i);

           int time_slice = cur.startTime - time;

           while(!stack.isEmpty() && time_slice > 0){
               Task temp = stack.pop();

               if(temp.leftTime >= time_slice){
                   temp.leftTime -= time_slice;
                   time_slice = 0;

                   if(temp.leftTime != 0){
                       stack.push(temp);
                       continue;
                   }

                   answer.add(temp.name);
               }
               else{
                   time_slice -= temp.leftTime;
                   answer.add(temp.name);
               }
           }
           stack.add(cur);
           time = cur.startTime;
       }

       String [] end = new String [list.size()];
       int cnt = 0;

       while(!answer.isEmpty()){
           end[cnt++] = answer.poll();
       }

       while(!stack.isEmpty()){
           end[cnt++] = stack.pop().name;
       }

       return end;

    }
   // 시간:분 -> 분
   public static int calculate(String input){
       String [] split = input.split(":");
       return (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
   }
}
