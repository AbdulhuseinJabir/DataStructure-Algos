class Solution {
    public List<List> threeSum(int[] nums) {
        List<List> list = new ArrayList<>();
        Arrays.sort(nums);
        if (nums == null || nums.length <= 2)
            return list;
        int i = 0;
        while (i < nums.length - 2) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int target = nums[i] + nums[j] + nums[k];
                if (target < 0)
                    j++;
                else if (target > 0)
                    k--;
                else {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while ((j + 1 < nums.length - 1) && (nums[j] == nums[j + 1]))
                        j++;
                    while ((k - 1 > j) && (nums[k] == nums[k - 1]))
                        k--;
                    j++;
                    k--;
                }
            }
            while ((i + 1 < nums.length - 2) && (nums[i] == nums[i + 1])) {
                i++;
            }
            i++;
        }
        return list;
    }
}
