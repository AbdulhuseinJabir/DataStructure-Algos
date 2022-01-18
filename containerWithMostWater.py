# Given n non-negative integers a1, a2, ..., an , where each represents a point 
# at coordinate (i, ai). n vertical lines are drawn such that the two endpoints 
# of the line i is at (i, ai) and (i, 0). Find two lines, which, together with 
# the x-axis forms a container, such that the container contains the most water.

class Solution:
    def __init__(self):
        pass

    def On2(self, height: list[int]) -> int:
        maxArea = 0
        for i in range (0, len(height)):
            for j in range(1, len(height)):
                maxArea = max(maxArea, ((j-i) * (min(height[i], height[j]))))
        return maxArea

    def On(self, height: list[int]) -> int:
        maxArea = 0
        i = 0 # This is the front pointer
        j = len(height) - 1 # This is the end pointer
        minHeight = 0
        while i < j: # while front is before end
            maxArea = max(maxArea, ((j-i) * (min(height[i], height[j])))) # The maxArea will be different in x-axis and multiplying with Minimum of the two heights
            if (height[i] <= height[j]):
                minHeight = height[i] # This is a temporary variable
                while i < len(height) and height[i] <= minHeight: # Keep traversing the front pointer (which is shorter than the end pointer) to the right if its adjacent height to the right is smaller. This is to increase efficiency.
                    i+=1
            else:
                minHeight = height[j]
                while j >= 0 and height[j] <= minHeight: # Keep traversing the end pointer (which is shorter than the front pointer) to the left if its adjacent height to the left is smaller. This is to increase efficiency.
                    j-=1
        return maxArea        

if __name__ == "__main__":
    solution = Solution()
    print(solution.On2([4,3,2,1,4]))
    print(solution.On([4,3,2,1,4]))