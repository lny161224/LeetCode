//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 1911 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int find(int[] nums, int a, int b, int target) {
        int flag = -1;
        if (a >= b) flag = target == nums[a] ? a : -1;
        else {
            int mid_index = (a + b) / 2;
            int mid = nums[mid_index];
            if (target == mid) flag = mid_index;
            else if (target < mid) flag = find(nums, a, mid_index - 1, target);
            else flag = find(nums, mid_index + 1, b, target);
        }
        return flag;
    }

    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int[] re = new int[2];
        if (nums.length == 0) {
            re[0] = start;
            re[1] = end;
            return re;
        }
        int flag = find(nums, 0, nums.length - 1, target);
        if (flag != -1) {
            start = flag;
            end = flag;
            for (int i = flag - 1; i >= 0; i--) {
                if (nums[i] != target) break;
                start--;
            }
            for (int i = flag + 1; i < nums.length; i++) {
                if (nums[i] != target) break;
                end++;
            }
        }
        re[0] = start;
        re[1] = end;
        return re;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
