package com.example.programmers;

import java.util.*;

public class Solution {

  final static int TASK_COMPLETE_RATE = 100;

  public int[] solution(int[] progresses, int[] speeds) {
    List<Integer> answer = new ArrayList<>();
    Queue<Integer> restDayQueue = new LinkedList<>();

    for (int i=0; i < progresses.length; i++) {
      int restProcess = TASK_COMPLETE_RATE - progresses[i];
      double restDay = restProcess / (double) speeds[i];
      restDayQueue.add((int) Math.ceil(restDay));
    }

    Integer maxDay = restDayQueue.poll();
    Integer numOfDeploy = 1;
    for (Integer restDay : restDayQueue) {
      if (maxDay < restDay) {
        answer.add(numOfDeploy);
        numOfDeploy = 1;
        maxDay = restDay;
      } else {
        numOfDeploy++;
      }
    }

    if ( numOfDeploy != 0) {
      answer.add(numOfDeploy);
    }

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}

