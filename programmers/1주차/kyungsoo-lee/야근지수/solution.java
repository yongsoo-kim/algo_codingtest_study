package com.example.programmers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Overtime {

  @Test
  public void Test() {
    int[] works1 = {4, 3, 3};
    int[] works2 = {2, 1, 2};
    int[] works3 = {1, 1};
    int n1 = 4;
    int n2 = 1;
    int n3 = 3;
    int expected1 = 12;
    int expected2 = 6;
    int expected3 = 0;

    assertEquals(expected1, solution(n1, works1));
    assertEquals(expected2, solution(n2, works2));
    assertEquals(expected3, solution(n3, works3));
  }


  public long solution(int n, int[] works) {
    long answer = 0;

    PriorityQueue<Integer> queue = convertIntArrToPriorityQueue(works);

    Integer requiredOvertime = queue.stream().reduce(0, (num1, num2) -> num1 + num2) - n;

    if (requiredOvertime <= 0) {
      return answer;
    }

    for (int i = 0; i < n; i++) {
      queue.add(queue.poll() - 1);
    }

    for (Integer work : queue) {
      answer += Math.pow(work, 2);
    }

    return answer;
  }

  private PriorityQueue<Integer> convertIntArrToPriorityQueue(int[] works) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    queue.addAll(Arrays.stream(works).boxed().collect(Collectors.toList()));
    return queue;
  }
}
