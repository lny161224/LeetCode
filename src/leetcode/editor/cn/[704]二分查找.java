//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
//
// Related Topics 数组 二分查找 👍 990 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int find(int[] nums, int a, int b, int target){
        int flag = -1;
        if(a>=b)flag = target == nums[a] ? a:-1;
        else {
            int mid_index = (a + b) / 2;
            int mid = nums[mid_index];
            if (target == mid) flag = mid_index;
            else if(target < mid) flag = find(nums, a, mid_index - 1, target);
            else flag = find(nums, mid_index + 1, b, target);
        }
        return flag;
    }
    public int search(int[] nums, int target) {
        return find(nums,0,nums.length-1,target);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
