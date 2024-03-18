class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        print(intervals)
        count = 0
        prev = intervals[0]

        for i in range(1,len(intervals)):
            curr = intervals[i]

            #if there's an overlap
            if curr[0] < prev[1]:
                # we need to remove one element
                count += 1
                # the element to be removed is the one which ends first
                if curr[1] < prev[1]:
                    prev = curr
            else:
                prev = curr

        return count