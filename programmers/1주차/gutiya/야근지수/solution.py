import heapq


def solution(n, works):
    works_heap = []

    for value in works:
        heapq.heappush(works_heap, value)

    heapq._heapify_max(works_heap)

    while (n > 0):
        if len(works_heap) > 0:
            work = heapq.heappop(works_heap)

            if work == 0:
                break

            heapq.heappush(works_heap, (work - 1))
            heapq._heapify_max(works_heap)
            n -= 1

            print("#### after: ", works_heap)

    answer = 0
    while len(works_heap) > 0:
        work = heapq.heappop(works_heap)
        answer += pow(work, 2)

    return answer
