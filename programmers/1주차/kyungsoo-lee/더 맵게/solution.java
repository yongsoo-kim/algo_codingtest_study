package com.example.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

  public int solution(int[] scoville, int K) {
    int answer = 0;

    PriorityQueue<Integer> queue = convertIntArrToPriorityQueue(scoville);

    while(queue.peek() < K) {
      try {
        int newSpice = queue.poll() + (queue.poll() * 2);
        queue.add(newSpice);
        answer++;

      } catch(Exception e) {
        answer = -1;
        break;
      }
    }

    return answer;
  }

  private PriorityQueue<Integer> convertIntArrToPriorityQueue(int[] scoville) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(scoville.length);
    queue.addAll(Arrays.stream(scoville).boxed().collect(Collectors.toList()));
    return queue;
  }
}
