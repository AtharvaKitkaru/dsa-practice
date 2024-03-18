class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:

        intervals.sort()

        prev = intervals[0]
        res = []

        # loop through all intervals
        for i in range(len(intervals)):
            curr = intervals[i]

            # if there is an overlap between curr and prev, then update the curr one
            if curr[0] <= prev[1]:
                curr = [min(curr[0],prev[0]),max(curr[1],prev[1])]
            else:
            # else, append previous one to result array
                res.append(prev)
            prev = curr

        res.append(prev)
        return res