class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        # rephrase the question as count the number of merging intervals

        # sort the list
        points.sort()
        res = 1

        # loop through all the sorted points
        for i in range(1, len(points)):
            # if there is an overlap
            if points[i][0] <= points[i-1][1]:
                # we don't need a new arrow, so keep the res count as same. Update the interval (we are updating the interval as intersection because when we compare with the next element, we will only consider it if it merges with previous merging interval)
                points[i] = [points[i][0], min(points[i][1], points[i-1][1])]
            else:
                # current interval doesn't overlap, so we will need a new arrow
                res += 1
        return res
