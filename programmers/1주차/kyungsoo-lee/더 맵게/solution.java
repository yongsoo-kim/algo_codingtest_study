package com.example.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

  public int solution(int[] scoville, int K) {
    int answer = 0;

    PriorityQueue<Integer> queue = convertIntArrToPriorityQueue(scoville);

    while(queue.size() > 1) {
      int lowest = (int) queue.poll();
      if (lowest > K) {
        break;
      }
      int lower  = (int) queue.poll();
      queue.add(getMixedScoville(lowest, lower));
      answer++;
    }

    if (queue.size() == 1 && queue.peek() <= K) {
      return -1;
    }

    return answer;
  }

  private PriorityQueue<Integer> convertIntArrToPriorityQueue(int[] scoville) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(scoville.length);
    queue.addAll(Arrays.stream(scoville).boxed().collect(Collectors.toList()));
    return queue;
  }

  private int getMixedScoville(int lowest, int lower) {
    if (lower == 0) {
      return lowest;
    }
    return lowest + (lower * 2);
  }
}
