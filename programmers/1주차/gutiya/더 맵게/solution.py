import heapq


def solution(scoville, K):
    scoville.sort()
    sco_heap = []

    for value in scoville:
        heapq.heappush(sco_heap, value)

    cnt = 1
    while len(scoville) >= 2:
        val1 = heapq.heappop(sco_heap)
        val2 = heapq.heappop(sco_heap)

        mixed = val1 + (val2 * 2)
        heapq.heappush(sco_heap, mixed)

        if mixed >= K:
            return cnt

        cnt = cnt + 1

    answer = -1

    return answer
